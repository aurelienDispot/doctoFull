package spring.boot.doctolib.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.doctolib.model.*;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {
	@Query("select spe from Specialite spe where spe.id = :id")
	Optional<Specialite> findSpecialiteId(@Param("id") Long id);

}