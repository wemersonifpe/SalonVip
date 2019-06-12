/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.repositorio.implementacao;

import br.edu.ifpe.salonvip.model.dao.PersistenciaDAO;
import br.edu.ifpe.salonvip.model.entidades.Empresa;
import java.util.List;
import br.edu.ifpe.salonvip.interfaces.InterfaceEmpresa;

/**
 *
 * @author wemerson
 */
public class RepositorioEmpresaImplDB implements InterfaceEmpresa<Empresa>{

    @Override
    public Empresa autenticar(String login, String senha) {
        return (Empresa) PersistenciaDAO.getInstance().autenticar("SELECT a FROM Empresa a", login, senha);
    }

    @Override
    public Empresa recuperarCnpj(String cnpj) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT e FROM Empresa e WHERE e.cnpj='"+cnpj+"'");
        if(!lista.isEmpty()){
            return (Empresa) lista.get(0);
        }
        return null;
    }

    @Override
    public void inserir(Empresa empresa) {
        PersistenciaDAO.getInstance().salvar(empresa);
    }

    @Override
    public Empresa recuperar(Integer codigo) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT e FROM Empresa e WHERE e.codigo="+codigo);
        if(!lista.isEmpty()){
            return (Empresa) lista.get(0);
        }
        return null;
    }

    @Override
    public void alterar(Empresa empresa) {
        PersistenciaDAO.getInstance().editar(empresa);
    }

    @Override
    public void deletar(Empresa empresa) {
        PersistenciaDAO.getInstance().deletar(empresa);
    }

    @Override
    public List<Empresa> recuperarTodos() {
        return PersistenciaDAO.getInstance().listar("SELECT e FROM Empresa e");
    }
    
}
