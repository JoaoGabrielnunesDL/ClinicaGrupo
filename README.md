# 🏥 Sistema de Clínica Médica - Módulo QA, Doc & Testes (Postman)

## 👥 Integrantes do Grupo
* **Derlan Silva** - (Responsável por QA, Doc & Testes)
* **Lucas Paris** - (Responsável por Tech Lead / Infra & Gateway)
* **Lucas Silveira** - (Responsável pelo Módulo de Atendimento)
* **João Gabriel** - (Responsável pelo Módulo de Agendamento)
* **Geovani** - (Responsável pelo Módulo Administrativo)

---

## 📌 Sobre o Subprojeto
Este módulo é focado na garantia de qualidade (QA), documentação de rotas e automação de testes de API do sistema da clínica médica usando o **Postman**. Ele valida os fluxos de agendamento, atendimento e a estabilidade do gateway.

### 🛠️ Tecnologias e Ferramentas
* **Postman** (Execução e automação de testes de API)
* **JSON** (Formato das coleções de rotas exportadas)
* **Markdown** (Documentação técnica)

---

## 🧪 Cenários de Testes Cobertos (Postman)

Os testes foram estruturados na porta central do API Gateway (`8080`) para validar a integração de ponta a ponta:

| Módulo | Rota Testada | Método | Objetivo do Teste |
| :--- | :--- | :--- | :--- |
| **Agendamento** | `/agendamentos` | `POST` | Validar marcação de nova consulta |
| **Atendimento** | `/atendimentos` | `GET` | Buscar prontuário criado pelo Lucas |
| **Infraestrutura**| `/actuator/health` | `GET` | Verificar se o Gateway está online |

---

## 🚀 Como Importar e Rodar os Testes

1. Baixe e abra o aplicativo **Postman** no seu computador.
2. No canto superior esquerdo do Postman, clique no botão **Import**.
3. Selecione o arquivo de coleção JSON deste repositório (assim que for desenvolvido).
4. Configure a variável de ambiente `baseUrl` para `http://localhost:8080`.
5. Clique em **Run Collection** para executar todos os testes automatizados de uma vez.

## 🚀 Como Rodar o Ecossistema Localmente

Para validar os testes automatizados do Postman descritos acima, execute as aplicações no IntelliJ seguindo rigorosamente esta ordem padrão:
1. **`ApiGatewayApplication`** (Porta `8080`)
2. **`AdministrativoApplication`** (Porta `8081`)
3. **`AgendamentoApplication`** (Porta `8082`)
4. **`AtendimentoApplication`** (Porta `8083`)

### 🔑 Credenciais de Autenticação (Spring Security)
Ao acessar os endpoints via navegador ou ferramentas de teste, utilize as credenciais abaixo na janela de login:
* **Usuário:** `admin`
* **Senha:** `123`