package patronescafeteria;

import patronescafeteria.mediator.MediadorPedidos;
import patronescafeteria.mediator.Cajero;
import patronescafeteria.mediator.Barista;
import patronescafeteria.mediator.Repartidor;
import patronescafeteria.memento.Caretaker;
import patronescafeteria.memento.MementoPedido;

import patronescafeteria.observer.Pedido;
import patronescafeteria.observer.Cliente;
import patronescafeteria.observer.Cocina;

public class Main {
    public static void main(String[] args) {
        // --- Mediator ---
        MediadorPedidos mediador = new MediadorPedidos();
        Cajero cajero = new Cajero();
        Barista barista = new Barista();
        Repartidor repartidor = new Repartidor();
        mediador.registrarColaborador(cajero);
        mediador.registrarColaborador(barista);
        mediador.registrarColaborador(repartidor);

        // --- Observer (ahora correcto) ---
        Pedido pedidoObserv = new Pedido();   // esto es patronescafeteria.observer.Pedido
        Cliente cliente = new Cliente("Juan");
        Cocina cocina = new Cocina();
        pedidoObserv.agregarObservador(cliente);
        pedidoObserv.agregarObservador(cocina);

        // --- Memento ---
        Caretaker caretaker = new Caretaker();

        // --- State (fully‐qualified) ---
        patronescafeteria.state.Pedido statePedido = new patronescafeteria.state.Pedido();

        // 1. Estado inicial
        System.out.println("Estado inicial (State): " + statePedido.getEstado());
        caretaker.guardarEstado(new MementoPedido(statePedido.getEstado()));
        // aquí setEstado recibe un String, que coincide con observer.Pedido.setEstado(String)
        pedidoObserv.setEstado(statePedido.getEstado());
        mediador.enviarMensaje("Pedido creado", cajero);

        // 2. Paso a siguiente estado
        statePedido.siguienteEstado();
        System.out.println("Cambio (State) a: " + statePedido.getEstado());
        caretaker.guardarEstado(new MementoPedido(statePedido.getEstado()));
        pedidoObserv.setEstado(statePedido.getEstado());
        mediador.enviarMensaje("Estado cambiado a " + statePedido.getEstado(), barista);

        // 3. Paso a Listo
        statePedido.siguienteEstado();
        System.out.println("Cambio (State) a: " + statePedido.getEstado());
        caretaker.guardarEstado(new MementoPedido(statePedido.getEstado()));
        pedidoObserv.setEstado(statePedido.getEstado());
        mediador.enviarMensaje("Estado cambiado a " + statePedido.getEstado(), repartidor);

        // 4. Restaurar último estado con Memento
        MementoPedido anterior = caretaker.getUltimoEstado();
        if (anterior != null) {
            System.out.println("Restaurando (Memento) a: " + anterior.getEstado());
            pedidoObserv.setEstado(anterior.getEstado());
            mediador.enviarMensaje("Estado restaurado a " + anterior.getEstado(), cajero);
        }

        // 5. Finalizar (Entregado)
        statePedido.siguienteEstado();
        System.out.println("Estado final (State): " + statePedido.getEstado());
        pedidoObserv.setEstado(statePedido.getEstado());
        mediador.enviarMensaje("Pedido entregado", repartidor);
    }
}
