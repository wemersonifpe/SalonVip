/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.interfaces;

import br.edu.ifpe.salonvip.model.entidades.Servico;
import java.util.List;

/**
 *
 * @author wemerson
 */
public interface InterfaceServico extends DAO<Servico>{
    public List buscarServicosPorEmpresa(int id);
    public List buscarServicoPorCategoria(String categoria);
}
