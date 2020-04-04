package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

public class TestServicioSumarWS {
    public static void main(String[] args){
        ServicioSumarWS servicioSumar=new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutando servicio sumar ");
        int a=5;
        int b=4;
        int resultado=servicioSumar.sumar(a,b);
        
        System.out.println("El resultado es: "+resultado);
    }
}
