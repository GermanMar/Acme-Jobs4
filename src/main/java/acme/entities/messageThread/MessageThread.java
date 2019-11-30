
package acme.entities.messageThread;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import acme.entities.message.Message;
import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MessageThread extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	String						title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	Date						creationMoment;

	@ManyToMany
	Collection<Authenticated>	users;

	@NotNull
	@Valid
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "thread")
	@Fetch(value = FetchMode.SUBSELECT)
	Collection<Message>			message;

}
