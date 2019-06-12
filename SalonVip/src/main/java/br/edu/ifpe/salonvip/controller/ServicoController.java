/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.controller;

import br.edu.ifpe.salonvip.model.entidades.Categoria;
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
    private Categoria categoria;
    private ArrayList<Servico> listaServico;
    private ArrayList<Servico> cabelos;
    private ArrayList<Servico> unhas;
    private ArrayList<Servico> faciais;
    private ArrayList<Servico> maquiagens;
    
    public ServicoController(){
        negServico = new NegocioServico();
        servico = new Servico();
        horas = new Horarios();
        categoria = new Categoria();
        listaServico = new ArrayList<>();
        cabelos = new ArrayList<>();
        unhas = new ArrayList<>();
        faciais = new ArrayList<>();
        maquiagens = new ArrayList<>();
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
    
    public void adicionarHorarios(){
        servico.inserirHorarios(horas);
        horas = new Horarios();
    }
        public void deletarHorarios(){
        servico.deletarHorarios(horas);
        horas = new Horarios();
    }
    
    public void listas(){
        listaServico = (ArrayList<Servico>) negServico.recuperarTodos();
    }
    
    public void listaCabelos(){
        categoria.setNome("Cabelo");
        cabelos = (ArrayList<Servico>) negServico.buscarServicoPorCategoria(categoria);
    }
    
    public void listaUnhas(){
        categoria.setNome("Unhas");
        unhas = (ArrayList<Servico>) negServico.buscarServicoPorCategoria(categoria);
    }
    
    public void listaMaquiagens(){
        categoria.setNome("Maquiagen");
        maquiagens = (ArrayList<Servico>) negServico.buscarServicoPorCategoria(categoria);
    }
    
    public void listaFaciais(){
        categoria.setNome("Facial");
        faciais = (ArrayList<Servico>) negServico.buscarServicoPorCategoria(categoria);
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

    public Horarios getHoras() {
        return horas;
    }

    public void setHoras(Horarios horas) {
        this.horas = horas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Servico> getCabelos() {
        return cabelos;
    }

    public void setCabelos(ArrayList<Servico> cabelos) {
        this.cabelos = cabelos;
    }

    public ArrayList<Servico> getUnhas() {
        return unhas;
    }

    public void setUnhas(ArrayList<Servico> unhas) {
        this.unhas = unhas;
    }

    public ArrayList<Servico> getFaciais() {
        return faciais;
    }

    public void setFaciais(ArrayList<Servico> faciais) {
        this.faciais = faciais;
    }

    public ArrayList<Servico> getMaquiagens() {
        return maquiagens;
    }

    public void setMaquiagens(ArrayList<Servico> maquiagens) {
        this.maquiagens = maquiagens;
    }

    
}
