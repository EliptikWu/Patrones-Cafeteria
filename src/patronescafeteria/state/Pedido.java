package patronescafeteria.state;

// Clase que representa el contexto del pedido
public class Pedido {
    private EstadoPedido estado; // Estado actual del pedido

     // El pedido inicia en el estado 'En espera'
    public Pedido() {
        this.estado = new EsperaState(); // Estado inicial
    }

    // Permite cambiar manualmente el estado del pedido
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    // Cambia al siguiente estado del pedido (usando el patrón State)
    public void siguienteEstado() {
        estado.siguienteEstado(this);
    }

    // Cancela el pedido (depende del estado actual)
    public void cancelar() {
        estado.cancelar(this);
    }

    // Devuelve el estado actual como texto
    public String getEstado() {
        return estado.getEstado();
    }
}
