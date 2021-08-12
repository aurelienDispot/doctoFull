package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Lieux;

public interface ILieuxRepository extends JpaRepository<Lieux, Long> {

}
