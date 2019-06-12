/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.negocio;

import br.edu.ifpe.salonvip.model.entidades.Cliente;
import br.edu.ifpe.salonvip.repositorio.implementacao.RepositorioClienteImplDB;
import br.edu.ifpe.salonvip.util.TratamentoException;
import java.util.Collections;
import java.util.List;
import br.edu.ifpe.salonvip.interfaces.InterfaceCliente;

/**
 *
 * @author wemerson
 */
public class NegocioCliente implements InterfaceCliente<Cliente>{
    
    private RepositorioClienteImplDB repCliente;
    private Cliente cli;
    
    public NegocioCliente(){
        repCliente = new RepositorioClienteImplDB();
    }

    @Override
    public Cliente autenticar(String login, String senha) {
        if(login == null || senha == null ){
            return  null;
        }
        return ((RepositorioClienteImplDB) repCliente).autenticar(login, senha);
    }

    @Override
    public Cliente recuperarCpf(String cpf) {
        if(cpf == null){
            return null;
        }else{
            cli = repCliente.recuperarCpf(cpf);
            if(cli == null){
                return null;
            }else{
                return cli;
            }
        }
    }

    @Override
    public void inserir(Cliente cliente) throws Exception{
        if(cliente == null || recuperar(cliente.getCodigo()) != null){
            TratamentoException.erroAoSalva();
        }else{
            repCliente.inserir(cliente);
        }
    }

    @Override
    public Cliente recuperar(Integer codigo) {
        if(codigo == null){
            return null;
        }else{
            cli = repCliente.recuperar(codigo);
            if(cli == null){
                return null;
            }else{
                return cli;
            }
        }
    }

    @Override
    public void alterar(Cliente cliente) throws Exception{
        if (cliente == null || recuperar(cliente.getCodigo()) == null) {
            TratamentoException.erroAoAlterar();
        } else {
            repCliente.alterar(cliente);
        }
    }

    @Override
    public void deletar(Cliente cliente) throws Exception{
        if(cliente == null || recuperar(cliente.getCodigo()) == null){
            TratamentoException.erroAoDeletar();
        }else{
            repCliente.deletar(cliente);
        }
    }

    @Override
    public List<Cliente> recuperarTodos() {
        List lista = repCliente.recuperarTodos();
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }
    
}
