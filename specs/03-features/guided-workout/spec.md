# Feature Spec — Execução de Treino Guiado

## Objetivo
Permitir que o aluno execute um treino usando vídeo, link externo ou instruções em texto.

## Valor de negócio
Entrega a principal experiência do produto: treino orientado dentro de casa.

## Atores envolvidos

- aluno;
- sistema.

## Pré-condições

- o treino deve estar publicado;
- o aluno deve conseguir acessar os detalhes do treino;
- o conteúdo deve estar associado a um formato válido.

## Entradas

- treino selecionado;
- formato do conteúdo;
- ação de iniciar treino.

## Saídas

- conteúdo do treino exibido;
- etapas ou instruções da sessão;
- status de treino em andamento ou concluído.

## Regras de negócio

- um treino pode ser em vídeo interno, link externo ou texto;
- o sistema deve exibir orientações mínimas de execução;
- o treino pode ser marcado como concluído ao final.
- o formato do treino deve ser identificado antes do início;
- conteúdos textuais devem conter sequência mínima de instruções;
- links externos devem estar associados ao treino de forma explícita.

## Conteúdo mínimo exibido

- nome do treino;
- objetivo;
- duração estimada;
- instruções ou mídia principal;
- ação para conclusão da sessão.

## Fluxo principal

1. O aluno abre os detalhes do treino.
2. O sistema apresenta o conteúdo.
3. O aluno executa os exercícios.
4. O aluno finaliza a sessão.
5. O sistema registra a conclusão do treino.

## Fluxos alternativos

### FA01 — Treino em texto
1. O aluno abre o treino.
2. O sistema apresenta instruções textuais estruturadas.
3. O aluno segue as orientações e conclui a sessão.

### FA02 — Treino com link externo
1. O aluno abre o treino.
2. O sistema apresenta o link de conteúdo externo.
3. O aluno acessa o recurso e retorna para concluir o treino.

## Exceções

### EX01 — Conteúdo indisponível
1. O aluno tenta iniciar o treino.
2. O sistema identifica conteúdo inválido ou indisponível.
3. O sistema informa o problema e não registra conclusão automática.

## Validações

- o sistema só deve permitir conclusão após o treino ter sido iniciado;
- o conteúdo precisa estar associado a um formato suportado;
- dados mínimos do treino devem estar visíveis durante a execução.

## Critérios de aceitação

- o aluno consegue iniciar um treino a partir da tela de detalhes;
- o sistema suporta treino em vídeo, link externo e texto;
- o aluno consegue concluir o treino ao final;
- problemas de conteúdo são informados sem gerar falso registro de progresso.

## Rastreabilidade

- RF05 — Visualização de detalhes do treino;
- RF06 — Execução de treino guiado;
- RF07 — Registro de conclusão;
- HU02 — Ver detalhes antes de iniciar;
- HU03 — Realizar treino guiado.
