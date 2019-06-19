/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.util;

import br.edu.ifpe.salonvip.model.entidades.Categoria;
import br.edu.ifpe.salonvip.model.negocio.NegocioCategoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author wemerson
 */
@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter{
    
    private NegocioCategoria negocioCategoria = new NegocioCategoria();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Categoria categoria;
        categoria = null;
        try {
           int idCategoria = Integer.parseInt(string);
           categoria = this.negocioCategoria.recuperar(idCategoria);
        } catch (Exception e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
        return categoria;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object ob) {
        Categoria categoria = (Categoria) ob;
        return categoria.getCodigo() + "";
    }
    
}
