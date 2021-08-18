package spring.boot.doctolib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.doctolib.model.*;

public interface IMotifConsultationRepository extends JpaRepository<MotifConsultation, Long> {// jpaRepository deja dans spring importe les methodes

}
