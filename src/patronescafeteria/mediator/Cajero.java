package patronescafeteria.mediator;

public class Cajero extends Colaborador {
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("patronescafeteria.mediator.Cajero recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("patronescafeteria.mediator.Cajero envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
}