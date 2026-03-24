﻿# PRD (Product Requirements Document) — DS Gym House (resumo)

Visão geral
--
DS Gym House é uma plataforma para entrega de treinos guiados e acompanhamento de progresso para alunos e instrutores.

Problema a resolver
--
- Facilitar descoberta e execução de treinos personalizados.
- Permitir rastreamento de progresso e histórico do aluno.

Público-alvo
--
- Alunos que desejam programas de treino estruturados.
- Instrutores/Admins que gerenciam conteúdo de treinos.

Objetivos de negócio
--
- Aumentar retenção de alunos fornecendo progresso visível.
- Reduzir tempo de publicação de conteúdo para instrutores.

MVP — Escopo mínimo
--
Backend:
- Autenticação (registro, login, JWT).
- Entidade `Workout` e endpoints: `GET /workouts`, `GET /workouts/{id}`.
- Registro de conclusão de treino e endpoint de progresso (`GET /me/progress`).

Frontend:
- Telas: cadastro/login, catálogo de treinos, detalhe do treino, concluir treino.

Critérios de sucesso (MVP)
--
- Usuário registra e autentica com sucesso.
- Usuário lista e visualiza treinos.
- Usuário conclui treinos e visualiza progresso.

Requisitos não-funcionais
--
- Segurança: tokens JWT, validação de inputs.
- Observabilidade: logs estruturados, endpoints de health e metrics.
- Testes: cobertura básica de unidades e integração.

Roadmap curto prazo
--
1. Sprint 1: Auth + Catálogo (implementar endpoints e UI básica).
2. Sprint 2: Execução + Progresso (completar fluxo principal do aluno).
3. Sprint 3: Admin de Conteúdo (editor de treinos, controle de papéis).

Riscos e suposições
--
- Supõe-se que o time prefere Java+Spring Boot no backend e React+Vite no frontend.
- Risco: integração com provedores de vídeo externos pode atrasar publicação de treinos.
