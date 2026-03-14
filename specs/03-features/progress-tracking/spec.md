# Feature Spec — Acompanhamento de Progresso

## Objetivo
Permitir que o aluno acompanhe histórico e frequência de treinos.

## Valor de negócio
Aumenta motivação, retenção e sensação de evolução.

## Atores envolvidos

- aluno;
- sistema.

## Pré-condições

- o aluno deve estar identificado no sistema;
- o aluno deve ter concluído pelo menos um treino para visualização histórica;
- as execuções devem estar registradas corretamente.

## Entradas

- identificação do aluno;
- treinos concluídos;
- data e horário de execução.

## Saídas

- histórico de sessões;
- total de treinos realizados;
- visão resumida de progresso.

## Regras de negócio

- somente treinos concluídos entram no histórico;
- cada conclusão deve ficar associada ao aluno e ao treino;
- o histórico deve poder ser consultado em ordem cronológica.
- o sistema deve preservar a data e hora da execução registrada;
- indicadores resumidos devem refletir apenas dados válidos do aluno autenticado.

## Indicadores mínimos sugeridos

- total de treinos concluídos;
- data da última sessão;
- histórico cronológico de execuções.

## Fluxo principal

1. O aluno conclui um treino.
2. O sistema registra a execução.
3. O aluno acessa sua área de progresso.
4. O sistema exibe histórico e indicadores básicos.

## Fluxos alternativos

### FA01 — Histórico vazio
1. O aluno acessa a área de progresso sem treinos concluídos.
2. O sistema informa que ainda não há histórico disponível.

## Exceções

### EX01 — Falha no registro da execução
1. O aluno conclui um treino.
2. O sistema não consegue persistir o registro.
3. O sistema informa a falha e evita apresentar dados inconsistentes.

## Validações

- somente execuções concluídas devem ser consideradas;
- o histórico exibido deve pertencer ao aluno autenticado;
- registros duplicados indevidos devem ser evitados.

## Critérios de aceitação

- o sistema registra treinos concluídos;
- o aluno consegue consultar seu histórico;
- o sistema mostra indicadores simples de progresso;
- o sistema comunica ausência de histórico quando apropriado.

## Rastreabilidade

- RF07 — Registro de conclusão;
- RF08 — Histórico de treinos;
- HU04 — Acompanhar progresso.
