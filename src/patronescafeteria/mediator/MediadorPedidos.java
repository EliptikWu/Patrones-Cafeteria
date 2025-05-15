package patronescafeteria.mediator;

import java.util.ArrayList;
import java.util.List;
public class MediadorPedidos implements Mediator {
    private List<Colaborador> colaboradores;

    public MediadorPedidos() {
        this.colaboradores = new ArrayList<>();
    }

    public void registrarColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
        colaborador.setMediator(this);
    }

    @Override
    public void enviarMensaje(String mensaje, Colaborador remitente) {
        for (Colaborador colaborador : colaboradores) {
            if (colaborador != remitente) {
                colaborador.recibirMensaje(mensaje);
            }
        }
    }
}