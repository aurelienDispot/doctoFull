package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.MotifConsultation;

public interface IMotifConsultationRepository extends JpaRepository<MotifConsultation, Long> {// jpaRepository deja dans spring importe les methodes

}
