/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.util;

/**
 *
 * @author wemerson
 */
public class TratamentoException {
    
    private static Exception e;
    
    private TratamentoException(){
        
    }
    
    public static void erroAoSalva() throws Exception{
        e = new Exception();
        throw new Exception("Erro ao salvar!",e.getCause());
    }
    
    public static void erroAoAlterar() throws Exception{
        e = new Exception();
        throw new Exception("Erro ao alterar!",e.getCause());
    }
    
    public static void erroAoDeletar() throws Exception{
        e = new Exception();
        throw new Exception("Erro ao deletar!",e.getCause());
    }
}
