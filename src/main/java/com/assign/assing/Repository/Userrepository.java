package com.assign.assing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assign.assing.Entity.UserRegistration;

@Repository
public interface Userrepository extends JpaRepository<UserRegistration, Long>
{

}
