package bank.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
public class Usuario extends Persona implements Serializable {

    @Column(name = "estado", nullable = false)
    private boolean estado;
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;

//    @JoinColumn(name = "cuenta_id")
//    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Cuenta cuenta;
//    public Cuenta getCuenta() {
//        return cuenta;
//    }
//
//    public void setCuenta(Cuenta cuenta) {
//        this.cuenta = cuenta;
//    }
//    

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
