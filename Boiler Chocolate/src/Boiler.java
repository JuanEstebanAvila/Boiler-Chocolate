public final class Boiler {

    private static class Holder {
        private static final Boiler INSTANCE = new Boiler();
    }

    public static Boiler getInstance() {
        return Holder.INSTANCE;
    }

    private boolean lleno;
    private boolean resistenciaEncendida;
    private boolean mezclando;

    private Boiler() {
        this.lleno = false;
        this.resistenciaEncendida = false;
        this.mezclando = false;
    }

    public synchronized boolean llenar() {
        if (lleno || resistenciaEncendida) {
            System.out.println("ERROR No se puede llenar: el boiler debe estar vacío y la resistencia apagada.");
            return false;
        }
        lleno = true;
        System.out.println("OK Boiler lleno con la mezcla de chocolate y leche.");
        return true;
    }

    public synchronized boolean iniciarMezcla() {
        if (!lleno || resistenciaEncendida) {
            System.out.println("ERROR No se puede iniciar la mezcla: el boiler debe estar lleno y la resistencia apagada.");
            return false;
        }
        resistenciaEncendida = true;
        mezclando = true;
        System.out.println("OK Mezcla iniciada. Resistencia encendida.");
        return true;
    }

    public synchronized boolean vaciar() {
        if (!lleno || !resistenciaEncendida) {
            System.out.println("ERROR No se puede vaciar: el boiler debe estar lleno y la resistencia encendida.");
            return false;
        }
        lleno = false;
        mezclando = false;
        resistenciaEncendida = false;
        System.out.println("OK Boiler vaciado. Resistencia apagada.");
        return true;
    }

    public synchronized boolean estaLleno() { return lleno; }
    public synchronized boolean estaVacio() { return !lleno; }
    public synchronized boolean resistenciaEncendida() { return resistenciaEncendida; }
    public synchronized boolean estaMezclando() { return mezclando; }

    @Override
    public synchronized String toString() {
        return "Boiler[" + (lleno ? "lleno" : "vacío")+ ", resistencia " + (resistenciaEncendida ? "encendida" : "apagada")+ (mezclando ? ", mezclando" : "") + "]";
    }
}
