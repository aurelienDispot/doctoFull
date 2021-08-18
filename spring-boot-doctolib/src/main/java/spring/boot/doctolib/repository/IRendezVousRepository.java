package spring.boot.doctolib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring.boot.doctolib.model.*;

public interface IRendezVousRepository extends JpaRepository<RendezVous,Long> {

	@Query("select rdv from RendezVous rdv join rdv.patient p where p.id = :id")
	List<RendezVous> findAllRendezVousByIdPAtient();
}
