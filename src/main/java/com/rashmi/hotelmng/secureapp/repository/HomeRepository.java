package com.rashmi.hotelmng.secureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rashmi.hotelmng.secureapp.models.User;




public interface HomeRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
