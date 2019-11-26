
package acme.entities.application;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import acme.entities.job.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	@Column(unique = true)
	@Pattern(regexp = "[A-Z]{4}-[A-Z]{4}:[A-Z]{4}") //Min:5 Max:15 EEEE-JJJJ:WWWW
	@Range(min = 5, max = 15)
	private String				ref;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationMoment;

	@NotNull
	@Pattern(regexp = "ACCEPTED|REJECTED|PENDING") //pending, accepted, rejected
	private String				status;

	@NotNull
	private String				statement;

	private String				skill;

	private String				qualification;

	//Relationships
	@OneToMany
	@Valid
	private Job					job;
}
