/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.entidades;

import java.io.Serializable;
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
public class Servico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_servico")
    private int codigo;
    @Column(name = "nome", length = 30)
    private String nome;
    @Column(name = "duracao")
    private double duracao;
    @Column(name = "valor")
    private double valor;
    @OneToOne
    @JoinColumn(name = "cod_empresa", referencedColumnName = "id_empresa", nullable = false)
    private Empresa empresa;
    @Column(name = "descricao", length = 100)
    private String descricao;

    public Servico() {
    }

    public Servico(String nome, double duracao, double valor, Empresa empresa, String descricao) {
        this.nome = nome;
        this.duracao = duracao;
        this.valor = valor;
        this.empresa = empresa;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    @Override
    public String toString() {
        return "Servico{" + "codigo=" + codigo + ", nome=" + nome + ", duracao=" + duracao + ", valor=" + valor + ", empresa=" + empresa + ", descricao=" + descricao +'}';
    }

}
