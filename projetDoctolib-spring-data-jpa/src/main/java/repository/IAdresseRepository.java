package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Adresse;

public interface IAdresseRepository extends JpaRepository<Adresse, Long> {

}
