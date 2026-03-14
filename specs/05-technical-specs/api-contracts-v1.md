# API Contracts v1 — DS Gym House

## Convenções gerais

- Base path: `/api/v1`
- Formato: `application/json`
- Autenticação: `Bearer token` (quando aplicável)
- Timezone: `UTC`
- Paginação padrão (quando aplicável): `page` (default `1`) e `pageSize` (default `20`, máx `100`)
- Formato de data: ISO 8601 UTC (`YYYY-MM-DDTHH:mm:ssZ`)
- Content negotiation: `Accept: application/json`

## Modelo de erro (padrão)

```json
{
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Descrição legível do problema",
    "details": []
  }
}
```

### Catálogo de códigos de erro

- `VALIDATION_ERROR`: payload inválido.
- `AUTH_INVALID_CREDENTIALS`: login/senha inválidos.
- `AUTH_EMAIL_ALREADY_EXISTS`: e-mail já cadastrado.
- `UNAUTHORIZED`: token ausente/inválido.
- `FORBIDDEN`: usuário sem permissão para recurso.
- `NOT_FOUND`: recurso não encontrado.
- `BUSINESS_RULE_VIOLATION`: regra de negócio violada.

---

## 1) Autenticação

### POST /auth/register
Cria conta de aluno.

Campos obrigatórios:
- `name` (string, 2–120)
- `email` (string, formato e-mail)
- `password` (string, mínimo 8, ao menos 1 letra e 1 número)

Validações:
- e-mail deve ser único no sistema;
- `name` não pode conter apenas espaços;
- senha não pode ser igual ao e-mail.

Request:
```json
{
  "name": "Marina",
  "email": "marina@email.com",
  "password": "SenhaForte123"
}
```

Response 201:
```json
{
  "id": "usr_001",
  "name": "Marina",
  "email": "marina@email.com"
}
```

Exemplos de erro:

`400 VALIDATION_ERROR`
```json
{
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Dados de entrada inválidos",
    "details": [
      { "field": "password", "issue": "mínimo de 8 caracteres" }
    ]
  }
}
```

`422 AUTH_EMAIL_ALREADY_EXISTS`
```json
{
  "error": {
    "code": "AUTH_EMAIL_ALREADY_EXISTS",
    "message": "E-mail já cadastrado",
    "details": []
  }
}
```

### POST /auth/login
Autentica usuário.

Campos obrigatórios:
- `email`
- `password`

Validações:
- e-mail deve existir;
- senha deve corresponder ao usuário;
- usuário deve estar ativo.

Request:
```json
{
  "email": "marina@email.com",
  "password": "SenhaForte123"
}
```

Response 200:
```json
{
  "accessToken": "jwt-token",
  "tokenType": "Bearer",
  "expiresIn": 3600
}
```

Exemplo de erro:

`401 AUTH_INVALID_CREDENTIALS`
```json
{
  "error": {
    "code": "AUTH_INVALID_CREDENTIALS",
    "message": "Credenciais inválidas",
    "details": []
  }
}
```

---

## 2) Catálogo de treinos

### GET /workouts
Lista treinos com filtros opcionais.

Query params:
- `goal`
- `level`
- `durationMax`
- `format` (`video`, `external_link`, `text`)
- `page`
- `pageSize`

Validações:
- `durationMax` deve ser número inteiro positivo;
- `format` deve respeitar enum;
- `page` e `pageSize` devem ser inteiros positivos.

Response 200:
```json
{
  "items": [
    {
      "id": "wrk_001",
      "title": "Treino Funcional 30min",
      "goal": "condicionamento",
      "level": "iniciante",
      "durationMinutes": 30,
      "format": "video"
    }
  ],
  "total": 1,
  "page": 1,
  "pageSize": 20
}
```

Exemplo de erro:

`400 VALIDATION_ERROR`
```json
{
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Parâmetros de consulta inválidos",
    "details": [
      { "field": "format", "issue": "valor fora do enum permitido" }
    ]
  }
}
```

### GET /workouts/{workoutId}
Retorna detalhes do treino.

Validações:
- `workoutId` deve existir;
- treino deve estar publicado para usuário aluno.

Response 200:
```json
{
  "id": "wrk_001",
  "title": "Treino Funcional 30min",
  "goal": "condicionamento",
  "level": "iniciante",
  "durationMinutes": 30,
  "format": "video",
  "instructions": "Aquecimento + circuito",
  "contentUrl": "https://..."
}
```

Exemplo de erro:

`404 NOT_FOUND`
```json
{
  "error": {
    "code": "NOT_FOUND",
    "message": "Treino não encontrado",
    "details": []
  }
}
```

---

## 3) Execução e progresso

### POST /workouts/{workoutId}/complete
Registra conclusão do treino.

Autenticação: requerida.

Campos obrigatórios:
- `completedAt` (ISO 8601 UTC)

Validações:
- `workoutId` deve existir e estar disponível;
- `completedAt` não pode estar no futuro;
- evitar duplicidade exata de conclusão (mesmo usuário, treino e timestamp).

Request:
```json
{
  "completedAt": "2026-03-14T10:00:00Z"
}
```

Response 201:
```json
{
  "completionId": "cmp_001",
  "workoutId": "wrk_001",
  "userId": "usr_001",
  "completedAt": "2026-03-14T10:00:00Z"
}
```

Exemplos de erro:

`401 UNAUTHORIZED`
```json
{
  "error": {
    "code": "UNAUTHORIZED",
    "message": "Token ausente ou inválido",
    "details": []
  }
}
```

`422 BUSINESS_RULE_VIOLATION`
```json
{
  "error": {
    "code": "BUSINESS_RULE_VIOLATION",
    "message": "Conclusão duplicada para o mesmo registro",
    "details": []
  }
}
```

### GET /me/progress
Retorna resumo e histórico do usuário autenticado.

Autenticação: requerida.

Query params opcionais:
- `from` (ISO 8601)
- `to` (ISO 8601)
- `page`
- `pageSize`

Validações:
- `from` <= `to`;
- intervalo de datas válido;
- paginação válida.

Response 200:
```json
{
  "summary": {
    "totalCompleted": 12,
    "lastCompletedAt": "2026-03-14T10:00:00Z"
  },
  "history": [
    {
      "completionId": "cmp_001",
      "workoutId": "wrk_001",
      "title": "Treino Funcional 30min",
      "completedAt": "2026-03-14T10:00:00Z"
    }
  ],
  "page": 1,
  "pageSize": 20
}
```

Exemplo de erro:

`400 VALIDATION_ERROR`
```json
{
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Intervalo de datas inválido",
    "details": [
      { "field": "from", "issue": "deve ser menor ou igual a to" }
    ]
  }
}
```

---

## 4) Gestão de conteúdo (admin/instrutor)

### POST /admin/workouts
Cadastra novo treino.

Autenticação: requerida.

Permissão: `admin` ou `instructor`.

Campos obrigatórios:
- `title` (2–120)
- `goal` (string)
- `level` (`iniciante`, `intermediario`, `avancado`)
- `durationMinutes` (inteiro > 0)
- `format` (`video`, `external_link`, `text`)
- `category` (string)

Campos condicionais:
- se `format = text`, exigir `instructions`;
- se `format = video` ou `external_link`, exigir `contentUrl`.

Validações:
- `contentUrl` deve ser URL válida quando informado;
- treino deve conter metadados mínimos para publicação.

Request:
```json
{
  "title": "Treino Core 20min",
  "goal": "fortalecimento",
  "level": "intermediario",
  "durationMinutes": 20,
  "format": "text",
  "instructions": "3 séries de...",
  "category": "core"
}
```

Response 201:
```json
{
  "id": "wrk_010",
  "status": "published"
}
```

Exemplos de erro:

`403 FORBIDDEN`
```json
{
  "error": {
    "code": "FORBIDDEN",
    "message": "Sem permissão para publicar treinos",
    "details": []
  }
}
```

`422 BUSINESS_RULE_VIOLATION`
```json
{
  "error": {
    "code": "BUSINESS_RULE_VIOLATION",
    "message": "Formato text exige instructions",
    "details": []
  }
}
```

### PUT /admin/workouts/{workoutId}
Atualiza treino existente.

Autenticação: requerida.

Permissão: `admin` ou `instructor`.

Validações:
- `workoutId` deve existir;
- alterações devem manter consistência dos campos obrigatórios;
- regras condicionais de `format` continuam válidas.

Request (exemplo):
```json
{
  "title": "Treino Core 25min",
  "durationMinutes": 25,
  "format": "text",
  "instructions": "4 séries de...",
  "category": "core"
}
```

Response 200:
```json
{
  "id": "wrk_010",
  "status": "updated"
}
```

Exemplo de erro:

`404 NOT_FOUND`
```json
{
  "error": {
    "code": "NOT_FOUND",
    "message": "Treino não encontrado para atualização",
    "details": []
  }
}
```

---

## Códigos de status esperados

- `200` sucesso de consulta/atualização
- `201` recurso criado
- `400` validação de dados
- `401` não autenticado
- `403` sem permissão
- `404` recurso não encontrado
- `422` regra de negócio violada
- `500` erro interno

## Matriz rápida de autenticação e autorização

- `/auth/register`: público
- `/auth/login`: público
- `GET /workouts`: público
- `GET /workouts/{workoutId}`: público
- `POST /workouts/{workoutId}/complete`: autenticado (aluno)
- `GET /me/progress`: autenticado (aluno)
- `POST /admin/workouts`: autenticado + perfil admin/instructor
- `PUT /admin/workouts/{workoutId}`: autenticado + perfil admin/instructor

---

## Rastreabilidade

- RF01, RF02, RF03, RF04, RF05, RF06, RF07, RF08, RF09, RF10, RF11, RF12
- HU01, HU02, HU03, HU04, HU05, HU06
