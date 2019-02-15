/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.controller;

import br.edu.ifpe.salonvip.model.entidades.Agendamento;
import br.edu.ifpe.salonvip.model.negocio.NegocioAgendamento;
import br.edu.ifpe.salonvip.util.Messagens;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class AgendamentoController {
    
    private NegocioAgendamento negAgenda;
    private Agendamento agenda;
    private ArrayList<Agendamento> listaAgenda;
    
    public AgendamentoController(){
        negAgenda = new NegocioAgendamento();
        agenda = new Agendamento();
        listaAgenda = new ArrayList<>();
    }
    
    public String salvar(){
        try {
            negAgenda.inserir(agenda);
            limpar();
            //deve retornar meus agendamentos
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
        return null;
    }
    
    public String altera(){
        try {
            negAgenda.alterar(agenda);
            limpar();
            Messagens.getInstance().alteradoComSucesso();
            //deve retornar meus agendamentos
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
        return null;
    }
    
    public String deletar(){
        try {
            negAgenda.deletar(agenda);
            limpar();
            Messagens.getInstance().deletadoComSucesso();
            //deve retornar meus agendamentos
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
        return null;
    }
    
    public void listar(){
        listaAgenda = (ArrayList<Agendamento>) negAgenda.recuperarTodos();
    }
    
    public void listarAgendamentoPorEmpresa(int id){
        listaAgenda = new ArrayList<>();
        listaAgenda = (ArrayList<Agendamento>) negAgenda.listarAgendamentosEmpresa(id);
    }
    
    public void listarAgendamentoPorCliente(int id){
        listaAgenda = new ArrayList<>();
        listaAgenda = (ArrayList<Agendamento>) negAgenda.listarAgendamentosCliente(id);
    }
    
    public void recuperar(){
        negAgenda.recuperar(agenda.getCodigo());
    }
    
    public void limpar(){
        agenda = new Agendamento();
    }

    public NegocioAgendamento getNegAgenda() {
        return negAgenda;
    }

    public void setNegAgenda(NegocioAgendamento negAgenda) {
        this.negAgenda = negAgenda;
    }

    public Agendamento getAgenda() {
        return agenda;
    }

    public void setAgenda(Agendamento agenda) {
        this.agenda = agenda;
    }

    public ArrayList<Agendamento> getListaAgenda() {
        return listaAgenda;
    }

    public void setListaAgenda(ArrayList<Agendamento> listaAgenda) {
        this.listaAgenda = listaAgenda;
    }
    
    
}
