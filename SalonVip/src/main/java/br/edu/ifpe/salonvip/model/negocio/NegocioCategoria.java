/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.negocio;

import br.edu.ifpe.salonvip.interfaces.DAO;
import br.edu.ifpe.salonvip.model.entidades.Categoria;
import br.edu.ifpe.salonvip.repositorio.implementacao.RepositorioCategoriaImplDB;
import br.edu.ifpe.salonvip.util.TratamentoException;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class NegocioCategoria implements DAO<Categoria>{
    
    public RepositorioCategoriaImplDB repCat;
    public Categoria cat;
    
    public NegocioCategoria(){
        repCat = new RepositorioCategoriaImplDB();
    }

    @Override
    public void inserir(Categoria categoria) throws Exception {
        if(categoria == null || repCat.recuperar(categoria.getCodigo()) != null){
            TratamentoException.erroAoSalva();
        }else{
            repCat.inserir(categoria);
        }
    }

    @Override
    public Categoria recuperar(Integer codigo) {
        if(codigo == null){
            return null;
        }else{
            cat = repCat.recuperar(codigo);
            if(cat == null){
                return null;
            }else{
                return cat;
            }
        }
    }

    @Override
    public void alterar(Categoria categoria) throws Exception {
        if(categoria == null || repCat.recuperar(categoria.getCodigo()) == null){
            TratamentoException.erroAoAlterar();
        }else{
            repCat.alterar(categoria);
        }
    }

    @Override
    public void deletar(Categoria categoria) throws Exception {
        if(categoria == null || repCat.recuperar(categoria.getCodigo()) == null){
            TratamentoException.erroAoDeletar();
        }else{
            repCat.deletar(categoria);
        }
    }

    @Override
    public List<Categoria> recuperarTodos() {
        List lista = repCat.recuperarTodos();
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }
    
}
