
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sponsor extends UserRole {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	//Atributes-------------------------------

	@NotNull
	@NotBlank
	private String				organisation;

	@CreditCardNumber
	private String				cardCredit;

}
