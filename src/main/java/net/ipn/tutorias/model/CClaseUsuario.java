package net.ipn.tutorias.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "claseusuarios")
@IdClass(ClaseUsuarioPK.class)
public class CClaseUsuario {

    @Id
    @Column(name = "idClase")
    private Integer idClase;

    @Id
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idClase", insertable = false, updatable = false)
    private CClase clase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private CUsuario usuario;

    public CClaseUsuario() {}

    public CClaseUsuario(Integer idClase, Integer idUsuario) {
        this.idClase = idClase;
        this.idUsuario = idUsuario;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CClase getClase() {
        return clase;
    }

    public CUsuario getUsuario() {
        return usuario;
    }
}
