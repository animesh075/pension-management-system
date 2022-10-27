package com.cts.pension.pensionPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pension.pensionPortal.model.Pensioner;

@Repository
public interface PensionPortalRepository extends JpaRepository<Pensioner, String> {

}
