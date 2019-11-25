
package acme.features.administrator.dashboards;

import java.util.Collection;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Integer totalAnnouncements = this.repository.getTotalAnnouncements();
		Integer totalInvestor = this.repository.getTotalInvestorRecords();
		Integer totalCompany = this.repository.getTotalCompanyRecords();
		Double minimumRequest = this.repository.getMinimumRequest();
		Double minimumOffers = this.repository.getMinimumOffers();
		Double maximumRequest = this.repository.getMaximumRequest();
		Double maximumOffers = this.repository.getMaximumOffers();
		Double averageRequest = this.repository.getAverageRequest();
		Double averageOffers = this.repository.getAverageOffers();
		Double desviationRequest = this.repository.getDesviationRequest();
		Double desviationOffers = this.repository.getDesviationOffers();

		request.unbind(entity, model, "labels", "numC", "numI");

		model.setAttribute("totalAnnouncements", totalAnnouncements);
		model.setAttribute("totalInvestor", totalInvestor);
		model.setAttribute("totalCompany", totalCompany);
		model.setAttribute("minimumRequest", minimumRequest);
		model.setAttribute("minimumOffers", minimumOffers);
		model.setAttribute("maximumOffers", maximumOffers);
		model.setAttribute("maximumRequest", maximumRequest);
		model.setAttribute("averageRequest", averageRequest);
		model.setAttribute("averageOffers", averageOffers);
		model.setAttribute("desviationRequest", desviationRequest);
		model.setAttribute("desviationOffers", desviationOffers);

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		Collection<Object[]> com = this.repository.findAllCompanies();
		Collection<Object[]> inv = this.repository.findAllInvestors();
		int i = 0;
		String op;

		String[] numC;
		String[] numI;

		for (Object[] o : com) {

			if (ArrayUtils.contains(result.getLabels(), o[0].toString())) {
				i = ArrayUtils.lastIndexOf(result.getLabels(), o[0].toString());
				numC = result.getNumC();
				op = Integer.toString(Integer.parseInt(numC[i]) + Integer.parseInt(o[1].toString()));
				result.setNumI(ArrayUtils.remove(result.getNumC(), i));
				result.setNumC(ArrayUtils.insert(i, result.getNumC(), op));
			}

			if (!ArrayUtils.contains(result.getLabels(), o[0].toString())) {
				result.setLabels(ArrayUtils.add(result.getLabels(), o[0].toString()));
				result.setNumC(ArrayUtils.add(result.getNumC(), o[1].toString()));
				result.setNumI(ArrayUtils.add(result.getNumI(), "0"));

			}
		}

		for (Object[] o : inv) {
			if (ArrayUtils.contains(result.getLabels(), o[0].toString())) {
				i = ArrayUtils.lastIndexOf(result.getLabels(), o[0].toString());
				numI = result.getNumI();
				op = Integer.toString(Integer.parseInt(numI[i]) + Integer.parseInt(o[1].toString()));
				result.setNumI(ArrayUtils.remove(result.getNumI(), i));
				result.setNumI(ArrayUtils.insert(i, result.getNumI(), op));
			}

			if (!ArrayUtils.contains(result.getLabels(), o[0].toString())) {
				result.setLabels(ArrayUtils.add(result.getLabels(), o[0].toString()));
				result.setNumI(ArrayUtils.add(result.getNumI(), o[1].toString()));
				result.setNumC(ArrayUtils.add(result.getNumC(), "0"));

			}
		}

		return result;
	}

}
