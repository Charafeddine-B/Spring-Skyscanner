package com.flight.scanner.Management.repository;
import com.flight.scanner.Management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);

}
