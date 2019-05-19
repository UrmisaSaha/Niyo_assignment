package com.niyo.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niyo.assignment.model.SignUpDbDetails;

@Repository
public interface SignUpDetailRepository extends JpaRepository<SignUpDbDetails, String> {

}
