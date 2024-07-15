package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
  public static void main(String[] args) {
    Pessoa p1 = new Pessoa(null, "João da Silva", "joao.silva@email.com");
    Pessoa p2 = new Pessoa(null, "Maria de Souza", "maria.souza@email.com");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(p1);
    em.persist(p2);
    em.getTransaction().commit();

    Pessoa p3 = em.find(Pessoa.class, 2);
    em.getTransaction().begin();
    em.remove(p3);
    em.getTransaction().commit();

    System.out.println("Pronto!");
  }
}
