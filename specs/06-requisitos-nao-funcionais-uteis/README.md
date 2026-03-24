# Requisitos Não Funcionais Úteis

Este diretório concentra prompts e estratégias práticas de NFR para automações, qualidade e operação.

## Diagrama CI/CD — Auto PR (feature -> main)

```mermaid
flowchart TD
	A[Dev faz push em branch feature*] --> B[GitHub Actions: feature-auto-pr-to-main.yml]
	B --> C{Já existe PR aberto para main?}
	C -- Sim --> D[Encerrar job sem criar PR]
	C -- Não --> E[Criar PR automático: feature -> main]
	E --> F[PR disponível para revisão]
```

Referências:
- Prompt: [specs/06-requisitos-nao-funcionais-uteis/prompt-auto-pr-feature-main.md](specs/06-requisitos-nao-funcionais-uteis/prompt-auto-pr-feature-main.md)
- Workflow: [.github/workflows/feature-auto-pr-to-main.yml](.github/workflows/feature-auto-pr-to-main.yml)
