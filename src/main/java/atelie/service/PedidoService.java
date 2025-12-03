package atelie.service;

import atelie.model.Cliente;
import atelie.model.Pedido;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private ClienteService clienteService;
    private int nextId = 1001;

    @Autowired
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

    // ========== RF003 - ATUALIZAR STATUS DOS PEDIDOS ==========
    public boolean atualizarStatusPedido(int idPedido, String novoStatus) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                String statusAnterior = pedido.getStatusProducao();
                pedido.setStatusProducao(novoStatus);
                System.out.println("✅ Pedido " + idPedido +
                        " atualizado: " + statusAnterior +
                        " → " + novoStatus);
                return true;
            }
        }
        System.out.println("❌ Pedido com ID " + idPedido + " não encontrado");
        return false;
    }

    public List<Pedido> listarPedidos() {
        return this.pedidos;
    }

    public boolean existemPedidos() {
        return !pedidos.isEmpty();
    }

    public Pedido buscarPedidoPorId(int id) {
        for (Pedido p : pedidos) {
            if (p.getIdPedido() == id) {
                return p;
            }
        }
        return null;
    }
}