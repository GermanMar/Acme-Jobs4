
package acme.features.employer.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.application.Application;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/application")
public class EmployerApplicationsController extends AbstractController<Employer, Application> {

	//Internal state

	@Autowired
	private EmployerApplicationsListService	listServiceMine;

	@AutoWired
	private EmployerApplicationsShowService	showService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addCustomCommand(BasicCommand.LIST, CustomCommand.LIST_MINE, this.listServiceMine);
		super.addBasicCommand(BasicCommand.LIST, this.showService);

	}

}
