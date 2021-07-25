package cl.inacap.aylinzarate.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Aylin
 */
@Table(name = "mensaje")
@Entity
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByIdmensaje", query = "SELECT m FROM Mensaje m WHERE m.idmensaje = :idmensaje"),
    @NamedQuery(name = "Mensaje.findByAsunto", query = "SELECT m FROM Mensaje m WHERE m.asunto = :asunto"),
    @NamedQuery(name = "Mensaje.findByContenido", query = "SELECT m FROM Mensaje m WHERE m.contenido = :contenido"),
    @NamedQuery(name = "Mensaje.findByRespuesta", query = "SELECT m FROM Mensaje m WHERE m.respuesta = :respuesta")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idmensaje;
    @Size(max = 20)
    private String asunto;
    @Size(max = 200)
    private String contenido;
    @Size(max = 200)
    private String respuesta;
    @JoinColumn(name = "clienteFK", referencedColumnName = "rut")
    @ManyToOne
    private Cliente cliente;
    @JoinColumn(name = "ejecutivoFK", referencedColumnName = "rut")
    @ManyToOne
    private Ejecutivo ejecutivo;

    public Mensaje() {
    }

    public Mensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Mensaje(Integer idmensaje, String asunto, String contenido, String respuesta, Cliente cliente, Ejecutivo ejecutivo) {
        this.idmensaje = idmensaje;
        this.asunto = asunto;
        this.contenido = contenido;
        this.respuesta = respuesta;
        this.cliente = cliente;
        this.ejecutivo = ejecutivo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ejecutivo getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Ejecutivo ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensaje != null ? idmensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idmensaje == null && other.idmensaje != null) || (this.idmensaje != null && !this.idmensaje.equals(other.idmensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.inacap.aylinzarate.models.Mensaje[ idmensaje=" + idmensaje + " ]";
    }
    
}
