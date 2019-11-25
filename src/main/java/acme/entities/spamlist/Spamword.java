
package acme.entities.spamlist;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "spamword")
})
public class Spamword extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				spamword;

}
