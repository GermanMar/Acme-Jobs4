package acme.entities.spamlist;

import java.beans.Transient;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spamlist extends DomainEntity {

	private static final long		serialVersionUID	= 1L;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Spamword.class)
	@NotFound(action = NotFoundAction.IGNORE)
	private Collection<Spamword>	spamwordslist;


	@Transient
	public Double getThreshold() {
		Double result = 0.;

		while (result <= this.spamwordslist.size()) {
			result++;
		}

		return result / 100;
	}

}
