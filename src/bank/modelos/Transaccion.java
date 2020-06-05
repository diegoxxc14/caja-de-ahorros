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
    @NamedQuery(name = "transaccion_cliente", query = "select t from Transaccion t where t.cliente.id=:prmId")
})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;    //Retiro-Ingreso

    @Column(name = "monto", nullable = false)
    private double monto;   //Monto del movimiento

    @Column(name = "saldo", nullable = false)
    private double saldo;   //Monto de la cuenta una vez hecho el movimiento

    @Column(name = "transaccion_de", nullable = false)
    private String transaccionDe;   //Quién realiza la transacción

    @Column(name = "fecha", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha; //Fecha y hora del moviento

    @JoinColumn(name = "id_cliente")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = false)
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(Usuario usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTransaccionDe() {
        return transaccionDe;
    }

    public void setTransaccionDe(String transaccionDe) {
        this.transaccionDe = transaccionDe;
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
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.modelos.Transaccion[ id=" + id + " ]";
    }

}
