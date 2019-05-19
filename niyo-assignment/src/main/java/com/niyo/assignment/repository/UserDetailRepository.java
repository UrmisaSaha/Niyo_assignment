package com.niyo.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niyo.assignment.model.UserDbDetails;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDbDetails, String> {

}
