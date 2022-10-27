package com.cts.pension.pensionDisbursement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pension.pensionDisbursement.model.Pensioner;

@Repository
public interface PensionDisbursementRepository extends JpaRepository<Pensioner, String> {

}
