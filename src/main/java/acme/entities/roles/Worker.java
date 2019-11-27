
package acme.entities.roles;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.application.Application;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Worker extends UserRole {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	//Atributes

	@NotBlank
	private String				qualifications;

	@NotBlank
	private String				skills;

	//Relationships

	@NotNull
	@Valid
	@OneToMany(mappedBy = "worker")
	Collection<Application>		application;

}
