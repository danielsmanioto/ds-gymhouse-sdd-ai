# Feature Spec — Gestão de Conteúdo

## Objetivo
Permitir que instrutores ou administradores cadastrem e organizem treinos.

## Valor de negócio
Garante que a plataforma tenha conteúdo estruturado e atualizado.

## Atores envolvidos

- instrutor;
- administrador;
- sistema.

## Pré-condições

- o usuário deve estar autenticado;
- o usuário deve possuir permissão de gestão de conteúdo;
- a plataforma deve possuir categorias e classificações disponíveis.

## Entradas

- título do treino;
- objetivo;
- nível;
- duração;
- tipo de conteúdo;
- link, mídia ou instrução textual.

## Saídas

- treino cadastrado;
- treino atualizado;
- confirmação de publicação.

## Regras de negócio

- somente perfis autorizados podem cadastrar conteúdo;
- todo treino deve ter metadados mínimos;
- o conteúdo deve ser categorizado antes da publicação.
- um treino pode ser salvo como rascunho antes da publicação;
- conteúdos publicados devem estar prontos para exibição no catálogo;
- atualizações devem preservar consistência dos dados obrigatórios.

## Campos mínimos obrigatórios

- título;
- objetivo;
- nível;
- duração estimada;
- formato do conteúdo;
- instrução textual ou referência de mídia;
- categoria.

## Fluxo principal

1. O instrutor acessa a área administrativa.
2. O sistema apresenta formulário de cadastro.
3. O instrutor preenche os dados.
4. O sistema valida as informações.
5. O treino é salvo e publicado.

## Fluxos alternativos

### FA01 — Salvar como rascunho
1. O instrutor preenche parcialmente os dados.
2. O sistema permite salvar o treino sem publicação.

### FA02 — Editar treino existente
1. O usuário autorizado seleciona um treino cadastrado.
2. O sistema apresenta os dados atuais.
3. O usuário edita e salva as alterações.

## Exceções

### EX01 — Dados obrigatórios ausentes
1. O usuário tenta publicar o treino.
2. O sistema detecta campos mínimos faltantes.
3. O sistema bloqueia a publicação e informa os ajustes necessários.

## Validações

- somente usuários autorizados podem publicar conteúdo;
- o formato do treino deve ser compatível com os dados enviados;
- links externos devem ter formato válido;
- o treino não deve ser publicado sem categoria e metadados essenciais.

## Critérios de aceitação

- instrutores e administradores autorizados conseguem cadastrar treinos;
- o sistema valida os campos obrigatórios antes da publicação;
- o sistema permite editar treinos existentes;
- conteúdos incompletos não são publicados.

## Rastreabilidade

- RF09 — Cadastro de conteúdo;
- RF10 — Edição de conteúdo;
- RF11 — Publicação de treino;
- RF12 — Organização por categorias;
- HU05 — Publicar treinos;
- HU06 — Manter catálogo organizado.
