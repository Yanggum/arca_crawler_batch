package com.tia.arcacrawler.batch.domain.entity

import javax.persistence.*
import java.io.Serializable;

@Entity
@Table(name = "arca_crawler_test")
open class ArcaCrawlerTest : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    open var id: Int? = null

    @Lob
    @Column(name = "item_content", nullable = false)
    open var itemContent: String? = null
}