
package acme.features.administrator.spamlist;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamlist.Spamlist;
import acme.entities.spamlist.Spamword;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorSpamlistUpdateService implements AbstractUpdateService<Administrator, Spamlist> {

	@Autowired
	AdministratorSpamlistRepository repository;


	@Override
	public boolean authorise(final Request<Spamlist> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Spamlist> request, final Spamlist entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "spamwordslist");
	}

	@Override
	public void unbind(final Request<Spamlist> request, final Spamlist entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		StringBuilder buffer;
		Collection<Spamword> spamwords;

		request.unbind(entity, model, "threshold");

		spamwords = entity.getSpamwordslist();
		buffer = new StringBuilder();
		buffer.append("[");
		Integer x = spamwords.size();
		Integer i = 0;
		for (Spamword word : spamwords) {
			buffer.append(word.getSpamword());
			if (i < x - 1) {
				buffer.append(", ");
			}
			i++;
		}

		model.setAttribute("spamwordslist", buffer.toString() + "]");
	}

	@Override
	public Spamlist findOne(final Request<Spamlist> request) {
		assert request != null;

		Spamlist result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Spamlist> request, final Spamlist entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		String nw;
		String delete;
		Spamword actualSpamword;
		Spamword deleteSpamword;

		if (!errors.hasErrors("deleteSpamword") && !errors.hasErrors("newSpamword")) {
			nw = request.getModel().getString("newSpamword");

			delete = request.getModel().getString("deleteSpamword");

			errors.state(request, !nw.equals(delete) || nw == "" && delete == "", "newSpamword", "administrator.spamlist.form.error.same", delete, nw);
		}

		if (!errors.hasErrors("newSpamword")) {
			nw = request.getModel().getString("newSpamword");

			actualSpamword = this.repository.findOneSpamword(nw, entity.getId());

			errors.state(request, actualSpamword == null, "newSpamword", "administrator.spamlist.form.error.duplicated", nw);
		}

		if (!errors.hasErrors("deleteSpamword")) {
			delete = request.getModel().getString("deleteSpamword");

			deleteSpamword = this.repository.findOneSpamword(delete, entity.getId());

			errors.state(request, deleteSpamword != null || delete == "", "newSpamword", "administrator.spamlist.form.error.no-exist", delete);
		}

	}

	@Override
	public void update(final Request<Spamlist> request, final Spamlist entity) {
		assert request != null;
		assert entity != null;

		String nw = request.getModel().getString("newSpamword");
		String delete = request.getModel().getString("deleteSpamword");

		Collection<Spamword> spamwordslist = entity.getSpamwordslist();

		//Add a new spamword.
		//1. Create the new Spamword.
		Spamword newSpamword = new Spamword();
		newSpamword.setSpamword(nw);

		//2.Check that the written data is not empty.
		if (nw != "") {
			//3.Add the Spamword to the spamwordslist attribute in Spamlist. This makes it persist in the database.
			spamwordslist.add(newSpamword);
		}

		//Delete a existing spamword.
		//1.Check that the written data is not empty.
		if (delete != "") {
			//2. Try searching the Spamword in the database.
			Spamword deleteSpamword = this.repository.findOneSpamword(delete, entity.getId());
			//3.Remove the Spamword from the spamwordslist attribute in Spamlist.
			spamwordslist.remove(deleteSpamword);
			//4.Delete the relationship from Spamword and Spamlist. Necessary to delete the Spamword
			this.repository.deleteSpamwordRelationship(deleteSpamword.getId());
			//5. Delete the Spamword in the database.
			this.repository.deleteSpamword(deleteSpamword.getId());
		}

		//Save the updated spamwordslist.
		entity.setSpamwordslist(spamwordslist);

		this.repository.save(entity);
	}

}
