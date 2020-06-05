package bank.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
@NamedQueries({
    @NamedQuery(name = "cliente_socio", query = "select s from Socio s where s.cliente.id=:prmCliente")
})
public class Socio implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "aporte_inicial", nullable = false)
    private double aporte_inicial;

    @Column(name = "interes", nullable = false)
    private double interes;

    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_inicio;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @JoinColumn(name = "cliente_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    public Socio() {
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAporte_inicial() {
        return aporte_inicial;
    }

    public void setAporte_inicial(double aporte_inicial) {
        this.aporte_inicial = aporte_inicial;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return this.cliente.toString();
    }
}
