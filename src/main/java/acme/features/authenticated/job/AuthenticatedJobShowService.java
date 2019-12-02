
package acme.features.authenticated.job;

import java.util.Collection;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.descriptor.Descriptor;
import acme.entities.duty.Duty;
import acme.entities.job.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedJobShowService implements AbstractShowService<Authenticated, Job> {

	@Autowired
	AuthenticatedJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		Job job;
		int jobId;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = job.isFinalMode() || !job.isFinalMode() && employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "status", "title", "deadline");
		request.unbind(entity, model, "salary", "moreInfo", "description", "finalMode");

		Descriptor descriptor = entity.getDescriptor();

		model.setAttribute("descriptor", descriptor.getDescription());

		Collection<Duty> duties = this.repository.findManyDutiesById(descriptor.getId());

		model.setAttribute("duties", duties);

		@URL
		String auditURL = "/acme-jobs/authenticated/audit-record/list?id=" + entity.getId();

		model.setAttribute("auditURL", auditURL);
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;
	}

}
