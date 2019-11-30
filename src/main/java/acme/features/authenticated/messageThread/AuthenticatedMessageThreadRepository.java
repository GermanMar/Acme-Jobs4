
package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.messageThread.MessageThread;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	@Query("select m from MessageThread m join m.users u where u.id = ?1")
	Collection<MessageThread> findManyMessageThreadByUserId(int id);

	@Query("select mt from MessageThread mt where mt.id=?1")
	MessageThread findMessageThreadById(int id);
}
