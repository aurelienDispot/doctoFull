package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.MotifConsultation;

public interface IMotifConsultation extends JpaRepository<MotifConsultation, Long> {// jpaRepository deja dans spring importe les methodes

}
