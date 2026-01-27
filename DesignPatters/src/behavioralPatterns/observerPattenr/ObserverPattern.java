package behavioralPatterns.observerPattenr;

public class ObserverPattern {
    public static void main(String[] args) {
        /*
         * Esté patrón nos sirve para permitir que otros objetos, tengan visibilidad de lo que sucede con uno.
         * Ejeemplo:
         *      Se requiere llevar un control de auditoria sobre una bodega que contine productos, serán las clases
         *      Administrador y auditoria queines tendrán el control o guardarán historial de dichos movimientos.
         * 
         * En pocas palabras esté patrón permite a otras clases observar el comportamiento de un objeto.
         * 
         * 
         * Para ello se requiere lo siguiente:
         *      - 1. Un contrato establecido (Interface ObservarBodega (void actualizar producto(Producto p, String nombre) 0 ))
         *      - 2. Un subject o sujeto, que es el será observado, dicho objeto debe contener los siguientes metodos:
         *              - AgregarObservador();
         *              - EliminarObservador();
         *              - RegistrarMovimiento();
         *      - 3. Clases que observarán:
         *              - Auditoria.
         *              - Administración.
         *              - Ambas debén implementar el contrato y darle su propio manejo.
         *      - 4. La clase sujeto debe contener internamente una lista de observadores, para poder gestionarlos a voluntad.
         */
    }
}

