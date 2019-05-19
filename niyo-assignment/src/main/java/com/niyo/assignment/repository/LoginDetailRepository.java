package com.niyo.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niyo.assignment.model.LoginDbDetails;

@Repository
public interface LoginDetailRepository extends JpaRepository<LoginDbDetails, String> {

}
