package patronescafeteria;

import patronescafeteria.mediator.*;
import patronescafeteria.state.Pedido;
import patronescafeteria.observer.*;
import patronescafeteria.memento.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE CAFETERÍA - PATRONES DE DISEÑO =====\n");

        // ------- PATRÓN MEDIATOR -------
        System.out.println("=== 1. IMPLEMENTACIÓN DEL PATRÓN MEDIATOR ===");
        MediadorPedidos mediador = new MediadorPedidos();

        // Crear colaboradores
        Cajero cajero = new Cajero();
        Barista barista = new Barista();
        Repartidor repartidor = new Repartidor();

        // Registrar en el mediador (característica clave del patrón Mediator)
        mediador.registrarColaborador(cajero);
        mediador.registrarColaborador(barista);
        mediador.registrarColaborador(repartidor);

        System.out.println("\nDemostración de comunicación a través del Mediator:");
        System.out.println("Cajero inicia un nuevo pedido para café");
        cajero.enviarMensaje("Nuevo pedido de café para preparar - Cliente: María");

        System.out.println("\nBarista responde al pedido:");
        barista.enviarMensaje("Pedido de café está listo para entrega");

        System.out.println("\nRepartidor confirma la entrega:");
        repartidor.enviarMensaje("Pedido de café entregado al cliente");

        // ------- PATRÓN STATE -------
        System.out.println("\n=== 2. IMPLEMENTACIÓN DEL PATRÓN STATE ===");
        System.out.println("Seguimiento del ciclo de vida del pedido con State Pattern:");

        patronescafeteria.state.Pedido statePedido = new patronescafeteria.state.Pedido();
        System.out.println("Estado inicial del pedido: " + statePedido.getEstado());

        // Transición entre estados
        System.out.println("\nCambiando estados del pedido:");
        statePedido.siguienteEstado(); // Espera -> Preparación
        System.out.println("→ Estado actual: " + statePedido.getEstado());

        statePedido.siguienteEstado(); // Preparación -> Listo
        System.out.println("→ Estado actual: " + statePedido.getEstado());

        statePedido.siguienteEstado(); // Listo -> Entregado
        System.out.println("→ Estado final: " + statePedido.getEstado());

        // Intentar cambiar desde el estado final
        System.out.println("\nIntentando cambiar desde el estado final:");
        statePedido.siguienteEstado(); // No debe cambiar

        // ------- PATRÓN OBSERVER -------
        System.out.println("\n=== 3. IMPLEMENTACIÓN DEL PATRÓN OBSERVER ===");
        System.out.println("Notificaciones automáticas de cambios en los pedidos:");

        // Crear el pedido observable
        patronescafeteria.observer.Pedido observerPedido = new patronescafeteria.observer.Pedido();

        // Crear observadores
        Cliente cliente1 = new Cliente("Juan");
        Cliente cliente2 = new Cliente("Ana");
        Cocina cocina = new Cocina();

        // Registrar observadores (característica clave del patrón Observer)
        observerPedido.agregarObservador(cliente1);
        observerPedido.agregarObservador(cliente2);
        observerPedido.agregarObservador(cocina);

        // Cambiar estado y ver notificaciones automáticas
        System.out.println("\nActualizando estado del pedido:");
        observerPedido.setEstado("en preparación");

        System.out.println("\nEliminando un observador y actualizando de nuevo:");
        observerPedido.quitarObservador(cliente2);
        observerPedido.setEstado("listo para entrega");

        // ------- PATRÓN MEMENTO -------
        System.out.println("\n=== 4. IMPLEMENTACIÓN DEL PATRÓN MEMENTO ===");
        System.out.println("Historial y restauración de estados anteriores:");

        // Crear objetos para el patrón Memento
        patronescafeteria.memento.Pedido mementoPedido = new patronescafeteria.memento.Pedido();
        Caretaker historial = new Caretaker();

        // Guardar diferentes estados
        mementoPedido.setEstado("Recibido");
        System.out.println("Estado inicial: " + mementoPedido.getEstado());
        historial.guardarEstado(mementoPedido.crearMemento());

        mementoPedido.setEstado("En preparación");
        System.out.println("Actualizando a: " + mementoPedido.getEstado());
        historial.guardarEstado(mementoPedido.crearMemento());

        mementoPedido.setEstado("Listo para entrega");
        System.out.println("Actualizando a: " + mementoPedido.getEstado());

        // Demostrar la restauración de estados (característica clave del patrón Memento)
        System.out.println("\nRestaurando a estado anterior:");
        mementoPedido.restaurar(historial.getUltimoEstado());
        System.out.println("Estado después de restaurar: " + mementoPedido.getEstado());

        System.out.println("\nRestaurando a estado inicial:");
        mementoPedido.restaurar(historial.getUltimoEstado());
        System.out.println("Estado después de restaurar: " + mementoPedido.getEstado());

        // ------- INTEGRACIÓN DE LOS PATRONES -------
        System.out.println("\n=== INTEGRACIÓN DE LOS 4 PATRONES DE DISEÑO ===");
        System.out.println("Simulación de un flujo completo de pedido integrando todos los patrones:");

        // Creamos nuevas instancias para la demo integrada
        MediadorPedidos mediadorIntegrado = new MediadorPedidos();
        Cajero cajeroIntegrado = new Cajero();
        Barista baristaIntegrado = new Barista();
        Repartidor repartidorIntegrado = new Repartidor();

        mediadorIntegrado.registrarColaborador(cajeroIntegrado);
        mediadorIntegrado.registrarColaborador(baristaIntegrado);
        mediadorIntegrado.registrarColaborador(repartidorIntegrado);

        // Crear pedido con State
        patronescafeteria.state.Pedido pedidoIntegrado = new patronescafeteria.state.Pedido();

        // Crear historial con Memento
        patronescafeteria.memento.Pedido historialPedido = new patronescafeteria.memento.Pedido();
        Caretaker caretaker = new Caretaker();

        // Crear sistema de notificaciones con Observer
        patronescafeteria.observer.Pedido notificadorPedido = new patronescafeteria.observer.Pedido();
        notificadorPedido.agregarObservador(new Cliente("Carlos"));
        notificadorPedido.agregarObservador(new Cocina());

        System.out.println("\n1. Cliente realiza un pedido:");
        // Mediator coordina la comunicación
        cajeroIntegrado.enviarMensaje("Nuevo pedido de Espresso Doble para Carlos");

        // State maneja la transición de estados
        System.out.println("\n2. Actualización de estado (State):");
        System.out.println("   Estado inicial: " + pedidoIntegrado.getEstado());
        pedidoIntegrado.siguienteEstado();

        // Memento guarda el historial
        historialPedido.setEstado(pedidoIntegrado.getEstado());
        caretaker.guardarEstado(historialPedido.crearMemento());

        // Observer notifica a los interesados
        System.out.println("\n3. Notificando a los interesados (Observer):");
        notificadorPedido.setEstado(pedidoIntegrado.getEstado());

        // Barista comunica que el pedido está listo
        System.out.println("\n4. Barista prepara el pedido:");
        baristaIntegrado.enviarMensaje("Espresso Doble está listo para entrega");
        pedidoIntegrado.siguienteEstado();

        // Guardar el nuevo estado en el historial
        historialPedido.setEstado(pedidoIntegrado.getEstado());
        caretaker.guardarEstado(historialPedido.crearMemento());

        // Notificar el nuevo estado
        notificadorPedido.setEstado(pedidoIntegrado.getEstado());

        // Repartidor entrega el pedido
        System.out.println("\n5. Repartidor entrega el pedido:");
        repartidorIntegrado.enviarMensaje("Espresso Doble entregado al cliente Carlos");
        pedidoIntegrado.siguienteEstado();

        // Guardar estado final y notificar
        historialPedido.setEstado(pedidoIntegrado.getEstado());
        notificadorPedido.setEstado(pedidoIntegrado.getEstado());

        // Demostrar la capacidad de deshacer con Memento
        System.out.println("\n6. Cliente solicita verificar un estado anterior (Memento):");
        System.out.println("   Estado actual: " + historialPedido.getEstado());
        historialPedido.restaurar(caretaker.getUltimoEstado());
        System.out.println("   Restaurado a: " + historialPedido.getEstado());

        System.out.println("\n===== FIN DE LA DEMOSTRACIÓN DE PATRONES =====");
    }
}