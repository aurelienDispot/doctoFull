package spring.boot.doctolib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.doctolib.model.*;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {

}