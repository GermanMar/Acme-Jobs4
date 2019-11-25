
package acme.features.administrator.spamlist;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spamlist.Spamlist;
import acme.entities.spamlist.Spamword;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSpamlistRepository extends AbstractRepository {

	@Query("select a from Spamlist a")
	Collection<Spamlist> findManyAll();

	@Query("select a from Spamlist a where a.id = ?1")
	Spamlist findOneById(int id);

	//	This query search a specific Spamword from a Spamlist by the Spamword text and the Spamlist id.
	@Query(value = "select * from Spamword inner join Spamlist inner join spamlist_spamword where spamword.id = spamlist_spamword.spamwordslist_id AND spamlist.id = spamlist_spamword.spamlist_id and spamword.spamword = ?1 and spamlist.id = ?2",
		nativeQuery = true)
	Spamword findOneSpamword(String spamword, int id);

	//   This query eliminates the relationship between Spamword and Spamlist with the id of the spamword.
	@Modifying
	@Query(value = "delete from spamlist_spamword where spamwordslist_id = ?1", nativeQuery = true)
	void deleteSpamwordRelationship(int id);

	//	This query removes the Spamword with the id of the spamword.
	@Modifying
	@Query("delete from Spamword where id = ?1")
	void deleteSpamword(int id);

}
