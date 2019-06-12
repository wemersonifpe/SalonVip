/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.repositorio.implementacao;

import br.edu.ifpe.salonvip.model.dao.PersistenciaDAO;
import br.edu.ifpe.salonvip.model.entidades.Cliente;
import java.util.List;
import br.edu.ifpe.salonvip.interfaces.InterfaceCliente;

/**
 *
 * @author wemerson
 */
public class RepositorioClienteImplDB implements InterfaceCliente<Cliente>{

    @Override
    public Cliente autenticar(String login, String senha) {
        return (Cliente) PersistenciaDAO.getInstance().autenticar("SELECT a FROM Cliente a", login, senha);
    }

    @Override
    public Cliente recuperarCpf(String cpf) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.cpf='"+cpf+"'");
        if(!lista.isEmpty()){
            return (Cliente) lista.get(0);
        }
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        PersistenciaDAO.getInstance().salvar(cliente);
    }

    @Override
    public Cliente recuperar(Integer codigo) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.codigo="+codigo);
        if(!lista.isEmpty()){
            return (Cliente) lista.get(0);
        }
        return null;
    }

    @Override
    public void alterar(Cliente cliente) {
        PersistenciaDAO.getInstance().editar(cliente);
    }

    @Override
    public void deletar(Cliente cliente) {
        PersistenciaDAO.getInstance().deletar(cliente);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c");
    }
    
}
