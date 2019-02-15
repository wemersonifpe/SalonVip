/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.interfaces;

/**
 *
 * @author wemerson
 */
public interface InterfaceEmpresa<Empresa> extends DAO<Empresa> {
    
    public Empresa autenticar(String login, String senha);
    public Empresa recuperarCnpj(String cnpj);
    
}
