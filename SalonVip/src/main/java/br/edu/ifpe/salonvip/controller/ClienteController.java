/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.controller;

import br.edu.ifpe.salonvip.model.entidades.Cliente;
import br.edu.ifpe.salonvip.model.negocio.NegocioCliente;
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
public class ClienteController {
    
    private NegocioCliente negCliente;
    private Cliente cliente;
    private ArrayList<Cliente> listaCliente;
    
    public ClienteController(){
        negCliente = new NegocioCliente();
        cliente = new Cliente();
        listaCliente = new ArrayList<>();
    }
    
    public void salvar(){
        try {
            cliente.setCpf(cliente.getCpf().replace(".", ""));
            cliente.setCpf(cliente.getCpf().replace("-", ""));
            negCliente.inserir(cliente);
            limpar();
            Messagens.getInstance().salvoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
    }
    
    public void alterar(Cliente cli){
        try {
            negCliente.alterar(cli);
            limpar();
            Messagens.getInstance().alteradoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
    }
    
    public void deletar(){
        try {
            negCliente.deletar(cliente);
            limpar();
            Messagens.getInstance().deletadoComSucesso();
        } catch (Exception e) {
            Messagens.getInstance().nenhumaInfomacao();
        }
    }
    
    public void listar(){
        listaCliente = (ArrayList<Cliente>) negCliente.recuperarTodos();
    }
    
    public void buscarId(){
        negCliente.recuperar(cliente.getCodigo());
    }
    
    public Cliente burcarCpf(){
        return negCliente.recuperarCpf(cliente.getCpf());
    }
    
    public void limpar(){
        cliente = new Cliente();
    }

    public NegocioCliente getNegCliente() {
        return negCliente;
    }

    public void setNegCliente(NegocioCliente negCliente) {
        this.negCliente = negCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
}
