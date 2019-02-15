/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.negocio;

import br.edu.ifpe.salonvip.model.entidades.Empresa;
import br.edu.ifpe.salonvip.repositorio.implementacao.RepositorioEmpresaImplDB;
import br.edu.ifpe.salonvip.util.TratamentoException;
import java.util.Collections;
import java.util.List;
import br.edu.ifpe.salonvip.interfaces.InterfaceEmpresa;

/**
 *
 * @author wemerson
 */
public class NegocioEmpresa implements InterfaceEmpresa<Empresa>{
    
    private RepositorioEmpresaImplDB repEmpresa;
    private Empresa emp;
    
    public NegocioEmpresa(){
        repEmpresa = new RepositorioEmpresaImplDB();
    }

    @Override
    public Empresa autenticar(String login, String senha) {
        if(login == null || senha == null)
            return null;
        return ((RepositorioEmpresaImplDB) repEmpresa).autenticar(login, senha);
    }

    @Override
    public Empresa recuperarCnpj(String cnpj) {
        if(cnpj == null){
            return null;
        }else{
            emp = repEmpresa.recuperarCnpj(cnpj);
            if(emp == null){
                return null;
            }else{
                return emp;
            }
        }
    }

    @Override
    public void inserir(Empresa empresa) throws Exception {
        if(empresa == null || recuperar(empresa.getCodigo()) != null){
            TratamentoException.erroAoSalva();
        }else{
            repEmpresa.inserir(empresa);
        }
    }

    @Override
    public Empresa recuperar(Integer codigo) {
        if(codigo == null){
            return null;
        }else{
            emp = repEmpresa.recuperar(codigo);
            if(emp == null){
                return null;
            }else{
                return emp;
            }
        }
    }

    @Override
    public void alterar(Empresa empresa) throws Exception {
        if(empresa == null || recuperar(empresa.getCodigo()) == null){
            TratamentoException.erroAoAlterar();
        }else{
            repEmpresa.alterar(empresa);
        }
    }

    @Override
    public void deletar(Empresa empresa) throws Exception {
        if(empresa == null || recuperar(empresa.getCodigo()) == null){
            TratamentoException.erroAoDeletar();
        }else{
            repEmpresa.deletar(empresa);
        }
    }

    @Override
    public List<Empresa> recuperarTodos() {
        List lista = repEmpresa.recuperarTodos();
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }
    
}
