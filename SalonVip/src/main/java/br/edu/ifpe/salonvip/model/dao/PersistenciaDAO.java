/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.salonvip.model.dao;

import br.edu.ifpe.salonvip.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

/**
 *
 * @author wemerson
 */
public class PersistenciaDAO {
    
    private final SessionFactory sessionFactory;
    private static PersistenciaDAO instance = null;
    
    public static PersistenciaDAO getInstance(){
        if(instance == null){
            instance = new PersistenciaDAO();
        }
        return instance;
    }
    
    private PersistenciaDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public void salvar(Object o){
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.save(o);
            transacao.commit();
        } catch (RuntimeException e) {
            if(transacao != null){
                transacao.rollback();
            }
            throw e;
        } finally{
            session.close();
        }
    }
    
    public void editar(Object o){
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.update(o);
            transacao.commit();
        } catch (RuntimeException e) {
            if(transacao != null){
                transacao.rollback();
            }
            throw e;
        } finally{
            session.close();
        }
    }
    
    public void deletar(Object o){
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.delete(o);
            transacao.commit();
        } catch (RuntimeException e) {
            if(transacao != null){
                transacao.rollback();
            }
            throw e;
        } finally{
            session.close();
        }
    }
    
    public List listar(String sql){
        Session session = this.sessionFactory.openSession();
        List lista = null;
        
        try {
            Query consulta = session.createQuery(sql);
            lista = (List) consulta.list();
        } catch (RuntimeException e) {
            throw e;
        } finally{
            session.close();
        }
        return lista;
    }
    
    public Object autenticar(String sql, String login, String senha){
        Session session = this.sessionFactory.openSession();
        Object obj= null;
        
        try {
            Query consulta = session.createQuery(sql+"WHERE a.login = :login AND a.senha = :senha");
            consulta.setString("login", login);
            consulta.setString("senha", senha);
            obj = consulta.uniqueResult();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            session.close();
        }
        return obj;
    }
    
}
