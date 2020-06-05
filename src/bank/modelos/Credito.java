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
    @NamedQuery(name = "credito_cliente", query = "select t from Credito t where t.cliente.id=:prmId")
})
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fecha_emision", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEmision; //Fecha y hora del préstamo

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "numero_cuotas", nullable = false)
    private int numeroCuotas;

    @Column(name = "tasa_interes", nullable = false)
    private double tasaInteres;

    @Column(name = "fecha_cuota1", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCuota1; //Fecha del la primera cuota

    @Column(name = "pagado", nullable = false)
    private boolean pagado; //Si el préstamo está o no pagado

    @Column(name = "tipo_amortizacion", nullable = false)
    private String tipoAmortizacion; //El tipo de amortización

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

    public Usuario getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(Usuario usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoAmortizacion() {
        return tipoAmortizacion;
    }

    public void setTipoAmortizacion(String tipoAmortizacion) {
        this.tipoAmortizacion = tipoAmortizacion;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public Date getFechaCuota1() {
        return fechaCuota1;
    }

    public void setFechaCuota1(Date fechaCuota1) {
        this.fechaCuota1 = fechaCuota1;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getCuotaSemanal() {
        double interesPorCiento = this.tasaInteres / 100;
        return this.monto * ((Math.pow(1 + interesPorCiento, this.numeroCuotas) * interesPorCiento)
                / (Math.pow(1 + interesPorCiento, this.numeroCuotas) - 1));
    }

    public double getCuotaAmortizacion() {
        return this.monto / this.numeroCuotas;
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
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.modelos.Credito[ id=" + id + " ]";
    }

}
