# Plano de Implementação — DS Gym House

Este documento transforma as especificações atuais em um plano executável até a entrega da v1.

## Status atual

- Base SDD concluída
- Contrato de API v1 definido
- OpenAPI e coleção Postman criadas
- Falta implementação de backend, frontend, testes e deploy

---

## Sprint 0 — Foundation (1 a 2 dias)

### Objetivo
Preparar a base de código e ambiente para desenvolvimento.

### Entregas

- [x] Definir stack oficial (backend, frontend, banco)
- [ ] Inicializar projeto backend
- [ ] Inicializar projeto frontend
- [ ] Configurar lint, formatter e scripts
- [ ] Criar `.env.example`
- [ ] Configurar Docker local (app + banco)

### Definição de stack (em andamento)

Status: ✅ concluído

#### Decisões a confirmar

- Backend: [x] Java + Spring Boot | [ ] Outro: _______
- Frontend: [ ] Next.js | [x] React + Vite | [ ] Outro: _______
- Banco: [x] PostgreSQL | [ ] MySQL | [ ] Outro: _______
- ORM (Java): [x] Spring Data JPA (Hibernate) | [ ] jOOQ | [ ] MyBatis | [ ] Outro: _______
- Auth: [x] JWT + Refresh Token | [ ] Provedor externo | [ ] Outro: _______

#### Stack já definida (parcial)

- Backend: Java + Spring Boot
- Frontend: React + Vite
- Banco: PostgreSQL
- ORM: Spring Data JPA (Hibernate)
- Auth: JWT + Refresh Token

#### Critérios para escolher

- velocidade de desenvolvimento
- curva de aprendizado do time
- facilidade de deploy
- aderência ao OpenAPI já definido

### Critério de pronto

- [ ] Aplicação sobe localmente com comando único
- [ ] Banco disponível e conexão validada

---

## Sprint 1 — Auth + Catálogo (3 a 5 dias)

### Objetivo
Entregar fluxo inicial de acesso e descoberta de treinos.

### Backend

- [ ] Implementar entidade `User`
- [ ] Implementar `POST /auth/register`
- [ ] Implementar `POST /auth/login`
- [ ] Implementar entidade `Workout`
- [ ] Implementar `GET /workouts`
- [ ] Implementar `GET /workouts/{workoutId}`
- [ ] Implementar paginação e filtros

### Frontend

- [ ] Tela de cadastro/login
- [ ] Tela de catálogo com filtros
- [ ] Tela de detalhe do treino

### Testes

- [ ] Unitários de auth
- [ ] Integração de auth e catálogo
- [ ] Validar requests no Postman

### Critério de pronto

- [ ] Usuário consegue registrar, logar e listar treinos

---

## Sprint 2 — Execução + Progresso (3 a 4 dias)

### Objetivo
Entregar fluxo principal do aluno: concluir treino e acompanhar histórico.

### Backend

- [ ] Implementar entidade `WorkoutCompletion`
- [ ] Implementar `POST /workouts/{workoutId}/complete`
- [ ] Implementar `GET /me/progress`
- [ ] Implementar validação de duplicidade de conclusão

### Frontend

- [ ] Ação “Concluir treino”
- [ ] Tela de progresso (resumo + histórico)

### Testes

- [ ] Unitários de regra de conclusão
- [ ] Integração de progresso
- [ ] Cenários negativos: `401`, `404`, `422`

### Critério de pronto

- [ ] Aluno consegue concluir treino e visualizar progresso

---

## Sprint 3 — Admin de Conteúdo (3 a 4 dias)

### Objetivo
Permitir gestão de treinos por perfil administrativo.

### Backend

- [ ] Implementar controle de papéis (`admin`, `instructor`, `aluno`)
- [ ] Implementar `POST /admin/workouts`
- [ ] Implementar `PUT /admin/workouts/{workoutId}`
- [ ] Implementar validações condicionais por formato (`text`, `video`, `external_link`)

### Frontend

- [ ] Tela de cadastro de treino
- [ ] Tela de edição de treino

### Testes

- [ ] Autorização (`403`) por perfil
- [ ] Validações de payload (`400`, `422`)

### Critério de pronto

- [ ] Admin/instrutor publica e edita treino com segurança

---

## Sprint 4 — Qualidade + Release (2 a 3 dias)

### Objetivo
Consolidar estabilidade e preparar deploy.

### Qualidade

- [ ] Cobertura mínima de testes definida e atingida
- [ ] Tratamento global de erros padronizado
- [ ] Logs estruturados
- [ ] Revisão de segurança básica (JWT, permissões, inputs)

### DevOps

- [ ] Pipeline CI (lint + test + build)
- [ ] Build de imagem Docker
- [ ] Deploy em ambiente de staging
- [ ] Checklist de release

### Critério de pronto

- [ ] v1 validada em staging com fluxo ponta a ponta

---

## Backlog técnico complementar

- [ ] Documentar modelo de domínio em `specs/05-technical-specs`
- [ ] Adicionar testes negativos na coleção Postman
- [ ] Gerar coleção de exemplos de erro por endpoint
- [ ] Definir estratégia de seed de dados para ambiente local

---

## Definition of Done (DoD) da v1

- [ ] Todos os endpoints da OpenAPI v1 implementados
- [ ] Fluxos HU01–HU06 funcionando
- [ ] Testes críticos automatizados passando
- [ ] Postman collection com cenários positivos e negativos
- [ ] Deploy em staging validado
- [ ] README com instruções de execução atualizado
