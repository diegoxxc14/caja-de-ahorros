package bank.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NamedQueries({
    @NamedQuery(name = "cliente_nrocuenta", query = "select cl from Cliente cl where cl.cuenta_ahorros.nro_cuenta = :prmNroCuenta"),
    @NamedQuery(name = "cliente_cedula", query = "select cl from Cliente cl where cl.cedula=:prmCedula"),
    @NamedQuery(name = "cliente_nrocuenta2", query = "select cl from Cliente cl where cl.cuenta_ahorros.nro_cuenta like concat(:prmNroCuenta,'%')"),
    @NamedQuery(name = "cliente_cedula2", query = "select cl from Cliente cl where cl.cedula like concat(:prmCedula,'%')")
})
@PrimaryKeyJoinColumn(name = "persona_id")
public class Cliente extends Persona implements Serializable {

    @Column(name = "carrera", nullable = false, length = 200)
    private String carrera;

    @Column(name = "ciclo", nullable = false)
    private int ciclo;

    @Column(name = "seccion", nullable = false, length = 50)
    private String seccion;

    @Column(name = "correo", length = 150)
    private String correo;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @JoinColumn(name = "id_cuenta_ahorros")
    @OneToOne(fetch = FetchType.EAGER)
    private CuentaAhorros cuenta_ahorros;

    public CuentaAhorros getCuenta_ahorros() {
        return cuenta_ahorros;
    }

    public void setCuenta_ahorros(CuentaAhorros cuenta_ahorros) {
        this.cuenta_ahorros = cuenta_ahorros;
    }

    public String getCarrera() {
        return carrera;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return this.getApellidos() + " " + this.getNombres();
    }
}
