package com.tranvanhung.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranvanhung.EmployeeManagement.model.ERole;
import com.tranvanhung.EmployeeManagement.model.Role;



import java.util.Optional;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}