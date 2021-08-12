package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Admin;
import model.Patient;
import model.Personne;
import model.Praticien;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {
	@Query("select p from Patient p")
	List<Patient> findAllPatient();
	
	@Query("select a from Admin a")
	List<Admin> findAllAdmin();
	
	@Query("select pr from Praticien pr")
	List<Praticien> findAllPraticien();
	
	@Query("select pr from Praticien pr join PraticienSpecialite prspe where prspe.specialite = :nom")
	List<Praticien> findAllPraticienBySpecialite(@Param("nom") String nom);
	
	@Query("select pr from Praticien pr where pr.nom = :nom")
	List<Praticien> findAllPraticienByNom(@Param("nom") String nom);
	
	@Query("select pr from Praticien pr join CreneauxHoraires cr where cr.lieux.nom = :nom")
	List<Praticien> findAllPraticienByLieux(@Param("nom") String nom);
}
