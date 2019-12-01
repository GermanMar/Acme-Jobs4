
package acme.entities.message;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.messageThread.MessageThread;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	String						title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	Date						creationMoment;

	String						tags;
	@NotBlank
	String						body;

	@ManyToOne(optional = false)
	MessageThread				thread;

}
