package com.payara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payara.entity.BaggageClass;

@Repository
public interface BaggageClassRepository extends JpaRepository<BaggageClass, Long> {

}
