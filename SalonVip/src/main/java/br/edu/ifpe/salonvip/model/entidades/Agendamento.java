/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    public Agendamento() {
    }

    public Agendamento(Cliente cliente, Servico servico, String data, String hora) {
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
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

    @Override
    public String toString() {
        return "Agendamento{" + "codigo=" + codigo + ", cliente=" + cliente + ", servico=" + servico + ", data=" + data + ", hora=" + hora + '}';
    }
    
}
