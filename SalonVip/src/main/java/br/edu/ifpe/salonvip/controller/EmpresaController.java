/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.controller;

import br.edu.ifpe.salonvip.model.entidades.Empresa;
import br.edu.ifpe.salonvip.model.negocio.NegocioEmpresa;
import br.edu.ifpe.salonvip.util.Messagens;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class EmpresaController {
    
    private NegocioEmpresa negEmpresa;
    private Empresa empresa;
    private ArrayList<Empresa> listaEmpresa;
    private String ret = "";
    
    public EmpresaController(){
        negEmpresa = new NegocioEmpresa();
        empresa = new Empresa();
        listaEmpresa = new ArrayList<>();
    }
    
    public void salvar(){
        try {
            empresa.setCnpj(empresa.getCnpj().replace(".", ""));
            empresa.setCnpj(empresa.getCnpj().replace("-", ""));
            negEmpresa.inserir(empresa);
            limpar();
            Messagens.getInstance().salvoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
    }
    
    public void alterar(Empresa emp){
        try {
            negEmpresa.alterar(emp);
            limpar();
            Messagens.getInstance().alteradoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
    }
    
    public void deletar(){
        try {
            negEmpresa.deletar(empresa);
            limpar();
            Messagens.getInstance().deletadoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
    }
    
    public void listar(){
        listaEmpresa = (ArrayList<Empresa>) negEmpresa.recuperarTodos();
    }
    
    public void buscarCodigo(){
        negEmpresa.recuperar(empresa.getCodigo());
    }
    
    public Empresa buscarCnpj(){
        return negEmpresa.recuperarCnpj(empresa.getCnpj());
    }
    
    public void limpar(){
        this.empresa = new Empresa();
    }

    public NegocioEmpresa getNegEmpresa() {
        return negEmpresa;
    }

    public void setNegEmpresa(NegocioEmpresa negEmpresa) {
        this.negEmpresa = negEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(ArrayList<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }
    
}
