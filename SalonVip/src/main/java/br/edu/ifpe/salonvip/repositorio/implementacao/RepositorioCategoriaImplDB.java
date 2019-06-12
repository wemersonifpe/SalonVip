/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.repositorio.implementacao;

import br.edu.ifpe.salonvip.interfaces.DAO;
import br.edu.ifpe.salonvip.model.dao.PersistenciaDAO;
import br.edu.ifpe.salonvip.model.entidades.Categoria;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class RepositorioCategoriaImplDB implements DAO<Categoria>{

    @Override
    public void inserir(Categoria cat) {
        PersistenciaDAO.getInstance().salvar(cat);
    }

    @Override
    public Categoria recuperar(Integer codigo) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT c FROM Categoria c WHERE c.codigo= "+codigo);
        if(!lista.isEmpty()){
            return (Categoria) lista.get(0);
        }
        return null;
    }

    @Override
    public void alterar(Categoria cat) {
        PersistenciaDAO.getInstance().editar(cat);
    }

    @Override
    public void deletar(Categoria cat) {
        PersistenciaDAO.getInstance().deletar(cat);
    }

    @Override
    public List<Categoria> recuperarTodos() {
        return PersistenciaDAO.getInstance().listar("SELECT c FROM Categoria c");
    }
    
    public Categoria retcategoria(){
        return (Categoria) PersistenciaDAO.getInstance().listar("SELECT c FROM Categoria c");
    }
    
}
