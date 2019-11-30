
package acme.features.sponsor.noncommercial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.nonCommercial.NonCommercial;
import acme.entities.roles.Sponsor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class SponsorNonCommercialShowService implements AbstractShowService<Sponsor, NonCommercial> {

	@Autowired
	SponsorNonCommercialRepository repository;


	@Override
	public boolean authorise(final Request<NonCommercial> request) {
		assert request != null;

		//		boolean result;
		//		NonCommercial NonCommercial;
		//		int NonCommercialId;
		//		Sponsor sponsor;
		//		Principal principal;
		//
		//		NonCommercialId = request.getModel().getInteger("id");
		//		NonCommercial = this.repository.findOneNonCommercialBannerById(NonCommercialId);
		//		sponsor = NonCommercial.getSponsor();
		//		principal = request.getPrincipal();
		//		result = sponsor.getUserAccount().getId() == principal.getActiveRoleId();

		return true;
	}

	@Override
	public void unbind(final Request<NonCommercial> request, final NonCommercial entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "banner", "slogan", "url", "jingle");

	}

	@Override
	public NonCommercial findOne(final Request<NonCommercial> request) {
		assert request != null;

		NonCommercial result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneNonCommercialBannerById(id);

		return result;
	}

}
