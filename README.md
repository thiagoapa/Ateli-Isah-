🏺 Sistema de Gestão - Ateliê de Cerâmica Isah
Disciplina: Linguagem de Programação I
Professor: Fernanda Dias
Aluno: Thiago Puentes Machado
Tecnologias: Java 8, Spring Boot 2.7.0, Maven

📋 Requisitos Funcionais Implementados (10/10)
RF	Descrição	Status	Implementação
RF001	Cadastro de Clientes	✅ Implementado	Classe Cliente + ClienteService.cadastrar()
RF002	Registro de Pedidos	✅ Implementado	Classe Pedido + PedidoService.registrarPedido()
RF003	Atualização do Status dos Pedidos	✅ Implementado	Método PedidoService.atualizarStatusPedido()
RF004	Agendamento de Aulas de Cerâmica	✅ Implementado	Método AulaService.agendarAula()
RF005	Cadastro de Aulas (tema, horário, vagas)	✅ Implementado	Classe Aula + AulaService.cadastrarAula()
RF006	Listagem de clientes	✅ Implementado	Método ClienteService.listarClientes()
RF007	Listagem de pedidos	✅ Implementado	Método PedidoService.listarPedidos()
RF008	Listagem de Aulas	✅ Implementado	Método AulaService.listarAulas()
RF009	Relatório simples do sistema	✅ Implementado	Cálculo de estatísticas na simulação
RF010	Simulação completa no método main	✅ Implementado	AtelieApplication.java com demonstração completa
🏗️ Arquitectura do Sistema
text
src/main/java/atelie/
├── AtelieApplication.java           # Classe principal Spring Boot (@SpringBootApplication)
├── model/                           # Entidades do domínio
│   ├── Cliente.java                # RF001, RF006
│   ├── Pedido.java                 # RF002, RF003, RF007
│   └── Aula.java                   # RF004, RF005, RF008
└── service/                         # Lógica de negócio (Spring @Service)
    ├── ClienteService.java         # Gestão de clientes
    ├── PedidoService.java          # Gestão de pedidos (com RF003)
    └── AulaService.java            # Gestão de aulas

src/main/resources/
└── application.properties          # Configuração Spring Boot
🚀 Como Executar o Projeto
Pré-requisitos:
Java 8 ou superior

Maven 3.6+

IDE (IntelliJ IDEA, Eclipse, VS Code) ou terminal

Via Terminal:
bash
# 1. Clone o repositório
git clone https://github.com/thiagoapa/Ateli-Isah-.git
cd Atelie

# 2. Compile com Maven
mvn clean compile

# 3. Execute a aplicação
mvn spring-boot:run

# 4. Veja a simulação completa no console
Via IntelliJ IDEA:
Abra o projeto Atelie

Execute AtelieApplication.java (clique direito → "Run")

Observe a simulação no console "Run"

📊 Simulação Automática (RF010)
Ao executar a aplicação, será exibida uma simulação completa que demonstra todos os RFs:

text
🏺===== SISTEMA COMPLETO - ATELIÊ CERÂMICA ISAH =====

--- 1. CADASTRAR CLIENTES (RF001) ---
✅ Cliente cadastrado: Isah Oliveira
✅ Cliente cadastrado: Maria Silva
✅ Cliente cadastrado: João Santos

--- 2. REGISTRAR PEDIDOS (RF002) ---
✅ Pedido 1001 registrado para Isah Oliveira.
✅ Pedido 1002 registrado para Maria Silva.
✅ Pedido 1003 registrado para João Santos.
✅ Pedido 1004 registrado para Isah Oliveira.

--- 3. ATUALIZAR STATUS DOS PEDIDOS (RF003) ---
✅ Pedido 1001 atualizado: EM PRODUÇÃO → PRONTO PARA ENTREGA
✅ Pedido 1002 atualizado: EM PRODUÇÃO → EM ACABAMENTO

--- 4. CADASTRAR AULAS (RF005) ---
✅ Aula cadastrada: Cerâmica Básica em 15/06/2024 14:00
✅ Aula cadastrada: Técnicas de Pintura em Cerâmica em 20/06/2024 18:30

--- 5. AGENDAMENTO DE AULAS (RF004) ---
✅ Vaga reservada na aula 1 para cliente 1
✅ Vaga reservada na aula 1 para cliente 2

--- 6. LISTAGEM DE CLIENTES (RF006) ---
📋 CLIENTES CADASTRADOS:
   ID: 1 | Nome: Isah Oliveira | Contato: isah.ceramica@email.com
   ...

--- 9. RELATÓRIO DO SISTEMA (RF009) ---
📊 RESUMO GERAL DO ATELIÊ:
• Total de Clientes: 3
• Total de Pedidos: 4
• Total de Aulas: 3
• Pedidos em produção: 2
• Pedidos prontos: 1

=======================================================
✅ SIMULAÇÃO COMPLETA CONCLUÍDA COM SUCESSO! (RF010)
=======================================================
