package bank.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

@Entity
@NamedQueries({
    @NamedQuery(name = "poliza_cliente", query = "select t from Poliza t where t.cliente.id=:prmId")
})
public class Poliza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "tasa_interes", nullable = false)
    private double tasaInteres;

    @Column(name = "total_interes", nullable = false)
    private double totalInteres;

    @Column(name = "vigente", nullable = false)
    private boolean vigente;

    @Column(name = "fecha_emision", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEmision;

    @Column(name = "fecha_vencimiento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "plazo", nullable = false)
    private int plazo;

    @JoinColumn(name = "id_cliente")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    private Cliente cliente;

    @JoinColumn(name = "id_usuario")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    private Usuario usuarioResponsable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getTotalInteres() {
        return totalInteres;
    }

    public void setTotalInteres(double totalInteres) {
        this.totalInteres = totalInteres;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Usuario getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(Usuario usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poliza)) {
            return false;
        }
        Poliza other = (Poliza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.modelos.Poliza[ id=" + id + " ]";
    }

}
