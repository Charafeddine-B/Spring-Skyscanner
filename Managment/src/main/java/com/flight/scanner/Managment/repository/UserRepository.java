package com.flight.scanner.Managment.repository;
import com.flight.scanner.Managment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);

}
