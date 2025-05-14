public class MediatorPattern {
    public static void main(String[] args) {
        MediadorPedidos mediador = new MediadorPedidos();

        Cajero cajero = new Cajero();
        Barista barista = new Barista();
        Repartidor repartidor = new Repartidor();

        mediador.registrarColaborador(cajero);
        mediador.registrarColaborador(barista);
        mediador.registrarColaborador(repartidor);

        cajero.enviarMensaje("Nuevo pedido para preparar.");
        barista.enviarMensaje("Pedido listo para entrega.");
        repartidor.enviarMensaje("Pedido entregado al cliente.");
    }
}