package com.cts.pension.pensionerDetail.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pension.pensionerDetail.model.PensionerDetails;

@Repository
@Transactional
public interface PensionerDetailsRepository extends JpaRepository<PensionerDetails, String> {

}
