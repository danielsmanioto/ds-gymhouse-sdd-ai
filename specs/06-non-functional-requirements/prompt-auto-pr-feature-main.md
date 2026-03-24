# Prompt — Auto PR para branches feature

Objetivo:
Criar uma estratégia de automação no GitHub Actions para abrir automaticamente um Pull Request para `main` sempre que houver `push` em qualquer branch que comece com `feature`.

Requisitos:
- Disparar no evento `push`.
- Considerar branches no padrão `feature*` e `feature/**`.
- Criar PR com base em `main`.
- Evitar PR duplicado para a mesma branch (se já existir aberto, não criar outro).
- Usar apenas `GITHUB_TOKEN` padrão do repositório.
- Definir permissões mínimas necessárias no workflow.

Resultado esperado:
- Arquivo `.github/workflows/feature-auto-pr-to-main.yml` funcional.
- Ao dar push em uma branch `feature...`, um PR para `main` é criado automaticamente (se ainda não existir).
