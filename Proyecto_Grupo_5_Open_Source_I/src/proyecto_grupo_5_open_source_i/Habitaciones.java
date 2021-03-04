/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_grupo_5_open_source_i;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Armando
 */
@Entity
@Table(name = "HABITACIONES", catalog = "", schema = "ARMANDO")
@NamedQueries({
    @NamedQuery(name = "Habitaciones.findAll", query = "SELECT h FROM Habitaciones h")
    , @NamedQuery(name = "Habitaciones.findByNumeroHab", query = "SELECT h FROM Habitaciones h WHERE h.numeroHab = :numeroHab")
    , @NamedQuery(name = "Habitaciones.findByTipoHab", query = "SELECT h FROM Habitaciones h WHERE h.tipoHab = :tipoHab")
    , @NamedQuery(name = "Habitaciones.findByPiso", query = "SELECT h FROM Habitaciones h WHERE h.piso = :piso")
    , @NamedQuery(name = "Habitaciones.findByEstado", query = "SELECT h FROM Habitaciones h WHERE h.estado = :estado")
    , @NamedQuery(name = "Habitaciones.findByPrecio", query = "SELECT h FROM Habitaciones h WHERE h.precio = :precio")})
public class Habitaciones implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO_HAB")
    private Integer numeroHab;
    @Basic(optional = false)
    @Column(name = "TIPO_HAB")
    private String tipoHab;
    @Basic(optional = false)
    @Column(name = "PISO")
    private String piso;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroHab2")
    private Collection<Reservas> reservasCollection;

    public Habitaciones() {
    }

    public Habitaciones(Integer numeroHab) {
        this.numeroHab = numeroHab;
    }

    public Habitaciones(Integer numeroHab, String tipoHab, String piso, String estado, int precio) {
        this.numeroHab = numeroHab;
        this.tipoHab = tipoHab;
        this.piso = piso;
        this.estado = estado;
        this.precio = precio;
    }

    public Integer getNumeroHab() {
        return numeroHab;
    }

    public void setNumeroHab(Integer numeroHab) {
        Integer oldNumeroHab = this.numeroHab;
        this.numeroHab = numeroHab;
        changeSupport.firePropertyChange("numeroHab", oldNumeroHab, numeroHab);
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        String oldTipoHab = this.tipoHab;
        this.tipoHab = tipoHab;
        changeSupport.firePropertyChange("tipoHab", oldTipoHab, tipoHab);
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        String oldPiso = this.piso;
        this.piso = piso;
        changeSupport.firePropertyChange("piso", oldPiso, piso);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        int oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroHab != null ? numeroHab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitaciones)) {
            return false;
        }
        Habitaciones other = (Habitaciones) object;
        if ((this.numeroHab == null && other.numeroHab != null) || (this.numeroHab != null && !this.numeroHab.equals(other.numeroHab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto_grupo_5_open_source_i.Habitaciones[ numeroHab=" + numeroHab + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }
    
}
