
package acme.entities.messageThread;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.message.Message;
import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MessageThread extends DomainEntity {

	private static final long		serialVersionUID	= 1L;

	//Atributes

	@NotBlank
	private String					title;

	private Date					creationMoment;

	//Realtionships

	@NotNull
	@Valid
	@ManyToMany
	private Collection<UserAccount>	users;

	@Valid
	@OneToMany(mappedBy = "messageThread")
	private Collection<Message>		messages;
}
