
package acme.features.authenticated.messageThread;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.message.Message;
import acme.entities.messageThread.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;

		//		boolean result;
		//		int threadId;
		//		MessageThread msgThread;
		//		Principal principal;
		//
		//		threadId = request.getModel().getInteger("id");
		//		msgThread = this.repository.findMessageThreadById(threadId);
		//		principal = request.getPrincipal();
		//		result = msg.getUserAccount().getId() == principal.getActiveRoleId();

		return true;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "message");

		//Collection<Authenticated> users = entity.getUsers();

		//model.setAttribute("users", users);

		Collection<Message> messages = entity.getMessage();

		model.setAttribute("message", messages);

	}
	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		assert request != null;

		MessageThread result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findMessageThreadById(id);

		return result;
	}

}
