# Quickstart SDD — 5 minutos (Express)

Versão enxuta para sair do zero e iniciar implementação com base mínima de SDD.

## Objetivo
Em 5 minutos, criar um pacote inicial com visão, requisitos, 1 feature crítica e 1 diagrama.

---

## Minuto 0–1 — Definir núcleo do produto

Preencha apenas o essencial em:

- `00-product-vision/template-visao-do-produto.md`

Campos obrigatórios mínimos:

- `{{project_name}}`
- `{{one_sentence_product_vision}}`
- `{{problem_statement}}`

---

## Minuto 1–2 — Descoberta mínima

Preencha rapidamente:

- `01-discovery/template-personas.md` (somente Persona 1)
- `01-discovery/template-jornada-do-usuario.md` (somente jornada principal)

Foco:

- quem usa;
- dor principal;
- fluxo principal ponta a ponta.

---

## Minuto 2–3 — Requisitos mínimos

Preencha:

- `02-requirements/template-requisitos-funcionais.md` (3 a 5 RF)
- `02-requirements/template-historias-de-usuario.md` (2 a 3 HU)

Dica: escreva RF diretamente conectados à jornada principal.

---

## Minuto 3–4 — Uma feature crítica

1. Crie uma pasta em `03-features/` com o nome da feature mais importante.
2. Copie `03-features/template-feature-spec.md`.
3. Preencha no mínimo:
   - objetivo;
   - atores;
   - fluxo principal;
   - critérios de aceitação;
   - rastreabilidade (RF/HU).

---

## Minuto 4–5 — Um diagrama de contexto

1. Copie `04-diagrams/template-context.drawio`.
2. Renomeie para `{{project_slug}}-context.drawio`.
3. Ajuste apenas:
   - atores;
   - sistema central;
   - 1 ou 2 dependências principais.

---

## Pacote mínimo de saída

- [ ] visão do produto (1 arquivo)
- [ ] discovery mínima (persona + jornada)
- [ ] 3–5 requisitos funcionais
- [ ] 2–3 histórias de usuário
- [ ] 1 feature spec crítica
- [ ] 1 diagrama draw.io de contexto

---

## Regra prática de qualidade

Se o time conseguir responder claramente **o quê, para quem, por quê e como validar**, a base está pronta para começar implementação incremental.
