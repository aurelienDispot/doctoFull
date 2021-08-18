package spring.boot.doctolib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.doctolib.model.*;

public interface ILieuxRepository extends JpaRepository<Lieux, Long> {

}
