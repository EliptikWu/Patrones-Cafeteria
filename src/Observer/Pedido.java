import java.util.ArrayList;
import java.util.List;

// Clase Pedido: Sujeto (Observable)
public class Pedido {
    private String estado;
    private List<Observador> observadores = new ArrayList<>();

    // Agregar un observador
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    // Quitar un observador
    public void quitarObservador(Observador observador) {
        observadores.remove(observador);
    }

    // Notificar a todos los observadores
    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(estado);
        }
    }

    // Cambiar el estado del pedido
    public void setEstado(String estado) {
        this.estado = estado;
        System.out.println("Pedido cambiado a estado: " + estado);
        notificarObservadores();
    }
}