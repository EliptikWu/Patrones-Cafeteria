package patronescafeteria.observer;

// Clase Cocina: Observador
public class Cocina implements Observador {
    @Override
    public void actualizar(String estado) {
        System.out.println("Cocina ha sido notificada: Pedido está " + estado);
    }
}