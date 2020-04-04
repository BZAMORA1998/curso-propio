
package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Empleado {
    private int idempleado;
    private String cedula;
    private String nombre;
    private String apellido;
    private String cargo;
    private String sueldo;

    @Override
    public String toString() {
        return "Empleado{" + "idempleado=" + idempleado + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", cargo=" + cargo + ", sueldo=" + sueldo + '}';
    }

    public Empleado(int idempleado, String cedula, String nombre, String apellido, String cargo, String sueldo) {
        this.idempleado = idempleado;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Empleado() {
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
}
