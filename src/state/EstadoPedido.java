package state;

public interface EstadoPedido {
    void siguienteEstado(Pedido pedido);
    void cancelar(Pedido pedido);
    String getEstado();
}
