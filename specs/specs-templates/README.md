# Specs Templates (Reutilizável)

Este diretório contém templates de **Spec-Driven Development (SDD)** para reaproveitar em outros projetos.

## Início rápido

Use [QUICKSTART-10MIN.md](QUICKSTART-10MIN.md) para montar a base inicial em poucos minutos.

Para fluxo express, use [QUICKSTART-5MIN.md](QUICKSTART-5MIN.md).

Para validação do setup inicial, use [ONBOARDING-CHECKLIST.md](ONBOARDING-CHECKLIST.md).

Para iniciar por um único arquivo mestre, use [PROJECT-SEED.md](PROJECT-SEED.md).

## Como usar

1. Copie a pasta `specs/specs-templates` para o projeto novo.
2. Renomeie os arquivos `template-*.md` para o nome final desejado.
3. Substitua os placeholders no formato `{{...}}`.
4. Remova seções que não façam sentido para o contexto.

## Estrutura

- `00-product-vision/`: visão, proposta de valor, escopo e objetivos.
- `01-discovery/`: personas, jornada, regras de negócio e glossário.
- `02-requirements/`: requisitos funcionais, não funcionais e histórias de usuário.
- `03-features/`: template de especificação de feature.
- `04-diagrams/`: guia para diagramas e template draw.io.

## Convenção de placeholders

- `{{project_name}}`
- `{{domain}}`
- `{{actor_name}}`
- `{{business_goal}}`
- `{{feature_name}}`
- `{{rf_id}}`, `{{hu_id}}`

## Observação

Estes templates são propositalmente objetivos para facilitar adaptação rápida.
