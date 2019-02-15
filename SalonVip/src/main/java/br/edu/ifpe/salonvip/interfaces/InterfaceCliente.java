/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.interfaces;

/**
 *
 * @author wemerson
 * @param <Cliente>
 */
public interface InterfaceCliente<Cliente> extends DAO<Cliente> {
    
    public Cliente autenticar(String login, String senha);
    public Cliente recuperarCpf(String cpf);
    
}
