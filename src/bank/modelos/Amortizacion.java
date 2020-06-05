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
    @NamedQuery(name = "amortizacion_credito", query = "select t from Amortizacion t where t.credito.id=:prmId")
})
public class Amortizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nro_cuota", nullable = false)
    private int numeroCuota;

    @Column(name = "fecha_pago", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPago;

    @Column(name = "abono", nullable = false)
    private double abono;

    @Column(name = "interes", nullable = false)
    private double interes;

    @Column(name = "pago_semanal", nullable = false)
    private double pagoSemanal;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @Column(name = "pagada", nullable = false)
    private boolean pagada; //Si la cuota está o no pagada
    
    @Column(name = "dias_mora", nullable = false)
    private int diasMora;

    @Column(name = "total_mora", nullable = false)
    private double totalMora;
    
    @JoinColumn(name = "id_credito")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    private Credito credito;  //Crédito al que pertenece

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public int getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(int diasMora) {
        this.diasMora = diasMora;
    }



    public double getTotalMora() {
        return totalMora;
    }

    public void setTotalMora(double totalMora) {
        this.totalMora = totalMora;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getPagoSemanal() {
        return pagoSemanal;
    }

    public void setPagoSemanal(double pagoSemanal) {
        this.pagoSemanal = pagoSemanal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
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
        if (!(object instanceof Amortizacion)) {
            return false;
        }
        Amortizacion other = (Amortizacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.modelos.Amortizacion[ id=" + id + " ]";
    }

}
