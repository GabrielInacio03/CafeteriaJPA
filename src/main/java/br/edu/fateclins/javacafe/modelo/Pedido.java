/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fateclins.javacafe.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author apazi
 */
@Entity
public class Pedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHorario;
    @Column(length = 20)
    private String status;
    @ManyToOne
    @JoinColumn(name = "idMesa")
    private Mesa mesa;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItensPedidos> itens;

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<ItensPedidos> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedidos> itens) {
        this.itens = itens;
    }

    public void pagarConta() {
        // deve mudar o status dos pedidos "Em Aberto" para "Pago"
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
