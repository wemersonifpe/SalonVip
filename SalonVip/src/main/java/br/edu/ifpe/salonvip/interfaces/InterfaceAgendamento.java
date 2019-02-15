/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.interfaces;

import br.edu.ifpe.salonvip.model.entidades.Agendamento;
import java.util.List;

/**
 *
 * @author wemerson
 */
public interface InterfaceAgendamento extends DAO<Agendamento>{
    public List listarAgendamentosEmpresa(int id);
    public List listarAgendamentosCliente(int id);
}
