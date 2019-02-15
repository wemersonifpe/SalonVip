/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.negocio;

import br.edu.ifpe.salonvip.interfaces.DAO;
import br.edu.ifpe.salonvip.interfaces.InterfaceAgendamento;
import br.edu.ifpe.salonvip.model.entidades.Agendamento;
import br.edu.ifpe.salonvip.repositorio.implementacao.RepositorioAgendamentoImplDB;
import br.edu.ifpe.salonvip.util.TratamentoException;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class NegocioAgendamento implements InterfaceAgendamento{
    
    public RepositorioAgendamentoImplDB repAgendamento;
    public Agendamento age;
    
    public NegocioAgendamento(){
        repAgendamento = new RepositorioAgendamentoImplDB();
    }

    @Override
    public void inserir(Agendamento agendamento) throws Exception {
        if(agendamento == null || repAgendamento.recuperar(agendamento.getCodigo()) != null){
            TratamentoException.erroAoSalva();
        }else{
            repAgendamento.inserir(agendamento);
        }
    }

    @Override
    public Agendamento recuperar(Integer codigo) {
        if(codigo == null){
            return null;
        }else{
            age = repAgendamento.recuperar(codigo);
            if(age == null){
                return null;
            }else{
                return age;
            }
        }
    }

    @Override
    public void alterar(Agendamento agendamento) throws Exception {
        if(agendamento == null || repAgendamento.recuperar(agendamento.getCodigo()) == null){
            TratamentoException.erroAoAlterar();
        }else{
            repAgendamento.alterar(agendamento);
        }
    }

    @Override
    public void deletar(Agendamento agendamento) throws Exception {
        if(agendamento == null || repAgendamento.recuperar(agendamento.getCodigo()) == null){
            TratamentoException.erroAoDeletar();
        }else{
            repAgendamento.deletar(agendamento);
        }
    }

    @Override
    public List<Agendamento> recuperarTodos() {
        List lista = repAgendamento.recuperarTodos();
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }

    @Override
    public List listarAgendamentosEmpresa(int id) {
        List lista = repAgendamento.listarAgendamentosEmpresa(id);
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }

    @Override
    public List listarAgendamentosCliente(int id) {
        List lista = repAgendamento.listarAgendamentosCliente(id);
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }
    
}
