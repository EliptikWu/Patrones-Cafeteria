package patronescafeteria.memento;

import patronescafeteria.memento.MementoPedido;

public class Pedido {
    private String estado;

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public MementoPedido crearMemento() {
        return new MementoPedido(estado);
    }

    public void restaurar(MementoPedido memento) {
        this.estado = memento.getEstado();
    }
}
