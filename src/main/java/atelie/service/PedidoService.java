package atelie.service;

import atelie.model.Cliente;
import atelie.model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private ClienteService clienteService;
    private int nextId = 1001;

    public PedidoService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void registrarPedido(int idCliente, String descricao) {
        Cliente cliente = clienteService.buscarClientePorId(idCliente);

        if (cliente != null) {
            Pedido novoPedido = new Pedido(cliente, descricao);
            novoPedido.setIdPedido(nextId++);
            this.pedidos.add(novoPedido);
            System.out.println("✅ Pedido " + novoPedido.getIdPedido() +
                    " registrado para " + cliente.getNome() + ".");
        } else {
            System.out.println("❌ ERRO: Cliente com ID " + idCliente + " não encontrado. Pedido cancelado.");
        }
    }

    public List<Pedido> listarPedidos() {
        return this.pedidos;
    }

    public boolean existemPedidos() {
        return !pedidos.isEmpty();
    }
}