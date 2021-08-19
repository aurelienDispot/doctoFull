package spring.boot.doctolib.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.boot.doctolib.model.PraticienSpecialite;

public interface IPraticienSpecialiteRepository extends JpaRepository<PraticienSpecialite, Long> {
	@Query("select spe from PraticienSpecialite spe where spe.id = :id")
	Optional <PraticienSpecialite> findPraticienSpecialiteId(@Param("id") Long id);
}
