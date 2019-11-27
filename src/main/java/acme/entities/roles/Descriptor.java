
package acme.entities.roles;

import java.util.Collection;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.duty.Duty;
import acme.framework.entities.DomainEntity;

@Entity
public class Descriptor extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	//Atributes----------------------------------------------
	@NotNull
	@NotBlank
	private String				descripton;

	private Collection<Duty>	duty;

}
