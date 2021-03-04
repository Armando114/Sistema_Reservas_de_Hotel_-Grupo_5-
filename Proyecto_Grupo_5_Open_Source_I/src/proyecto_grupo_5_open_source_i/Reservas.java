/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_grupo_5_open_source_i;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Armando
 */
@Entity
@Table(name = "RESERVAS", catalog = "", schema = "ARMANDO")
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r")
    , @NamedQuery(name = "Reservas.findByIdReserva", query = "SELECT r FROM Reservas r WHERE r.idReserva = :idReserva")
    , @NamedQuery(name = "Reservas.findByNumeroHab", query = "SELECT r FROM Reservas r WHERE r.numeroHab = :numeroHab")
    , @NamedQuery(name = "Reservas.findByIdCliente", query = "SELECT r FROM Reservas r WHERE r.idCliente = :idCliente")
    , @NamedQuery(name = "Reservas.findByFechaReserva", query = "SELECT r FROM Reservas r WHERE r.fechaReserva = :fechaReserva")
    , @NamedQuery(name = "Reservas.findByFechaRegistro", query = "SELECT r FROM Reservas r WHERE r.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Reservas.findByFechaSalida", query = "SELECT r FROM Reservas r WHERE r.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Reservas.findByCostoAlojamiento", query = "SELECT r FROM Reservas r WHERE r.costoAlojamiento = :costoAlojamiento")})
public class Reservas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESERVA")
    private Integer idReserva;
    @Basic(optional = false)
    @Column(name = "NUMERO_HAB")
    private int numeroHab;
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private int idCliente;
    @Basic(optional = false)
    @Column(name = "FECHA_RESERVA")
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "COSTO_ALOJAMIENTO")
    private int costoAlojamiento;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "CODIGO", updatable = false, insertable = false)
    @ManyToOne
    private Clientes idCliente2;
    @JoinColumn(name = "NUMERO_HAB", referencedColumnName = "NUMERO_HAB", updatable = false, insertable = false)
    @ManyToOne
    private Habitaciones numeroHab2;

    public Reservas() {
    }

    public Reservas(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reservas(Integer idReserva, int numeroHab, int idCliente, Date fechaReserva, Date fechaRegistro, Date fechaSalida, int costoAlojamiento) {
        this.idReserva = idReserva;
        this.numeroHab = numeroHab;
        this.idCliente = idCliente;
        this.fechaReserva = fechaReserva;
        this.fechaRegistro = fechaRegistro;
        this.fechaSalida = fechaSalida;
        this.costoAlojamiento = costoAlojamiento;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        Integer oldIdReserva = this.idReserva;
        this.idReserva = idReserva;
        changeSupport.firePropertyChange("idReserva", oldIdReserva, idReserva);
    }

    public int getNumeroHab() {
        return numeroHab;
    }

    public void setNumeroHab(int numeroHab) {
        int oldNumeroHab = this.numeroHab;
        this.numeroHab = numeroHab;
        changeSupport.firePropertyChange("numeroHab", oldNumeroHab, numeroHab);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        int oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        Date oldFechaReserva = this.fechaReserva;
        this.fechaReserva = fechaReserva;
        changeSupport.firePropertyChange("fechaReserva", oldFechaReserva, fechaReserva);
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        Date oldFechaRegistro = this.fechaRegistro;
        this.fechaRegistro = fechaRegistro;
        changeSupport.firePropertyChange("fechaRegistro", oldFechaRegistro, fechaRegistro);
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        Date oldFechaSalida = this.fechaSalida;
        this.fechaSalida = fechaSalida;
        changeSupport.firePropertyChange("fechaSalida", oldFechaSalida, fechaSalida);
    }

    public int getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(int costoAlojamiento) {
        int oldCostoAlojamiento = this.costoAlojamiento;
        this.costoAlojamiento = costoAlojamiento;
        changeSupport.firePropertyChange("costoAlojamiento", oldCostoAlojamiento, costoAlojamiento);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto_grupo_5_open_source_i.Reservas[ idReserva=" + idReserva + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Clientes getIdCliente2() {
        return idCliente2;
    }

    public void setIdCliente2(Clientes idCliente2) {
        Clientes oldIdCliente2 = this.idCliente2;
        this.idCliente2 = idCliente2;
        changeSupport.firePropertyChange("idCliente2", oldIdCliente2, idCliente2);
    }

    public Habitaciones getNumeroHab2() {
        return numeroHab2;
    }

    public void setNumeroHab2(Habitaciones numeroHab2) {
        Habitaciones oldNumeroHab2 = this.numeroHab2;
        this.numeroHab2 = numeroHab2;
        changeSupport.firePropertyChange("numeroHab2", oldNumeroHab2, numeroHab2);
    }
    
}
