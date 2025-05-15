package patronescafeteria;

import patronescafeteria.mediator.Barista;
import patronescafeteria.mediator.Cajero;
import patronescafeteria.mediator.MediadorPedidos;
import patronescafeteria.mediator.Repartidor;
import patronescafeteria.state.Pedido;

public class Main {
    public static void main(String[] args) {
        MediadorPedidos mediador = new MediadorPedidos();

        // Crear colaboradores
        Cajero cajero        = new Cajero();
        Barista barista      = new Barista();
        Repartidor repartidor = new Repartidor();

        // Registrar en el mediador
        mediador.registrarColaborador(cajero);
        mediador.registrarColaborador(barista);
        mediador.registrarColaborador(repartidor);

        // Flujo de mensajes – toda la comunicación va a través del mediador
        cajero.enviarMensaje("Nuevo pedido para preparar.");
        barista.enviarMensaje("Pedido listo para entrega.");
        repartidor.enviarMensaje("Pedido entregado al cliente.");

        // State Pattern: seguimiento de estados del pedido
        Pedido statePedido = new Pedido();
        System.out.println("Estado inicial (State): " + statePedido.getEstado());

        statePedido.siguienteEstado();
        System.out.println("Cambio de estado (State): " + statePedido.getEstado());

        statePedido.siguienteEstado();
        System.out.println("Cambio de estado (State): " + statePedido.getEstado());

        statePedido.siguienteEstado();
        System.out.println("Estado final (State): " + statePedido.getEstado());
    }
}
