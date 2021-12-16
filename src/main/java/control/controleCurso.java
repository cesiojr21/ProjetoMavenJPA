package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Curso;

public class controleCurso {
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public controleCurso() {
		emf = Persistence.createEntityManagerFactory("projeto"); 
		 em = emf.createEntityManager(); 
	}
	public void inserir(Curso objeto) {
		try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            
         } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
         }
	}
	public void alterar(Curso objeto) {
		try {
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
         }
	}
	public void excluir(Curso objeto) {
		try {
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
         }
	}
	public void excluirPorId(Integer id) {
		try {
            Curso objeto = buscarPorId(id);
            excluir(objeto);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
	}
	public Curso buscarPorId(Integer id) {
		
		return em.find(Curso.class, id)
;}
	public List<Curso> buscarTodos() {
		String nomeClasse = Curso.class.getName();
		return em.createQuery("FROM " + nomeClasse).getResultList();}
	
	
}
	
	
	


