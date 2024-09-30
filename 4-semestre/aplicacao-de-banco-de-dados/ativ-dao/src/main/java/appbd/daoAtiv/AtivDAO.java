package appbd.daoAtiv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class AtivDAO {

	public static void main(String[] args) throws ParseException {
		DAO dao = new EmprestimoDAO();
		EntityManager em = dao.getEntityManager();

		incluirEmprestimo(em);
		// altera(em);
		em.close();
	}

	private static void incluirEmprestimo(EntityManager em) throws ParseException {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 

                Date dataFormatada1 = formato.parse("25/03/2024"); 
                Date dataFormatada2 = formato.parse("31/03/2024"); 
                
		Emprestimo m = new Emprestimo(1, dataFormatada1, dataFormatada2);

		
		transaction.commit();
	}

}