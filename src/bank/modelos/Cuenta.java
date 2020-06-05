package bank.modelos;

import java.io.Serializable;
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

@Entity
@NamedQueries({
    @NamedQuery(name = "username_cuenta", query = "select c from Cuenta c where c.username=:prmUsername"),
    @NamedQuery(name = "cuenta_username", query = "select cl from Cuenta cl where cl.username like concat(:prmUsername,'%')"),
    @NamedQuery(name = "cuenta_cedula", query = "select cl from Cuenta cl where cl.usuario.cedula like concat(:prmCedula,'%')"),
    @NamedQuery(name = "cuenta_usuario", query = "select c from Cuenta c where c.usuario.id=:prmIdUsuario")
})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, length = 25, unique = true, updatable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @JoinColumn(name = "id_usuario")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    private Usuario usuario;

    @JoinColumn(name = "id_rol")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
    private Rol rol;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
