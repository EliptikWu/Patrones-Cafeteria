package patronescafeteria.mediator;

public class Barista extends Colaborador {
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("patronescafeteria.mediator.Barista recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("patronescafeteria.mediator.Barista envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
}
