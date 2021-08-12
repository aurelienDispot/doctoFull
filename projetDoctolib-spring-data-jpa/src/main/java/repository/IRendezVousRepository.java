package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.RendezVous;

public interface IRendezVousRepository extends JpaRepository<RendezVous,Long> {

	@Query("select rdv from RendezVous rdv join Patient p where p.patient = :id")
	List<RendezVous> findAllRendezVousByIdPAtient();
}
