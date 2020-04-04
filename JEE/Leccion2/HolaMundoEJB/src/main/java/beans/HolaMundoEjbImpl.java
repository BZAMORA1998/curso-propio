
package beans;

import javax.ejb.Stateless;

@Stateless
public class HolaMundoEjbImpl implements HolaMundoEjbRemote{

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando metodo sumar");
     return a+b;   
    }
}
