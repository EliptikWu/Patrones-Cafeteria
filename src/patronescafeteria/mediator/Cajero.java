package patronescafeteria.mediator;

public class Cajero extends Colaborador {
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("[Cajero] recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("[Cajero] envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
}
