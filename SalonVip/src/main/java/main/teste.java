/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import br.edu.ifpe.salonvip.model.entidades.Cliente;
import br.edu.ifpe.salonvip.model.entidades.Empresa;
import br.edu.ifpe.salonvip.model.entidades.Endereco;
import br.edu.ifpe.salonvip.model.entidades.Servico;
import br.edu.ifpe.salonvip.model.negocio.NegocioCliente;
import br.edu.ifpe.salonvip.model.negocio.NegocioEmpresa;
import br.edu.ifpe.salonvip.model.negocio.NegocioServico;
import br.edu.ifpe.salonvip.repositorio.implementacao.RepositorioClienteImplDB;
import java.util.List;

/**
 *
 * @author wemerson
 */
public class teste {
    public static void main(String args[]) throws Exception{
        
        NegocioCliente nego = new NegocioCliente();
        NegocioEmpresa negoe = new NegocioEmpresa();
        NegocioServico negos = new NegocioServico();
        
        /*Endereco endereco = new Endereco(12, "Av. Agamenon Magalhãs", "Novo Horizonte", "Gararanhuns");
        Endereco endereco1 = new Endereco(30, "Gonsalves Dias", "Coabe dois", "Garanhuns", "PE");
        
        Empresa empresa = new Empresa("005858", "Salão Vip", "salaovip@gmail.com", "salaovip", endereco);
        Empresa empresa1 = new Empresa("4747111", "Beleza Salão", endereco1, "belezasalao@gmail.com", "beleza");
        
        Cliente cliente = new Cliente("145454", "Beatriz da Silva", "beatrizsilva@gmail.com", "1454silva");
        
        Empresa emp = negoe.recuperar(5);
        Empresa emp1 = negoe.recuperar(10);
        
        Servico servico = new Servico("Manicure", 10, 8, emp1, "Servico destinado a fazer as umhas das mãos", "Unhas");
        Servico servico1 = new Servico("Corte de Cabelo", 20, 12, emp1, "Corte de cabelos de acordo com o pedido da cliente", "Cabelo");
        /*Servico servico2 = new Servico("Corte de Cabelo", 20, 12, emp1, "Corte de cabelos de acordo com o pedido da cliente");
        Servico servico3 = new Servico("Manicure", 10, 8, emp1, "Servico destinado a fazer as umhas das mãos");
        
        Cliente cliente0 = new Cliente("12345", "Fulano da Silva", "fulanosilva@gmail.com", "123silva");
        Cliente cliente1 = new Cliente("2525", "Beltrano da Silva", "beltranosilva@gmail.com", "2525silva");
        Cliente cliente2 = new Cliente("3232", "Ana Beatriz da Silva", "anasilva@gmail.com", "3232silva");*/
        
        //nego.inserir(cliente);
        //negoe.inserir(empresa);
        //negoe.inserir(empresa1);

        //negos.inserir(servico);
        //negos.inserir(servico1);
       //negos.inserir(servico2);
       //negos.inserir(servico3);
       
       //System.out.println("EMPRESA: " + negoe.recuperarCnpj("4747111"));
      
        /*List<Cliente> e = nego.recuperarTodos();
        
        for(Cliente r : e){
            if(r.getNome().equals("Beatriz da Silva")){
                System.out.println("DEU CERTO!");
            } else {
                System.out.println("DEU ERRADO!");
            }
        }*/
        Cliente cliente2 = new Cliente();
        cliente2.setCodigo(3);
        cliente2.setCpf("3232");
        RepositorioClienteImplDB r = new RepositorioClienteImplDB();
        r.deletar(cliente2);
    }
    
}
