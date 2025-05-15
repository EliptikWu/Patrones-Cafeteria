package patronescafeteria.state;

// Interfaz que define los métodos que deben implementar los estados del pedido
public interface EstadoPedido {
    void siguienteEstado(Pedido pedido); // Cambia al siguiente estado
    void cancelar(Pedido pedido); // Cancela el pedido
    String getEstado(); // Devuelve el estado actual como texto
}
