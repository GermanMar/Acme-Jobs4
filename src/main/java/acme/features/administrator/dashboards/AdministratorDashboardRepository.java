
package acme.features.administrator.dashboards;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Announcements a")
	Integer getTotalAnnouncements();

	@Query("select count(i) from InvestorRecord i")
	Integer getTotalInvestorRecords();

	@Query("select count(c) from CompanyRecords c")
	Integer getTotalCompanyRecords();

	@Query("select min(reward.amount) from Request a where now()<=a.deadLine")
	Double getMinimumRequest();

	@Query("select max(reward.amount) from Request a where now()<=a.deadLine")
	Double getMaximumRequest();

	@Query("select avg(reward.amount) from Request a where now()<=a.deadLine")
	Double getAverageRequest();

	@Query("select stddev(reward.amount) from Request a where now()<=a.deadLine")
	Double getDesviationRequest();

	@Query("select min(reward.amount) from Offer a where now()<=a.deadline")
	Double getMinimumOffers();

	@Query("select max(reward.amount) from Offer a where now()<=a.deadline")
	Double getMaximumOffers();

	@Query("select avg(reward.amount) from Offer a where now()<=a.deadline")
	Double getAverageOffers();

	@Query("select stddev(reward.amount) from Offer a where now()<=a.deadline")
	Double getDesviationOffers();

	@Query("select p.sector, count(p) from CompanyRecords p group by p.sector")
	Collection<Object[]> findAllCompanies();

	@Query("select p.sector, count(p) from InvestorRecord p group by p.sector")
	Collection<Object[]> findAllInvestors();

}
