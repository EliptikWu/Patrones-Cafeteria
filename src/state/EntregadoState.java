package state;

// Estado final: El pedido ha sido entregado
public class EntregadoState implements EstadoPedido {
    @Override
    public void siguienteEstado(Pedido pedido) {
        System.out.println("El pedido ya ha sido entregado. No se puede cambiar de estado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("El pedido entregado no se puede cancelar.");
    }

    @Override
    public String getEstado() {
        return "Entregado";
    }
}
