package test.suman.tms_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.suman.tms_app.entities.TicketContextEntity;

public interface TicketContextRepository extends JpaRepository<TicketContextEntity, Integer> {

}
