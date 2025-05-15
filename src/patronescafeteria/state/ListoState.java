package patronescafeteria.state;

// Estado donde el pedido está listo para ser entregado
public class ListoState implements EstadoPedido {
    @Override
    public void siguienteEstado(Pedido pedido) {
        pedido.setEstado(new EntregadoState());
        System.out.println("El pedido ha sido entregado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("El pedido listo no se puede cancelar.");
    }

    @Override
    public String getEstado() {
        return "Listo";
    }
}
