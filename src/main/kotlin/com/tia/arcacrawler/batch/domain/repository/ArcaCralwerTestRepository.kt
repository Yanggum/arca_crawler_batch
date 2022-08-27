package com.tia.arcacrawler.batch.domain.repository;

import com.tia.arcacrawler.batch.domain.entity.ArcaCralwerTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArcaCralwerTestRepository : JpaRepository<ArcaCralwerTest, Int> {
}