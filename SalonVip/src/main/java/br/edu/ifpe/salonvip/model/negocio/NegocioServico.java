/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.negocio;

import br.edu.ifpe.salonvip.interfaces.DAO;
import br.edu.ifpe.salonvip.interfaces.InterfaceServico;
import br.edu.ifpe.salonvip.model.entidades.Categoria;
import br.edu.ifpe.salonvip.model.entidades.Servico;
import br.edu.ifpe.salonvip.repositorio.implementacao.RepositorioServicoImplDB;
import br.edu.ifpe.salonvip.util.TratamentoException;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class NegocioServico implements InterfaceServico{
    
    public RepositorioServicoImplDB repServico;
    public Servico serv;
    
    public NegocioServico(){
        repServico = new RepositorioServicoImplDB();
    }

    @Override
    public void inserir(Servico servico) throws Exception {
        if(servico == null ||  repServico.recuperar(servico.getCodigo()) != null){
            TratamentoException.erroAoSalva();
        }else{
            repServico.inserir(servico);
        }
    }

    @Override
    public Servico recuperar(Integer codigo) {
        if(codigo == null){
            return null;
        }else{
            serv = repServico.recuperar(codigo);
            if(serv == null){
                return null;
            }else{
                return serv;
            }
        }
    }

    @Override
    public void alterar(Servico servico) throws Exception {
        if(servico == null || recuperar(servico.getCodigo()) == null){
            TratamentoException.erroAoAlterar();
        }else{
            repServico.alterar(servico);
        }
    }

    @Override
    public void deletar(Servico servico) throws Exception {
        if(servico == null || recuperar(servico.getCodigo()) == null){
            TratamentoException.erroAoDeletar();
        }else{
            repServico.deletar(servico);
        }
    }

    @Override
    public List<Servico> recuperarTodos() {
        List lista = repServico.recuperarTodos();
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }

    @Override
    public List buscarServicosPorEmpresa(int id) {
        List lista = repServico.buscarServicosPorEmpresa(id);
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }
    
    @Override
    public List buscarServicoPorCategoria(Categoria categoria){
        List lista = repServico.buscarServicoPorCategoria(categoria);
        if(lista == null){
            return null;
        }else{
            return lista;
        }
    }
    
}
