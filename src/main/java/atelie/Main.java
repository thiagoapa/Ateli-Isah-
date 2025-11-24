package atelie;

import atelie.model.Cliente;
import atelie.model.Pedido;        // ← ¡AGREGA ESTA LÍNEA!
import atelie.service.ClienteService;
import atelie.service.PedidoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏺===== INÍCIO DA SIMULAÇÃO SPRINT 2 =====");
        System.out.println("Sistema de Gestão - Ateliê de Cerâmica Isah");
        System.out.println("===========================================\n");

        ClienteService clienteService = new ClienteService();
        PedidoService pedidoService = new PedidoService(clienteService);

        System.out.println("--- 1. CADASTRAR CLIENTES (RF001) ---");

        Cliente cliente1 = new Cliente("Isah Oliveira", "isah.ceramica@email.com");
        Cliente cliente2 = new Cliente("Maria Silva", "maria.silva@email.com");
        Cliente cliente3 = new Cliente("João Santos", "joao.santos@email.com");

        clienteService.cadastrar(cliente1);
        clienteService.cadastrar(cliente2);
        clienteService.cadastrar(cliente3);

        System.out.println("\n--- 2. REGISTRAR PEDIDOS (RF002) ---");

        pedidoService.registrarPedido(1, "Vaso decorativo grande, azul cobalto con detalles en blanco");
        pedidoService.registrarPedido(2, "Conjunto de 4 tazas y platos con tema floral");
        pedidoService.registrarPedido(3, "Jarra de agua con asa entrelazada, color terracota");
        pedidoService.registrarPedido(1, "Plato decorativo redondo, 30cm diámetro");
        pedidoService.registrarPedido(99, "Pieza prueba - cliente no existe");

        System.out.println("\n--- 3. LISTAGEM DE CLIENTES (RF006) ---");

        if (clienteService.existemClientes()) {
            System.out.println("📋 CLIENTES CADASTRADOS:");
            for (Cliente c : clienteService.listarClientes()) {
                System.out.println("   " + c.toString());
            }
        } else {
            System.out.println("Nenhum cliente cadastrado.");
        }

        System.out.println("\n--- 4. LISTAGEM DE PEDIDOS (RF007) ---");

        if (pedidoService.existemPedidos()) {
            System.out.println("📦 PEDIDOS REGISTRADOS:");
            for (Pedido p : pedidoService.listarPedidos()) {  // ← Aquí se usa Pedido
                System.out.println("   " + p.toString());
            }
        } else {
            System.out.println("Nenhum pedido registrado.");
        }

        System.out.println("\n=========================================");
        System.out.println("✅ SIMULAÇÃO SPRINT 2 CONCLUÍDA COM SUCESSO!");
        System.out.println("=========================================");

        System.out.println("\n📊 RESUMO DA SIMULAÇÃO:");
        System.out.println("• Clientes cadastrados: " + clienteService.listarClientes().size());
        System.out.println("• Pedidos registrados: " + pedidoService.listarPedidos().size());
        System.out.println("• Sistema pronto para la próxima sprint!");
    }
}