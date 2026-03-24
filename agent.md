﻿# Agent — DS Gym House (exemplo)

Visão rápida
--
Este documento descreve um "agent" de automação para o repositório DS Gym House: responsabilidades, comandos suportados e como integrá-lo ao fluxo de desenvolvimento.

Objetivo
--
- Automatizar tarefas repetitivas (rodar testes, lint, criar branch, gerar PR). 
- Servir como base para um bot CI/CD ou GitHub Action que auxilie o time.

Comandos suportados (exemplo)
--
- `run tests` — executa `mvn test` no backend e retorna resultado.
- `create branch <name>` — cria e publica uma branch no remoto.
- `open pr <title>` — cria um pull request usando `gh` quando disponível.
- `seed sample-data` — executa script de seed local (se existir).

Implementação (recomendada)
--
- Script em Node.js / Python que executa comandos shell com logs estruturados.
- Integração com GitHub Actions para execução automática em eventos (push, issue comment).

Segurança
--
- O agente não deve armazenar segredos em texto puro; usar GitHub Secrets ou variáveis de ambiente.
- Operações destrutivas (force-push, merge) requerem confirmação humana.

Observações
--
- Este é um exemplo minimalista; estender com capacidades de CI (pipeline, lint, scanning) conforme necessário.
