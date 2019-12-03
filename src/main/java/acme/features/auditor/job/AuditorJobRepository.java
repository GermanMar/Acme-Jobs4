
package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.job.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where j.id in (select a.job.id from AuditRecord a where a.auditor.id = ?1)")
	Collection<Job> findManyByAuditorRecorded(int auditorid);

	@Query("select j from Job j where j.id not in (select a.job.id from AuditRecord a where a.auditor.id = ?1)")
	Collection<Job> findManyByAuditorNonRecorded(int auditorid);

}
