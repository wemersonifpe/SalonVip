/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.repositorio.implementacao;

import br.edu.ifpe.salonvip.interfaces.DAO;
import br.edu.ifpe.salonvip.interfaces.InterfaceAgendamento;
import br.edu.ifpe.salonvip.model.dao.PersistenciaDAO;
import br.edu.ifpe.salonvip.model.entidades.Agendamento;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class RepositorioAgendamentoImplDB implements InterfaceAgendamento{

    @Override
    public void inserir(Agendamento agendamento) {
        PersistenciaDAO.getInstance().salvar(agendamento);
    }

    @Override
    public Agendamento recuperar(Integer codigo) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT a FROM Agendamento a WHERE a.codigo="+codigo);
        if(!lista.isEmpty()){
            return (Agendamento) lista.get(0);
        }
        return null;
    }

    @Override
    public void alterar(Agendamento agendamento) {
        PersistenciaDAO.getInstance().editar(agendamento);
    }

    @Override
    public void deletar(Agendamento agendamento) {
        PersistenciaDAO.getInstance().deletar(agendamento);
    }

    @Override
    public List<Agendamento> recuperarTodos() {
        return PersistenciaDAO.getInstance().listar("SELECT a FROM Agendamento a");
    }

    @Override
    public List listarAgendamentosEmpresa(int id) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT a FROM Agendamento a WHERE a.empresa="+id);
        if(!lista.isEmpty()){
            return lista;
        }
        return null;
    }

    @Override
    public List listarAgendamentosCliente(int id) {
        List lista = PersistenciaDAO.getInstance().listar("SELECT a FROM Agendamento a WHERE a.cliente="+id);
        if(!lista.isEmpty()){
            return lista;
        }
        return null;
    }
    
}
