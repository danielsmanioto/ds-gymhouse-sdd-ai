# PROJECT SEED — SDD Starter

Use este arquivo como ponto de partida único para iniciar qualquer projeto com SDD.

---

## 1) Contexto rápido

- **Projeto:** {{project_name}}
- **Domínio:** {{domain}}
- **Problema principal:** {{problem_statement}}
- **Usuário principal:** {{primary_user}}
- **Meta da v1:** {{v1_goal}}

---

## 2) Escopo inicial (v1)

### Inclui
- {{in_scope_1}}
- {{in_scope_2}}
- {{in_scope_3}}

### Não inclui
- {{out_scope_1}}
- {{out_scope_2}}

---

## 3) Descoberta mínima

### Persona principal
- **Nome:** {{persona_name}}
- **Objetivo:** {{persona_goal}}
- **Dor principal:** {{persona_pain}}

### Jornada principal (macro)
1. {{journey_step_1}}
2. {{journey_step_2}}
3. {{journey_step_3}}
4. {{journey_step_4}}

---

## 4) Requisitos mínimos

### Funcionais (3–5)
- **RF01:** {{rf_01}}
- **RF02:** {{rf_02}}
- **RF03:** {{rf_03}}
- **RF04:** {{rf_04_optional}}
- **RF05:** {{rf_05_optional}}

### Não funcionais (2–3)
- **RNF01:** {{rnf_01}}
- **RNF02:** {{rnf_02}}
- **RNF03:** {{rnf_03_optional}}

---

## 5) Histórias de usuário iniciais

### HU01
**Como** {{actor_01}}  
**Quero** {{desire_01}}  
**Para** {{benefit_01}}

Critérios de aceitação:
- {{ac_01_1}}
- {{ac_01_2}}

### HU02
**Como** {{actor_02}}  
**Quero** {{desire_02}}  
**Para** {{benefit_02}}

Critérios de aceitação:
- {{ac_02_1}}
- {{ac_02_2}}

---

## 6) Feature crítica inicial

- **Feature:** {{critical_feature_name}}
- **Objetivo:** {{critical_feature_objective}}
- **Fluxo principal:**
  1. {{feature_step_1}}
  2. {{feature_step_2}}
  3. {{feature_step_3}}
- **Rastreabilidade:** {{rf_links}} / {{hu_links}}

---

## 7) Diagrama mínimo

Criar: `{{project_slug}}-context.drawio`

Blocos mínimos:
- ator principal;
- sistema;
- 1–2 dependências.

---

## 8) Definition of Ready (DoR)

- [ ] placeholders `{{...}}` removidos
- [ ] RF e HU rastreados na feature crítica
- [ ] critérios de aceitação verificáveis
- [ ] escopo v1 claro
- [ ] diagrama de contexto criado

---

## 9) Próxima ação imediata

Escolha uma:

1. detalhar APIs da feature crítica;
2. derivar testes dos critérios de aceitação;
3. quebrar implementação em tarefas de 1–2 dias.
