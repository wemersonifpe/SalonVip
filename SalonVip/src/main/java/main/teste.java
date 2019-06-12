/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import br.edu.ifpe.salonvip.model.entidades.Categoria;
import br.edu.ifpe.salonvip.model.entidades.Cliente;
import br.edu.ifpe.salonvip.model.entidades.Empresa;
import br.edu.ifpe.salonvip.model.entidades.Endereco;
import br.edu.ifpe.salonvip.model.entidades.Horarios;
import br.edu.ifpe.salonvip.model.entidades.Servico;
import br.edu.ifpe.salonvip.model.negocio.NegocioCategoria;
import br.edu.ifpe.salonvip.model.negocio.NegocioCliente;
import br.edu.ifpe.salonvip.model.negocio.NegocioEmpresa;
import br.edu.ifpe.salonvip.model.negocio.NegocioServico;
import br.edu.ifpe.salonvip.repositorio.implementacao.RepositorioClienteImplDB;
import java.util.ArrayList;
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
        NegocioCategoria negoc = new NegocioCategoria();
        
        
        Endereco endereco = new Endereco(12, "Av. Agamenon Magalhãs", "Novo Horizonte", "Garanhuns");
        Endereco endereco1 = new Endereco(30, "Gonsalves Dias", "Coabe dois", "Garanhuns");
        Endereco endereco2 = new Endereco(45, "Av. Santo Antonio", "Centro", "Garanhuns");
        
        Empresa empresa = new Empresa("005858", "Salão Vip", "salaovip@gmail.com", "salaovip", endereco);
        Empresa empresa1 = new Empresa("4747111", "Beleza Salão", "belezasalao@gmail.com", "beleza", endereco1);
        Empresa empresa2 = new Empresa("58914478", "Alice Salão de Beleza", "alicesalao@gmail.com", "alicesalao", endereco2);
        
        Cliente cliente = new Cliente("145454", "Beatriz da Silva", "beatrizsilva@gmail.com", "1454silva");
        Cliente cliente1 = new Cliente("12365478", "Ana Paula Silva", "anapaula@gmail.com", "14ana");
        Cliente cliente2 = new Cliente("789422552", "Maria Andreza", "mariaandreza@gmail.com", "maria15");
        
        /*Categoria categoria1 = new Categoria("Cabelo");
        Categoria categoria2 = new Categoria("Unhas");
        Categoria categoria3 = new Categoria("Facial");
        Categoria categoria4 = new Categoria("Maquiagem");*/
       
        
        /*Empresa emp = negoe.recuperar(4);
        Empresa emp1 = negoe.recuperar(6);
        Empresa emp2 = negoe.recuperar(8);
        
        
        Horarios hor = new Horarios("12:00");
        Horarios hor1 = new Horarios("11:00");
        Horarios hor2 = new Horarios("12:30");
        Horarios hor3 = new Horarios("13:00");
        Horarios hor4 = new Horarios("13:30");
        Horarios hor5 = new Horarios("14:00");
        
        ArrayList<Horarios> ho = new ArrayList<>();
        ho.add(hor);
        ho.add(hor1);
        ho.add(hor2);
        ho.add(hor3);
        ho.add(hor4);
        ho.add(hor5); 
        ArrayList<Horarios> ho1 = new ArrayList<>();
        ho1.add(hor);
        ho1.add(hor1);
        ho1.add(hor2);
        ho1.add(hor3);
        ho1.add(hor4);
        ho1.add(hor5);
        ArrayList<Horarios> ho2 = new ArrayList<>();
        ho2.add(hor);
        ho2.add(hor1);
        ho2.add(hor2);
        ho2.add(hor3);
        ho2.add(hor4);
        ho2.add(hor5);
        ArrayList<Horarios> ho3 = new ArrayList<>();
        ho3.add(hor);
        ho3.add(hor1);
        ho3.add(hor2);
        ho3.add(hor3);
        ho3.add(hor4);
        ho3.add(hor5);
        ArrayList<Horarios> ho4 = new ArrayList<>();
        ho4.add(hor);
        ho4.add(hor1);
        ho4.add(hor2);
        ho4.add(hor3);
        ho4.add(hor4);
        ho4.add(hor5);
        ArrayList<Horarios> ho5 = new ArrayList<>();
        ho5.add(hor);
        ho5.add(hor1);
        ho5.add(hor2);
        ho5.add(hor3);
        ho5.add(hor4);
        ho5.add(hor5);
        ArrayList<Horarios> ho6 = new ArrayList<>();
        ho6.add(hor);
        ho6.add(hor1);
        ho6.add(hor2);
        ho6.add(hor3);
        ho6.add(hor4);
        ho6.add(hor5);
        ArrayList<Horarios> ho7 = new ArrayList<>();
        ho7.add(hor);
        ho7.add(hor1);
        ho7.add(hor2);
        ho7.add(hor3);
        ho7.add(hor4);
        ho7.add(hor5);
        ArrayList<Horarios> ho8 = new ArrayList<>();
        ho8.add(hor);
        ho8.add(hor1);
        ho8.add(hor2);
        ho8.add(hor3);
        ho8.add(hor4);
        ho8.add(hor5);
        
        //servircos de cabelo codigo 10
        //Categoria cat = negoc.recuperar(10);
        /*Servico servico1 = negos.recuperar(22);
        servico1.setCategoria(cat);
        negos.alterar(servico1);
        
        Servico servico2 = negos.recuperar(23);
        servico2.setCategoria(cat);
        negos.alterar(servico2);
        
        Servico servico3 = negos.recuperar(24);
        servico3.setCategoria(cat);
        negos.alterar(servico3);
        
        //servicos de facial codido 12*/
        //Categoria cat2 = negoc.recuperar(12);
        /*Servico servico = negos.recuperar(14);
        servico.setCategoria(cat2);
        negos.alterar(servico);
        ESTE SERVICO JA TEM HORARIOS
        
        Servico servico4 = negos.recuperar(25);
        servico4.setCategoria(cat2);
        negos.alterar(servico4);
        
        Servico servico5 = negos.recuperar(26);
        servico5.setCategoria(cat2);
        negos.alterar(servico5);
        
        //servicos de unhas codigo 11*/
        //Categoria cat1 = negoc.recuperar(11);
        /*Servico servico6 = negos.recuperar(27);
        servico6.setCategoria(cat1);
        negos.alterar(servico6);
        
        Servico servico7 = negos.recuperar(28);
        servico7.setCategoria(cat1);
        negos.alterar(servico7);
        
        Servico servico8 = negos.recuperar(29);
        servico8.setCategoria(cat1);
        negos.alterar(servico8);*/
        
        
        /*nego.inserir(cliente);
        nego.inserir(cliente1);
        nego.inserir(cliente2);
        negoe.inserir(empresa);
        negoe.inserir(empresa1);
        negoe.inserir(empresa2);
        negoc.inserir(categoria1);
        negoc.inserir(categoria2);
        negoc.inserir(categoria3);
        negoc.inserir(categoria4);*/
        
        /*Servico servico = new Servico("Tratamento Antienvelhecimento", 60, 50, emp1, "Servico destinado a fazer as umhas das mãos", cat2, ho);
        Servico servico4 = new Servico("Oxigenação Facial", 60, 50, emp2, "Servico destinado a fazer as umhas das mãos", cat2, ho1);
        Servico servico5 = new Servico("Limpeza Profunda Facial", 60, 50, emp1, "Servico destinado a fazer as umhas das mãos", cat2, ho2);
        
        Servico servico1 = new Servico("Corte de Cabelo", 30, 60, emp2, "Corte de cabelos de acordo com o pedido da cliente", cat, ho3);
        Servico servico2 = new Servico("Mechas", 60, 50, emp2, "Mechas no cabelos de acordo com o pedido da cliente", cat, ho4);
        Servico servico3 = new Servico("Tratamento de Cabelo", 30, 50, emp1, "Servico destinado ao tramento de cabelos", cat, ho5);
        
        Servico servico6 = new Servico("Pedicure", 30, 50, emp1, "Servico destinado as unhas dos pés", cat1, ho6);
        Servico servico7 = new Servico("Manicure em Gel", 30, 50, emp2, "Servico destinado as unhas das mãos", cat1, ho7);
        Servico servico8 = new Servico("Spa dos Pés", 30, 50, emp1, "Servico destinado ao tramento dos pés", cat1, ho8);*/

        /*if(emp1 != null && emp2 != null){
            negos.inserir(servico);
            negos.inserir(servico1);
            negos.inserir(servico2);
            negos.inserir(servico3);
            negos.inserir(servico4);
            negos.inserir(servico5);
            negos.inserir(servico6);
            negos.inserir(servico7);
            negos.inserir(servico8);
        }else{
            System.out.println("EMPRESA CONTINUA NULA");
        }*/
       
       //System.out.println("EMPRESA: " + negoe.recuperarCnpj("4747111"));
      
        /*List<Cliente> e = nego.recuperarTodos();
        
        for(Cliente r : e){
            if(r.getNome().equals("Beatriz da Silva")){
                System.out.println("DEU CERTO!");
            } else {
                System.out.println("DEU ERRADO!");
            }
        }*/
       /* Cliente cliente2 = new Cliente();
        cliente2.setCodigo(3);
        cliente2.setCpf("3232");
        RepositorioClienteImplDB r = new RepositorioClienteImplDB();
        r.deletar(cliente2);*/
    }
    
}
