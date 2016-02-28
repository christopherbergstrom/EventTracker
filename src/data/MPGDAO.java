package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MPGDAO
{
	@PersistenceContext
	private EntityManager em;

	public List<MPG> getData()
	{
		return em.createQuery("select mpg from MPG mpg", MPG.class).getResultList();
	}

	public MPG getById(int id)
	{
		return em.find(MPG.class, id);
	}

	// mine
	public Boolean createMPG(MPG mpg)
	{
		em.persist(mpg);
		if (!em.contains(mpg))
		{
			return false;
		} 
		else
		{
			return true;
		}
	}

	public Boolean updateMPG(int id, MPG mpg)
	{
		System.out.println("updating");
		System.out.println(mpg);
		mpg.setId(id);
		mpg = em.merge(mpg);
		em.persist(mpg);
		if (!em.contains(mpg))
		{
			return false;
		} 
		else
		{
			return true;
		}
	}

	public Boolean deleteMPG(int id)
	{
		MPG mpg = em.find(MPG.class, id);
		em.remove(mpg);
		if (em.contains(mpg))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	// example
//	public Boolean createEmployee(Employee e)
//	{
//		em.persist(e);
//		if (!em.contains(e))
//		{
//			return false;
//		} else
//		{
//			return true;
//		}
//	}
//
//	public Boolean updateEmployee(int id, Employee e)
//	{
//		Employee emp = em.merge(e);
//		if (!em.contains(emp))
//		{
//			return false;
//		} else
//		{
//			return true;
//		}
//	}
//
//	public Boolean deleteEmployee(int id)
//	{
//		Employee e = em.find(Employee.class, id);
//		em.remove(e);
//		if (em.contains(e))
//		{
//			return false;
//		} else
//		{
//			return true;
//		}
//	}
}
