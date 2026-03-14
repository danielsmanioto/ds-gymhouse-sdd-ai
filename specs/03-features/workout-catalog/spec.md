# Feature Spec — Catálogo de Treinos

## Objetivo
Permitir que o aluno visualize e filtre treinos disponíveis na plataforma.

## Valor de negócio
Facilita a descoberta de conteúdos adequados ao perfil e ao objetivo do usuário.

## Atores envolvidos

- aluno;
- sistema.

## Pré-condições

- o catálogo deve possuir treinos publicados;
- o usuário deve conseguir acessar a área de listagem;
- os treinos devem conter metadados mínimos para filtragem.

## Entradas

- objetivo do treino;
- nível do aluno;
- duração desejada;
- formato do conteúdo.

## Saídas

- lista de treinos compatíveis;
- dados resumidos de cada treino;
- filtros aplicados.

## Regras de negócio

- um treino deve possuir título, objetivo e formato;
- o catálogo deve permitir organização por categorias;
- filtros devem reduzir a lista de resultados sem perder contexto.
- a listagem deve mostrar apenas treinos disponíveis para consumo;
- o aluno deve conseguir abrir os detalhes de qualquer treino listado.

## Dados mínimos por item exibido

- título;
- objetivo principal;
- nível;
- duração estimada;
- formato do conteúdo.

## Fluxo principal

1. O aluno acessa o catálogo.
2. O sistema exibe treinos disponíveis.
3. O aluno aplica filtros.
4. O sistema atualiza a listagem.
5. O aluno escolhe um treino para visualizar detalhes.

## Fluxos alternativos

### FA01 — Sem filtros aplicados
1. O aluno acessa o catálogo.
2. O sistema apresenta a listagem padrão.

### FA02 — Nenhum resultado encontrado
1. O aluno aplica filtros.
2. O sistema não encontra treinos compatíveis.
3. O sistema informa ausência de resultados e mantém os filtros visíveis para ajuste.

## Validações

- filtros aceitos devem estar dentro dos valores suportados pela plataforma;
- combinações de filtros não devem quebrar a exibição da listagem;
- treinos incompletos não devem aparecer como publicados no catálogo.

## Critérios de aceitação

- o aluno consegue visualizar uma lista de treinos disponíveis;
- o aluno consegue filtrar treinos por objetivo, nível, duração e formato;
- cada item da listagem apresenta dados mínimos para decisão;
- o sistema informa claramente quando não houver resultados.

## Rastreabilidade

- RF03 — Catálogo de treinos;
- RF04 — Filtragem de treinos;
- HU01 — Encontrar treino adequado;
- HU02 — Ver detalhes antes de iniciar.
