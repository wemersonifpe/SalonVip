/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.entidades;

/**
 *
 * @author wemerson
 */
public enum StatusAgenda {
    ESPERA(1), AGENDADO(2), REALIZADO(3), CANCELADO(4);
    
    private final int valor;
    
    private StatusAgenda(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}
