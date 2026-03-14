# Roadmap de Continuação — DS Gym House

Este roteiro organiza os próximos passos para evoluir a especificação do produto.

## Fase 1 — Especificação técnica da v1

### 1. Contratos de API (prioridade alta)
Criar um documento com endpoints iniciais:

- autenticação (login/cadastro)
- catálogo de treinos
- detalhes de treino
- registrar conclusão
- histórico do aluno
- gestão de conteúdo (admin/instrutor)

### 2. Modelo de domínio (prioridade alta)
Definir entidades e relações:

- User
- Workout
- WorkoutContent
- WorkoutCategory
- WorkoutCompletion

### 3. Regras de validação por endpoint
Formalizar validações de entrada e erros esperados.

## Fase 2 — Backlog executável

### 4. Quebrar features em entregas pequenas
Exemplo:

- Sprint A: catálogo + detalhes
- Sprint B: treino guiado + conclusão
- Sprint C: histórico + gestão de conteúdo

### 5. Critérios de aceite viram teste
Mapear cada critério para casos de teste funcionais.

## Fase 3 — Preparar implementação

### 6. Estrutura de pastas de código
Definir arquitetura alvo (ex.: API + app web/mobile).

### 7. Priorização por valor
Ordenar backlog por impacto no usuário e risco técnico.

---

## Sugestão de próximo arquivo para criar agora

`specs/05-technical-specs/api-contracts-v1.md`

Com seções:
- visão geral da API
- convenções de payload
- endpoints por feature
- exemplos de request/response
- erros e códigos HTTP
