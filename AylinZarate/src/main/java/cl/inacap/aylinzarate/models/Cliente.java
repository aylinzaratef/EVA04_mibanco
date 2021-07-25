package cl.inacap.aylinzarate.models;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
/**
 *
 * @author Aylin
 */
@NamedQueries({
    @NamedQuery(name = "Cliente.find", query = "SELECT c FROM Cliente c WHERE c.rut = :rut AND c.clave = :clave")})

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String rut;
    @Size(max = 20)
    private String nombre;
    @Size(max = 20)
    private String apellido;
    @Size(max = 100)
    private String clave;
    @JoinColumn(name = "ejecutivoFK", referencedColumnName = "rut")
    @ManyToOne
    private Ejecutivo ejecutivo;
    @OneToMany(mappedBy = "cliente")
    private List<Cuenta> cuentaList;
    @OneToMany(mappedBy = "cliente")
    private List<Mensaje> mensajeList;



    public Cliente() {
    }

    public Cliente(String rut, String nombre, String apellido, String clave) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Cliente(String rut) {
        this.rut = rut;
    }

    public Ejecutivo getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Ejecutivo ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", clave=" + clave + ", ejecutivo=" + ejecutivo + ", cuentaList=" + cuentaList + ", mensajeList=" + mensajeList + '}';
    }

    

}
