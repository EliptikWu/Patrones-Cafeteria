import java.util.Stack;

public class Caretaker {
    private Stack<MementoPedido> historial = new Stack<>();

    public void guardarEstado(MementoPedido memento) {
        historial.push(memento);
    }

    public MementoPedido getUltimoEstado() {
        return historial.isEmpty() ? null : historial.pop();
    }
}
