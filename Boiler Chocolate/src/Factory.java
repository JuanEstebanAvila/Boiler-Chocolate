public class Factory {

    private final Boiler boiler = Boiler.getInstance();

    public Boiler getBoiler() {
        return boiler;
    }

    public void mostrarEstado() {
        System.out.println("Estado: " + boiler);
    }

    public boolean ejecutarCiclo() {
        System.out.println("Ciclo de producción");
        boolean ok = boiler.llenar() && boiler.iniciarMezcla() && boiler.vaciar();
        mostrarEstado();
        return ok;
    }
}
