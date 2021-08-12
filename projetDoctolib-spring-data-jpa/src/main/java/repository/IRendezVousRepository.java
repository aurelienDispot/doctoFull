package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.RendezVous;

public interface IRendezVousRepository extends JpaRepository<RendezVous,Long> {

}
