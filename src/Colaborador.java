abstract class Colaborador {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void recibirMensaje(String mensaje);

    public abstract void enviarMensaje(String mensaje);
}

