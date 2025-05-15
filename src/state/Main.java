package state;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println("Estado inicial: " + pedido.getEstado());

        pedido.siguienteEstado();
        System.out.println("Estado actual: " + pedido.getEstado());

        pedido.siguienteEstado();
        System.out.println("Estado actual: " + pedido.getEstado());

        pedido.cancelar();
        System.out.println("Estado actual: " + pedido.getEstado());
    }
}
