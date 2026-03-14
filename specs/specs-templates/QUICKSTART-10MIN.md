# Quickstart SDD — 10 minutos

Este guia ajuda você a iniciar um novo projeto com base nos templates em `specs/specs-templates`.

## Objetivo
Sair de **ideia** para **base SDD organizada** em aproximadamente 10 minutos.

---

## Minuto 0–1 — Copiar estrutura

1. Copie a pasta `specs/specs-templates` para o novo projeto.
2. Renomeie `specs-templates` para `specs` (se o projeto ainda não tiver specs).

> Se o projeto já tiver `specs/`, copie apenas os arquivos template necessários.

---

## Minuto 1–3 — Product vision

Preencha os arquivos em `00-product-vision/`:

- `template-visao-do-produto.md`
- `template-proposta-de-valor.md`
- `template-escopo-inicial-e-premissas.md`
- `template-objetivos-do-produto.md`

### Resultado esperado
- visão do produto clara;
- escopo inicial definido;
- premissas e objetivos explícitos.

---

## Minuto 3–5 — Discovery

Preencha os arquivos em `01-discovery/`:

- `template-personas.md`
- `template-jornada-do-usuario.md`
- `template-regras-de-negocio-iniciais.md`
- `template-glossario.md`

### Resultado esperado
- entendimento do usuário e do domínio;
- fluxo principal mapeado;
- linguagem do domínio padronizada.

---

## Minuto 5–7 — Requirements

Preencha os arquivos em `02-requirements/`:

- `template-requisitos-funcionais.md`
- `template-requisitos-nao-funcionais.md`
- `template-historias-de-usuario.md`

### Resultado esperado
- requisitos funcionais e não funcionais formalizados;
- histórias de usuário com critérios de aceitação.

---

## Minuto 7–9 — Features

1. Para cada funcionalidade principal, crie uma subpasta em `03-features/`.
2. Copie `template-feature-spec.md` para cada subpasta.
3. Use `template-feature-checklist.md` para revisar qualidade.

### Resultado esperado
- specs por feature com regras, fluxos e validações;
- rastreabilidade entre RF/HU e implementação.

---

## Minuto 9–10 — Diagramas

1. Use `04-diagrams/template-context.drawio` como base.
2. Ajuste atores, sistema e dependências.
3. Opcional: crie jornada e módulos conceituais.

### Resultado esperado
- visão visual rápida do sistema;
- alinhamento entre negócio e técnico.

---

## Checklist final de saída

- [ ] Product vision preenchido
- [ ] Discovery preenchido
- [ ] Requirements preenchidos
- [ ] Pelo menos 1 feature spec detalhada
- [ ] 1 diagrama de contexto criado
- [ ] Placeholders `{{...}}` removidos dos arquivos finais

---

## Fluxo recomendado após o quickstart

1. Revisar specs com stakeholders.
2. Priorizar features por valor de negócio.
3. Quebrar implementação em incrementos pequenos.
4. Derivar testes dos critérios de aceitação.
5. Evoluir specs junto com o código.

---

## Dica prática

Se quiser velocidade máxima, comece com:

- 1 persona principal;
- 1 jornada principal;
- 5 requisitos funcionais;
- 3 histórias de usuário;
- 1 feature crítica bem detalhada.

Isso já é suficiente para iniciar um ciclo real de implementação com SDD.
