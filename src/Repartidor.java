class Repartidor extends Colaborador {
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Repartidor recibió: " + mensaje);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Repartidor envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }
}
