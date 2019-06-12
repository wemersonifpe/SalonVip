/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.controller;

import br.edu.ifpe.salonvip.model.entidades.Categoria;
import br.edu.ifpe.salonvip.model.negocio.NegocioCategoria;
import br.edu.ifpe.salonvip.util.Messagens;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class CategoriaController {
    
    private NegocioCategoria negCat;
    private Categoria categoria;
    private ArrayList<Categoria> listaCategoria;
    
    public CategoriaController(){
        negCat = new NegocioCategoria();
        categoria = new Categoria();
        listaCategoria = new ArrayList<>();
    }
    
    public void salvar(){
        try {
            negCat.inserir(categoria);
            limpar();
            Messagens.getInstance().alteradoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
    }
    
    public String alterar(){
        try {
            negCat.alterar(categoria);
            limpar();
            Messagens.getInstance().alteradoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
        return null;
    }
    
    public String deletar(){
        try {
          negCat.deletar(categoria);
          limpar();
          Messagens.getInstance().deletadoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
        return null;
    }
    
    public void retonarCategoria(){
        List<Categoria> cat = negCat.recuperarTodos();
        cat.get(0);
        categoria = (Categoria) cat;
    }
    
    public void listas(){
        listaCategoria = (ArrayList<Categoria>) negCat.recuperarTodos();
    }
    
    public void limpar(){
        categoria = new Categoria();
    }

    public NegocioCategoria getNegCat() {
        return negCat;
    }

    public void setNegCat(NegocioCategoria negCat) {
        this.negCat = negCat;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(ArrayList<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    
}
