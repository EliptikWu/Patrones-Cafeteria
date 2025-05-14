package state;

public class EsperaState implements EstadoPedido {
    @Override
    public void siguienteEstado(Pedido pedido) {
        pedido.setEstado(new PreparacionState());
        System.out.println("El pedido ha pasado a estado: En preparación.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("El pedido en espera ha sido cancelado.");
        pedido.setEstado(null);
    }

    @Override
    public String getEstado() {
        return "En espera";
    }
}
