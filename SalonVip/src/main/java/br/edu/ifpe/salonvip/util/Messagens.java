/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author wemerson
 */
public class Messagens {
    
    private static Messagens messagens;
    
    public static Messagens getInstance(){
        if(messagens == null){
            messagens = new Messagens();
        }
        return messagens;
    }
    
    public void adicionarMessagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage messagen = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, messagen);
    }
    
    public void nenhumaInfomacao(){
        adicionarMessagem("Campos vazios!", "Nenhuma infomação foi passada", FacesMessage.SEVERITY_ERROR);
    }
    
    public void existe(String texto){
        adicionarMessagem("Ja existe no banco", "Nenhuma infomação foi passada", FacesMessage.SEVERITY_ERROR);
    }
    
    public void invalido(String texto){
        adicionarMessagem("Erro!", texto+" invalido! Digite um "+texto+" valido", FacesMessage.SEVERITY_ERROR);
    }
    
    public void salvoComSucesso(){
        adicionarMessagem("Salvo com sucesso!!", "", FacesMessage.SEVERITY_INFO);
    }
    
    public void alteradoComSucesso(){
        adicionarMessagem("Alterado com sucesso!!", "", FacesMessage.SEVERITY_INFO);
    }
    
    public void deletadoComSucesso(){
        adicionarMessagem("Deletado com sucesso!!", "", FacesMessage.SEVERITY_INFO);
    }
}
