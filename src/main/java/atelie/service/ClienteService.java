package atelie.service;

import atelie.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;

    public void cadastrar(Cliente cliente) {
        cliente.setIdCliente(nextId++);
        this.clientes.add(cliente);
        System.out.println("✅ Cliente cadastrado: " + cliente.getNome());
    }

    public List<Cliente> listarClientes() {
        return this.clientes;
    }

    public Cliente buscarClientePorId(int id) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean existemClientes() {
        return !clientes.isEmpty();
    }
}