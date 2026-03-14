# DS Gym House

**DS Gym House** é um projeto criado para demonstrar o **Spec-Driven Development (SDD) na prática**.

O objetivo deste repositório é explorar como fluxos de desenvolvimento modernos assistidos por IA podem ser combinados com **especificações claras, automação e arquitetura limpa** para construir software de forma mais eficiente.

Este projeto serve tanto como uma **plataforma de aprendizado** quanto como uma **implementação de referência** para desenvolvedores que desejam entender como **agentes de IA e desenvolvimento orientado por especificações** podem trabalhar juntos em um projeto real.

---

# O que é Spec-Driven Development (SDD)?

**Spec-Driven Development (SDD)** é uma abordagem de desenvolvimento de software em que as **funcionalidades são definidas por meio de especificações antes do início da implementação**.

Em vez de começar diretamente pelo código, os desenvolvedores primeiro escrevem uma **especificação clara descrevendo o comportamento, as regras e os resultados esperados de uma funcionalidade**.

A especificação se torna a **fonte única da verdade** do sistema.

Nos fluxos modernos de desenvolvimento, o SDD pode ser combinado com **assistentes de código e agentes de IA** para gerar automaticamente partes da implementação com base nessas especificações.

---

# Princípios Centrais do SDD

### 1. Especificação Primeiro
As funcionalidades são descritas por meio de especificações antes que qualquer código seja escrito.

### 2. Contratos Claros
Cada funcionalidade define:

- entradas
- saídas
- regras de negócio
- comportamento esperado

### 3. Amigável à Automação
As especificações podem ser usadas por:

- agentes de IA
- geração automatizada de testes
- ferramentas de documentação

### 4. Fonte Única da Verdade
A especificação define como o sistema deve se comportar, ajudando a manter a consistência entre documentação, testes e implementação.

---

# Objetivos do Projeto

Os principais objetivos do **DS Gym House** são:

- Demonstrar o **Spec-Driven Development na prática**
- Explorar **fluxos de desenvolvimento assistidos por IA**
- Organizar funcionalidades usando **especificações claras**
- Manter uma **arquitetura limpa e escalável**
- Oferecer um **ambiente de aprendizado para experimentação**

---

# História do Sistema

Imagine uma pessoa que quer cuidar da saúde, ganhar condicionamento físico ou manter uma rotina de exercícios, mas nem sempre consegue frequentar uma academia tradicional. Ela treina em casa, em horários variados, com equipamentos simples ou até mesmo apenas com o peso do corpo. Apesar da motivação, essa pessoa muitas vezes encontra dificuldades para organizar os treinos, acompanhar sua evolução e escolher conteúdos adequados para cada objetivo.

O **DS Gym House** nasce para resolver esse cenário, funcionando como uma plataforma de treino guiado para academia em casa. A proposta é oferecer uma experiência prática, acessível e personalizada, permitindo que o usuário encontre treinos prontos e siga orientações de forma simples, seja pelo celular, tablet ou computador.

Dentro do sistema, o usuário poderá acessar diferentes formatos de conteúdo para executar seus treinos:

- **treinos online guiados**, acompanhados em tempo real ou por streaming;
- **treinos salvos na plataforma**, organizados por objetivo, nível ou duração;
- **treinos com links externos**, como vídeos do YouTube;
- **instruções em texto**, com detalhes de execução, séries, repetições, tempo de descanso e observações importantes.

A ideia é que cada treino funcione como um roteiro claro. O usuário escolhe seu objetivo, encontra uma sugestão adequada e segue cada etapa com segurança. Em alguns casos, ele poderá apenas ler as instruções; em outros, assistir a um vídeo explicativo; e, em experiências mais completas, acompanhar um treino guiado online.

Além de consumir o conteúdo, o sistema também pode evoluir para registrar preferências, histórico e progresso do aluno. Isso permite criar uma jornada mais inteligente, em que a plataforma entende o perfil do usuário e oferece treinos mais compatíveis com sua realidade, como treinos rápidos para dias corridos, treinos iniciantes para novos alunos ou treinos mais intensos para usuários avançados.

Do ponto de vista de negócio, o sistema atende tanto alunos quanto profissionais. Os alunos ganham autonomia para treinar em casa com mais orientação e consistência. Já professores, personal trainers ou administradores da plataforma podem cadastrar e organizar conteúdos, estruturar programas de treino e disponibilizar materiais em diferentes formatos.

Em resumo, a história do **DS Gym House** é a de uma plataforma criada para transformar a casa do aluno em um ambiente de treino orientado, flexível e digital. O sistema conecta planejamento, conteúdo e acompanhamento para tornar a prática de exercícios mais acessível, organizada e motivadora.

Essa visão será a base para a definição dos requisitos, fluxos de usuário, regras de negócio e especificações funcionais usando **Spec-Driven Development (SDD)**.

---

# Como o SDD Funciona Neste Projeto

O fluxo utilizado neste repositório segue uma **abordagem orientada por especificação**:

1. Uma especificação de funcionalidade é criada na pasta `specs/`.
2. A especificação descreve:
   - a funcionalidade
   - o comportamento da API
   - as regras de validação
   - as respostas esperadas
3. Assistentes de código com IA podem ler a especificação e ajudar a gerar:
   - controllers
   - services
   - repositories
   - testes
4. Os desenvolvedores revisam, refinam e evoluem a implementação.

Esse fluxo incentiva **melhor design, comunicação mais clara e iteração mais rápida**.

---

# Estrutura do Projeto

O repositório é organizado para separar claramente **especificações, código-fonte e testes**.

## Estrutura inicial proposta

```text
.
├── README.md
├── docs/
│   └── case-study/
│       └── estudo-de-caso.md
└── specs/
   ├── README.md
   ├── 00-product-vision/
   │   ├── README.md
   │   ├── escopo-inicial-e-premissas.md
   │   ├── objetivos-do-produto.md
   │   ├── proposta-de-valor.md
   │   └── visao-do-produto.md
   ├── 01-discovery/
   │   ├── README.md
   │   ├── glossario.md
   │   ├── jornada-do-usuario.md
   │   ├── personas.md
   │   └── regras-de-negocio-iniciais.md
   ├── 02-requirements/
   │   ├── README.md
   │   ├── historias-de-usuario.md
   │   ├── requisitos-funcionais.md
   │   └── requisitos-nao-funcionais.md
   ├── 03-features/
   │   ├── README.md
   │   ├── content-management/
   │   │   └── spec.md
   │   ├── guided-workout/
   │   │   └── spec.md
   │   ├── progress-tracking/
   │   │   └── spec.md
   │   └── workout-catalog/
   │       └── spec.md
   ├── 04-diagrams/
      ├── README.md
      ├── ds-gym-house-context.drawio
      ├── ds-gym-house-modules.drawio
      └── ds-gym-house-user-journey.drawio
   ├── 05-technical-specs/
   │   ├── README.md
   │   └── api-contracts-v1.md
   
   └── specs-templates/
      ├── README.md
      ├── 00-product-vision/
      ├── 01-discovery/
      ├── 02-requirements/
      ├── 03-features/
      └── 04-diagrams/
```

## Passo a passo da organização SDD

### Passo 1 — Registrar o contexto do produto

Antes de escrever requisitos, começamos com uma visão clara do problema e da solução.

- O estudo de caso foi criado em `docs/case-study/estudo-de-caso.md`
- Esse documento descreve o cenário, os atores, os objetivos e o escopo inicial do sistema

### Passo 2 — Organizar a base de especificações

A pasta `specs/` foi criada para concentrar todos os artefatos do processo de **Spec-Driven Development**.

- `00-product-vision/`: visão do produto e proposta de valor
- `01-discovery/`: descoberta do domínio, atores e regras iniciais
- `02-requirements/`: requisitos funcionais, não funcionais e histórias de usuário
- `03-features/`: especificações por funcionalidade
- `04-diagrams/`: diagramas de apoio ao entendimento do sistema

### Passo 3 — Separar as funcionalidades principais

Para não misturar tudo em um único documento, as primeiras features foram divididas em subpastas próprias:

- `workout-catalog`: catálogo e filtragem de treinos
- `guided-workout`: execução do treino guiado
- `content-management`: cadastro e publicação de conteúdos
- `progress-tracking`: histórico e progresso do aluno

Cada uma dessas funcionalidades já possui um `spec.md` detalhado para servir de base à implementação e aos testes.

### Passo 4 — Criar um diagrama simples do contexto

Também foi criado um diagrama em draw.io para representar, de forma visual e simples, a ideia central do sistema.

- Arquivo do diagrama: `specs/04-diagrams/ds-gym-house-context.drawio`
- O diagrama mostra os atores principais, a plataforma e os blocos centrais de conteúdo e progresso

### Passo 5 — Detalhar as especificações por funcionalidade

As features principais foram refinadas com foco em uso real no processo SDD.

- atores envolvidos;
- pré-condições;
- regras de negócio;
- fluxos principais e alternativos;
- validações;
- critérios de aceitação;
- rastreabilidade com requisitos e histórias de usuário.

### Passo 6 — Preparar a evolução do projeto

Com essa base, o próximo ciclo natural do SDD pode seguir esta ordem:

1. modelar entidades e relações do domínio;
2. definir contratos de API e payloads iniciais;
3. escrever especificações técnicas por endpoint ou caso de uso;
4. organizar backlog de implementação por feature;
5. derivar testes a partir dos critérios de aceitação.

## Artefatos criados nesta etapa

- Estudo de caso: `docs/case-study/estudo-de-caso.md`
- Guia da estrutura SDD: `specs/README.md`
- Product vision: `specs/00-product-vision/`
- Discovery: `specs/01-discovery/`
- Requirements: `specs/02-requirements/`
- Features detalhadas: `specs/03-features/`
- Diagramas draw.io: `specs/04-diagrams/`
- Templates reutilizáveis: `specs/specs-templates/`

## Estado atual do projeto

Neste momento, o projeto já possui uma base SDD consistente para seguir para modelagem técnica e implementação.

- visão do produto definida;
- estudo de caso documentado;
- descoberta do domínio registrada;
- requisitos funcionais e não funcionais formalizados;
- histórias de usuário com critérios de aceitação;
- features detalhadas com regras e fluxos;
- diagramas visuais de apoio.

## Próximos passos sugeridos

A partir daqui, os próximos passos mais naturais são:

- modelar entidades e agregados do domínio;
- definir contratos de API e payloads iniciais;
- escrever especificações técnicas por endpoint;
- preparar backlog de implementação por feature;
- derivar testes a partir dos critérios de aceitação.

## Plano de implementação

O plano executável para finalizar a v1 está em [TODO.md](TODO.md).
