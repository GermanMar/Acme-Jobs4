
package acme.features.employer.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.application.Application;
import acme.framework.repositories.AbstractRepository;

public interface EmployerApplicationsRepository extends AbstractRepository {

	@Query("select a from Application where a.job.employer.id = ?1")
	Collection<Application> findManyByEmployerId(int id);

}
