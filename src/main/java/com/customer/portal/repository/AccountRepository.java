package com.customer.portal.repository;

import com.customer.portal.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {

	@Query(value = "Select n from Accounts n where username = :username or email = :email")
	Optional<Accounts> findByUsernameOrEmail(String username, String email);
}
