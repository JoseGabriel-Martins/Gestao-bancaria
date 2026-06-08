💰 Projeto Conta Bancária - Java (Study Case)
Este repositório contém um projeto de simulação de sistema bancário desenvolvido em Java, focado em consolidar fundamentos de POO, Estruturas de Dados e Relações de Composição.

## 🚀 Evoluções Técnicas

### Refatoração v3.0 (Estrutura e Coleções)
*   **Collections Framework:** Transição do uso de vetores estáticos para `ArrayList`, permitindo gerenciar contas de forma dinâmica.
*   **Java Stream API:** Utilização de `stream()`, `filter()` e lambdas para busca inteligente de contas, substituindo estruturas manuais de loop por código funcional.

### Refatoração v4.0 (Suporte Temporal)
*   **Java Time API:** Uso de `LocalDateTime` e `DateTimeFormatter` para registro de operações financeiras.
*   **Formatação Dinâmica:** Formatação amigável de data e hora no padrão brasileiro (`dd/MM/yyyy HH:mm`).

### Refatoração v5.0 (Composição e Histórico Real - Atual)
*   **Composição de Objetos:** Implementação da relação de composição `1:N` entre as classes `Conta` e `Transacao`. Cada conta agora possui uma lista de transações próprias.
*   **Encapsulamento e Automacia:** As transações de depósito e saque são instanciadas e guardadas automaticamente pelas operações internas da própria `Conta`, mantendo a consistência do saldo e do histórico.
*   **Enum de Controle:** Criação do enum `TipoTransacao` (`DEPOSITO` e `SAQUE`) para categorizar as movimentações de forma tipada e segura.
*   **Extrato Detalhado:** Novo extrato estruturado que itera sobre o histórico da conta, exibindo a data/hora dinâmica de cada movimentação, o tipo de transação (com destaque para as taxas aplicadas) e o saldo atual acumulado.

---

## 🛠️ Funcionalidades
- [x] Cadastro de titular com depósito inicial opcional (gera transação inicial automática).
- [x] Relação de composição real entre `Conta` e `Transacao`.
- [x] Operações de depósito e saque atualizando saldo e gerando eventos históricos dinamicamente.
- [x] Extrato bancário estruturado e formatado em padrão brasileiro de data/hora.
- [x] Exibição explícita de taxas (como a taxa de R$ 5,00 sobre saques) no histórico do cliente.

---

## 💻 Tecnologias e Conceitos
- **Linguagem:** Java 21
- **Paradigma:** Orientação a Objetos (Associação/Composição, Encapsulamento, Construtores, Sobrecarga)
- **Estruturas de Dados:** `List`, `ArrayList`
- **Processamento:** Lambdas e Stream API
- **Formatação:** `DateTimeFormatter` e `printf` com localização monetária.

---

Projeto inspirado nos desafios práticos do Prof. Nélio Alves e expandido com lógica autoral.
