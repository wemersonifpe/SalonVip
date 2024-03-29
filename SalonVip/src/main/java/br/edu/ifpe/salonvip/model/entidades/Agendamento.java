/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author wemerson
 */
@Entity
public class Agendamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_agendamento")
    private int codigo;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "cod_cliente", referencedColumnName = "id_cliente", nullable = false)
    private Cliente cliente;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "cod_servico", referencedColumnName = "id_servico", nullable = false)
    private Servico servico;
    @Column
    private String data;
    @Column
    private String hora;
    @Enumerated(EnumType.ORDINAL)
    private StatusAgenda statusAgenda;

    public Agendamento() {
    }

    public Agendamento(Cliente cliente, Servico servico, String data, String hora, StatusAgenda statusAgenda) {
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
        this.statusAgenda = statusAgenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public StatusAgenda getStatusAgenda(){
        return statusAgenda;
    }
    
    public void setStatusAgenda(StatusAgenda statusAgenda){
        this.statusAgenda = statusAgenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.cliente);
        hash = 53 * hash + Objects.hashCode(this.servico);
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.hora);
        hash = 53 * hash + Objects.hashCode(this.statusAgenda);
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
        final Agendamento other = (Agendamento) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (this.statusAgenda != other.statusAgenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "codigo=" + codigo + ", cliente=" + cliente + ", servico=" + servico + ", data=" + data + ", hora=" + hora + ", statusAgenda=" + statusAgenda + '}';
    }

}
