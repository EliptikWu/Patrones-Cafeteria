package state;

public class Pedido {
    private EstadoPedido estado;

    public Pedido() {
        this.estado = new EsperaState(); // Estado inicial
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void siguienteEstado() {
        estado.siguienteEstado(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public String getEstado() {
        return estado.getEstado();
    }
}
