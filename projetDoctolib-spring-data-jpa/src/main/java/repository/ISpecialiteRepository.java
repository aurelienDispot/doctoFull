package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Specialite;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {

}