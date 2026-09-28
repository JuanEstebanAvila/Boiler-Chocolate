public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando proceso de la fabrica de chocolate");

        Factory factory = new Factory();
        Boiler boiler = Boiler.getInstance();

        System.out.println("¿Misma instancia? " + (boiler == factory.getBoiler()));

        System.out.println("\nEstado inicial");
        factory.mostrarEstado();

        System.out.println("\nOperaciones inválidas con el boiler vacío");
        boiler.iniciarMezcla();  
        boiler.vaciar();        
        factory.mostrarEstado();

        System.out.println("\nFlujo válido");
        boiler.llenar();
        boiler.llenar();         
        boiler.vaciar();          
        boiler.iniciarMezcla();
        boiler.iniciarMezcla();   
        boiler.llenar();         
        factory.mostrarEstado();
        boiler.vaciar();
        factory.mostrarEstado();

        System.out.println();
        factory.ejecutarCiclo();  
    }
}
