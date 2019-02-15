/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.interfaces;

import java.util.List;

/**
 *
 * @author wemerson
 */
public interface DAO<E> {
    
    public void inserir(E e) throws Exception;
    public E recuperar(Integer codigo);
    public void alterar(E e) throws Exception;
    public void deletar(E e) throws Exception;
    public List<E> recuperarTodos();
    
}
