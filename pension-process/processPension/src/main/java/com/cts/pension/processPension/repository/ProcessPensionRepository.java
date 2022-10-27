package com.cts.pension.processPension.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pension.processPension.model.PensionDetail;

@Repository
public interface ProcessPensionRepository extends JpaRepository<PensionDetail,Integer> {

}
