/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.controller;

import br.edu.ifpe.salonvip.model.entidades.Horarios;
import br.edu.ifpe.salonvip.model.entidades.Servico;
import br.edu.ifpe.salonvip.model.negocio.NegocioServico;
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
public class ServicoController {
    
    private NegocioServico negServico;
    private Servico servico;
    private Horarios horas;
    private ArrayList<Servico> listaServico;
    
    public ServicoController(){
        negServico = new NegocioServico();
        servico = new Servico();
        horas = new Horarios();
        listaServico = new ArrayList<>();
    }
    
    public String salvar(){
        try {
            negServico.inserir(servico);
            limpar();
            Messagens.getInstance().salvoComSucesso();
            // deve retornar a pagina de servicos
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
        return null;
    }
    
    public String alterar(){
        try {
            negServico.alterar(servico);
            limpar();
            Messagens.getInstance().alteradoComSucesso();
            //deve retorna a pagina de servicos
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
        return null;
    }
    
    public String deletar(){
        try {
            negServico.deletar(servico);
            limpar();
            Messagens.getInstance().deletadoComSucesso();
            //deve retorna a pagina de ervicos
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
        return null;
    }
    
    public void limpar(){
        horas = new Horarios();
        servico = new Servico();
    }
    
    public void listas(){
        listaServico = (ArrayList<Servico>) negServico.recuperarTodos();
    }
    
    public void listarServicoPorEmpresa(int id){
        listaServico = new ArrayList<>();
        listaServico = (ArrayList<Servico>) negServico.buscarServicosPorEmpresa(id);
    }
    
    public void resuperarCodigo(){
        negServico.recuperar(servico.getCodigo());
    }

    public NegocioServico getNegServico() {
        return negServico;
    }

    public void setNegServico(NegocioServico negServico) {
        this.negServico = negServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public ArrayList<Servico> getListaServico() {
        return listaServico;
    }

    public void setListaServico(ArrayList<Servico> listaServico) {
        this.listaServico = listaServico;
    }
    
}
