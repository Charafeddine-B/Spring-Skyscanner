package com.flight.scanner.Managment.repository;
import com.flight.scanner.Managment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);

}
