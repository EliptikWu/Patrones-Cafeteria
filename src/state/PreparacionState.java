package state;

public class PreparacionState implements EstadoPedido {
    @Override
    public void siguienteEstado(Pedido pedido) {
        pedido.setEstado(new ListoState());
        System.out.println("El pedido ha pasado a estado: Listo.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("El pedido en preparación ha sido cancelado.");
        pedido.setEstado(null);
    }

    @Override
    public String getEstado() {
        return "En preparación";
    }
}
