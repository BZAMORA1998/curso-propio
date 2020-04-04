/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.HolaMundoEjbRemote;
import javax.naming.*;

public class TestHolaMundoEJB {
    public static void main(String[] args){
        System.out.println("Iniciando ejb desde el ecliente \n");
        try{
            Context jndi=new InitialContext();
            HolaMundoEjbRemote holaMundoEJB=(HolaMundoEjbRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote");
            int resultado=holaMundoEJB.sumar(2,2);
            System.out.println("El resultado es: "+resultado);
        }
        catch(NamingException e){
            e.printStackTrace(System.out);
        }
    }
}
