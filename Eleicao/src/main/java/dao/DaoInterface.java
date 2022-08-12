package dao;
import model.*;
import org.hibernate.*;
import util.*;
import java.util.*;
public class DaoInterface implements Interface{

    @Override
    public Usuario logar(String login, String senha) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            Query query = session.createQuery
        ("from Usuario where login=:log and senha=:sen");
            query.setString("log", login);
            query.setString("sen",senha);
            Usuario usuario = (Usuario)query.uniqueResult();
            tx.commit();
            return usuario;
        }catch(Exception ex){
            throw ex;
        }//try-catch
    }//logar

    @Override
    public List<Candidato> preencheCan() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List lista = null;
        try{
            lista = session.createCriteria(Candidato.class).list();
            tx.commit();
        }catch(Exception ex){
            throw ex;
        }//try-catch
        return lista;
    }//preencheCan

    @Override
    public String votar(Voto voto) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(voto);
            tx.commit();
        }catch(Exception ex){
            throw ex;
        }//try-catch
        return "";
    }//votar

    @Override
    public void novoCan(Candidato candidato) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(candidato);
            tx.commit();
        }catch(Exception ex){
            throw ex;
        }//try-catch
    }//novoCan

    @Override
    public List<Object[]> apuracao() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Object[]> lista = null;
        try{
            Query query = session.createQuery
        ("select c.idcan, c.nomecan, c.chapa, count(v.idcan) from Voto v inner join v.idcan as c group by v.idcan");
        lista = query.list();
        tx.commit();
        }catch(Exception ex){
            throw ex;
        }//try-catch
        return lista;
    }//apuracao

    
}//class
