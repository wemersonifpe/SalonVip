/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.repositorio.implementacao;

import br.edu.ifpe.salonvip.interfaces.InterfaceServico;
import br.edu.ifpe.salonvip.model.dao.PersistenciaDAO;
import br.edu.ifpe.salonvip.model.entidades.Categoria;
import br.edu.ifpe.salonvip.model.entidades.Servico;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class RepositorioServicoImplDB implements InterfaceServico{

    @Override
    public void inserir(Servico servico) {
        PersistenciaDAO.getInstance().salvar(servico);
    }

    @Override
    public Servico recuperar(Integer codigo) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT s FROM Servico s WHERE s.codigo="+codigo);
        if(!lista.isEmpty()){
            return (Servico) lista.get(0);
        }
        return null;
    }

    @Override
    public void alterar(Servico servico) {
        PersistenciaDAO.getInstance().editar(servico);
    }

    @Override
    public void deletar(Servico servico) {
        PersistenciaDAO.getInstance().deletar(servico);
    }

    @Override
    public List<Servico> recuperarTodos() {
        return PersistenciaDAO.getInstance().listar("SELECT s FROM Servico s");
    }

    @Override
    public List buscarServicosPorEmpresa(int id) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT s FROM Servico s WHERE s.empresa="+id);
        if(!lista.isEmpty()){
            return lista;
        }
        
        return null;
    }
    
    @Override
    public List buscarServicoPorCategoria(Categoria categoria){
        List lista = PersistenciaDAO.getInstance().listar("SELECT s FROM Servico s WHERE s.categoria =(SELECT c.codigo FROM Categoria c WHERE c.nome = '"+categoria.getNome()+"')");
        if(!lista.isEmpty()){
            return lista;
        }
        return null;
    }
}
