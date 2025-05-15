package patronescafeteria.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediadorPedidos implements Mediator {
    private final List<Colaborador> colaboradores = new ArrayList<>();

    public void registrarColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
        colaborador.setMediator(this);
    }

    @Override
    public void enviarMensaje(String mensaje, Colaborador remitente) {
        for (Colaborador c : colaboradores) {
            if (c != remitente) {
                c.recibirMensaje(mensaje);
            }
        }
    }
}
