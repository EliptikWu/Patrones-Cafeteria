
class Barista extends Colaborador {
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Barista recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Barista envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
}
