# Prompt — Auto PR para branches feature

Objetivo:
Criar automação no GitHub Actions para abrir automaticamente um Pull Request para `main` sempre que houver `push` em branch iniciada por `feature`.

Requisitos:
- Disparar em `push`.
- Cobrir padrões de branch `feature*` e `feature/**`.
- Base do PR: `main`.
- Evitar PR duplicado para a mesma branch.
- Usar `GITHUB_TOKEN`.
- Aplicar permissões mínimas.

Resultado esperado:
- Workflow em `.github/workflows/feature-auto-pr-to-main.yml`.
- Ao fazer push em branch `feature...`, PR aberto automaticamente para `main` (se ainda não existir).
