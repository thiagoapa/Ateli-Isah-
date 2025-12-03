package atelie;

import atelie.model.Cliente;
import atelie.model.Pedido;
import atelie.service.ClienteService;
import atelie.service.PedidoService;
import atelie.service.AulaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AtelieApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtelieApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ClienteService clienteService,
                                  PedidoService pedidoService,
                                  AulaService aulaService) {
        return args -> {
            System.out.println("🏺===== SISTEMA COMPLETO - ATELIÊ CERÂMICA ISAH =====");
            System.out.println("=====================================================\n");

            // ========== RF001 - CADASTRO DE CLIENTES ==========
            System.out.println("--- 1. CADASTRAR CLIENTES (RF001) ---");

            Cliente cliente1 = new Cliente("Isah Oliveira", "isah.ceramica@email.com");
            Cliente cliente2 = new Cliente("Maria Silva", "maria.silva@email.com");
            Cliente cliente3 = new Cliente("João Santos", "joao.santos@email.com");

            clienteService.cadastrar(cliente1);
            clienteService.cadastrar(cliente2);
            clienteService.cadastrar(cliente3);

            // ========== RF002 - REGISTRO DE PEDIDOS ==========
            System.out.println("\n--- 2. REGISTRAR PEDIDOS (RF002) ---");

            pedidoService.registrarPedido(1, "Vaso decorativo grande, azul cobalto");
            pedidoService.registrarPedido(2, "Conjunto de 4 tazas y platos com tema floral");
            pedidoService.registrarPedido(3, "Jarra de agua com asa entrelazada, color terracota");
            pedidoService.registrarPedido(1, "Plato decorativo redondo, 30cm diámetro");
            pedidoService.registrarPedido(99, "Pieza prueba - cliente não existe");

            // ========== RF003 - ATUALIZAR STATUS PEDIDOS ==========
            System.out.println("\n--- 3. ATUALIZAR STATUS DOS PEDIDOS (RF003) ---");

            pedidoService.atualizarStatusPedido(1001, "PRONTO PARA ENTREGA");
            pedidoService.atualizarStatusPedido(1002, "EM ACABAMENTO");
            pedidoService.atualizarStatusPedido(9999, "TESTE PEDIDO INEXISTENTE");

            // ========== RF005 - CADASTRO DE AULAS ==========
            System.out.println("\n--- 4. CADASTRAR AULAS (RF005) ---");

            aulaService.cadastrarAula("Cerâmica Básica", "15/06/2024 14:00", 8);
            aulaService.cadastrarAula("Técnicas de Pintura em Cerâmica", "20/06/2024 18:30", 6);
            aulaService.cadastrarAula("Modelagem de Esculturas", "25/06/2024 10:00", 5);

            // ========== RF004 - AGENDAMENTO DE AULAS ==========
            System.out.println("\n--- 5. AGENDAMENTO DE AULAS (RF004) ---");

            aulaService.agendarAula(1, 1); // Cliente 1 na aula 1
            aulaService.agendarAula(1, 2); // Cliente 2 na aula 1
            aulaService.agendarAula(2, 3); // Cliente 3 na aula 2
            aulaService.agendarAula(99, 1); // Aula inexistente

            // ========== RF006 - LISTAGEM DE CLIENTES ==========
            System.out.println("\n--- 6. LISTAGEM DE CLIENTES (RF006) ---");

            if (clienteService.existemClientes()) {
                System.out.println("📋 CLIENTES CADASTRADOS:");
                for (Cliente c : clienteService.listarClientes()) {
                    System.out.println("   " + c.toString());
                }
            } else {
                System.out.println("Nenhum cliente cadastrado.");
            }

            // ========== RF007 - LISTAGEM DE PEDIDOS ==========
            System.out.println("\n--- 7. LISTAGEM DE PEDIDOS (RF007) ---");

            if (pedidoService.existemPedidos()) {
                System.out.println("📦 PEDIDOS REGISTRADOS:");
                for (Pedido p : pedidoService.listarPedidos()) {
                    System.out.println("   " + p.toString());
                }
            } else {
                System.out.println("Nenhum pedido registrado.");
            }

            // ========== RF008 - LISTAGEM DE AULAS ==========
            System.out.println("\n--- 8. LISTAGEM DE AULAS (RF008) ---");

            if (aulaService.existemAulas()) {
                System.out.println("🎨 AULAS CADASTRADAS:");
                for (atelie.model.Aula a : aulaService.listarAulas()) {
                    System.out.println("   " + a.toString());
                }
            } else {
                System.out.println("Nenhuma aula cadastrada.");
            }

            // ========== RF009 - RELATÓRIO DO SISTEMA ==========
            System.out.println("\n--- 9. RELATÓRIO DO SISTEMA (RF009) ---");

            System.out.println("📊 RESUMO GERAL DO ATELIÊ:");
            System.out.println("• Total de Clientes: " + clienteService.listarClientes().size());
            System.out.println("• Total de Pedidos: " + pedidoService.listarPedidos().size());
            System.out.println("• Total de Aulas: " + aulaService.listarAulas().size());

            // Contar pedidos por status
            long emProducao = pedidoService.listarPedidos().stream()
                    .filter(p -> p.getStatusProducao().equals("EM PRODUÇÃO")).count();
            long prontos = pedidoService.listarPedidos().stream()
                    .filter(p -> p.getStatusProducao().contains("PRONTO")).count();
            long emAcabamento = pedidoService.listarPedidos().stream()
                    .filter(p -> p.getStatusProducao().equals("EM ACABAMENTO")).count();

            System.out.println("\n📈 STATUS DOS PEDIDOS:");
            System.out.println("• Em produção: " + emProducao);
            System.out.println("• Em acabamento: " + emAcabamento);
            System.out.println("• Prontos para entrega: " + prontos);

            // Vagas nas aulas
            int vagasOcupadas = aulaService.listarAulas().stream()
                    .mapToInt(a -> a.getVagasTotais() - a.getVagasDisponiveis())
                    .sum();
            int vagasTotais = aulaService.listarAulas().stream()
                    .mapToInt(a -> a.getVagasTotais())
                    .sum();

            System.out.println("\n🎯 VAGAS NAS AULAS:");
            System.out.println("• Vagas ocupadas: " + vagasOcupadas);
            System.out.println("• Vagas totais: " + vagasTotais);
            System.out.println("• Vagas disponíveis: " + (vagasTotais - vagasOcupadas));

            System.out.println("\n✅ Sistema 100% operacional!");

            // ========== RF010 - SIMULAÇÃO COMPLETA ==========
            System.out.println("\n=======================================================");
            System.out.println("✅ SIMULAÇÃO COMPLETA CONCLUÍDA COM SUCESSO! (RF010)");
            System.out.println("=======================================================");
        };
    }
}