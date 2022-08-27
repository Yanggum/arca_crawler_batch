package com.tia.arcacrawler.batch.domain.repository;

import com.tia.arcacrawler.batch.domain.entity.ArcaCrawlerTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArcaCrawlerTestRepository : JpaRepository<ArcaCrawlerTest, Int> {
}