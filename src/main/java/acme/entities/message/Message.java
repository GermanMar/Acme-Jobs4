
package acme.entities.message;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import acme.entities.messageThread.MessageThread;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Message extends DomainEntity implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	private Date				creationMoment;

	private String				tags;

	@NotBlank
	@Column(length = 1024)
	private String				body;

	@Valid
	@ManyToOne(optional = true)
	private MessageThread		msgThread;
}
