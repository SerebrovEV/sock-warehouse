package com.education.sockwarehouse.repository;

import com.education.sockwarehouse.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SockRepository extends JpaRepository<Sock, Long> {
    Optional<Sock> findByColorAndCottonPart(String color, int cottonPart);
}
