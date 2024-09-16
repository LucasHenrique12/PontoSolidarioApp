package com.example.login_auth_api.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login_auth_api.domain.DonationType;
import com.example.login_auth_api.domain.User;

@Repository
public interface DonationTypeRepository  extends JpaRepository <DonationType,String> {
   
}
