
package acme.features.worker.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.application.Application;
import acme.framework.components.BasicCommand;

@Controller
@RequestMapping("/worker/application/")
public class WorkerApplicationsController extends AbstractController<Worker, Application> {

	@Autowired
	private WorkerApplicationsListService	listMineService;

	@Autowired
	private WorkerApplicationsShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(BasicCommand.LIST,CustomCommand.LIST_MINE this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
