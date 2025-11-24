package atelie.model;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private String descricaoEncomenda;
    private String statusProducao;

    public Pedido(Cliente cliente, String descricaoEncomenda) {
        this.cliente = cliente;
        this.descricaoEncomenda = descricaoEncomenda;
        this.statusProducao = "EM PRODUÇÃO";
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricaoEncomenda() {
        return descricaoEncomenda;
    }

    public String getStatusProducao() {
        return statusProducao;
    }

    public void setStatusProducao(String statusProducao) {
        this.statusProducao = statusProducao;
    }

    @Override
    public String toString() {
        return "ID Pedido: " + idPedido + " | Cliente: " + cliente.getNome() +
                " | Status: " + statusProducao + " | Descrição: " + descricaoEncomenda;
    }
}