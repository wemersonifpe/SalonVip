/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.controller;

import br.edu.ifpe.salonvip.model.entidades.Cliente;
import br.edu.ifpe.salonvip.model.entidades.Empresa;
import br.edu.ifpe.salonvip.model.negocio.NegocioCliente;
import br.edu.ifpe.salonvip.model.negocio.NegocioEmpresa;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author wemerson
 */
@ManagedBean
@SessionScoped
public class AutenticarBean {
    private String email;
    private String senha;
    private Cliente clienteLogin = null;
    private Empresa empresaLogin = null;
    
    public AutenticarBean(){
        clienteLogin = new Cliente();
        empresaLogin = new Empresa();
    }
    
    public String entrar(){
        System.out.println("ESTA FUNCIONANDO PASSO 1");
        NegocioCliente neg = new NegocioCliente();
        clienteLogin = neg.autenticar(email, senha);
        
        if(clienteLogin != null){
            System.out.println("ESTA FUNCIONANDO PASSO 2");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteLogado", this.clienteLogin);
            return "cliente/visualizarservicos.xhtml?faces-redirect=true";
        }else{
            System.out.println("ESTA FUNCIONANDO PASSO 3");
            NegocioEmpresa negEmp = new NegocioEmpresa();
            empresaLogin = negEmp.autenticar(email, senha);
            
            if(empresaLogin != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresaLogado", this.empresaLogin);
                return "empresa/menu.xhtml?faces-redirect=true";
            }
        }
        if(clienteLogin == null && empresaLogin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro ao fazer login!"));
        }
        
        return "index.xhtml";
    }
    
    public String sair() {
        clienteLogin = null;
        empresaLogin = null;
        email = "";
        senha = "";
        return "../index.xhtml?faces-redirect=true";
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public Cliente getClienteLogin(){
        return clienteLogin;
    }
    
    public void setClienteLogiin(Cliente clienteLogin){
        this.clienteLogin = clienteLogin;
    }

    public Empresa getEmpresaLogin() {
        return empresaLogin;
    }

    public void setEmpresaLogin(Empresa empresaLogin) {
        this.empresaLogin = empresaLogin;
    }
    
}
