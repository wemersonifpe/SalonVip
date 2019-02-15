/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author wemerson
 */
@Entity
public class Empresa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa")
    private int codigo;
    @Column(name = "cnpj", length = 11)
    private String cnpj;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Embedded
    private Endereco endereco;
    @Column(name = "login", length = 30, unique = true)
    private String login;
    @Column(name = "senha", length = 10)
    private String senha;

    public Empresa() {
    }

    public Empresa(String cnpj, String nome, Endereco endereco, String login, String senha) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Empresa{" + "codigo=" + codigo + ", cnpj=" + cnpj + ", nome=" + nome + ", endereco=" + endereco + ", login=" + login + ", senha=" + senha + '}';
    }
    
}
