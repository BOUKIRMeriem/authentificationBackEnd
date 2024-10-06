package com.example.authentification.Repository;

import com.example.authentification.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {

}
