package ar.com.dinamicaonline.idicse.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.dinamicaonline.idicse.models.ReceiveAndSend;


@Repository
public interface ReceiveAndSendRepository extends JpaRepository<ReceiveAndSend, Integer> {

}