package patronescafeteria.mediator;

public class Repartidor extends Colaborador {
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("patronescafeteria.mediator.Repartidor recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("patronescafeteria.mediator.Repartidor envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
}
