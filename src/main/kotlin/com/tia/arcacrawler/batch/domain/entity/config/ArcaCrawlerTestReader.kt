import com.tia.arcacrawler.batch.crawler.ArcaCrawlerTestProcess
import com.tia.arcacrawler.batch.domain.entity.ArcaCrawlerTest
import com.tia.arcacrawler.batch.domain.repository.ArcaCrawlerTestRepository
import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct
import org.springframework.batch.item.ItemReader

// CustomItemReader.kt


open class ArcaCrawlerTestReader : ItemReader<ArcaCrawlerTest> {
    @Autowired
    private lateinit var arcaCrawlerTestRepository: ArcaCrawlerTestRepository
    private lateinit var list: MutableList<ArcaCrawlerTest>
    private var nextIndex: Int = 0



    @PostConstruct
    fun postConstruct(){
        val crawlingInstance = ArcaCrawlerTestProcess()
        list = crawlingInstance.crawl();
        //list = arcaCrawlerTestRepository.findAll()  // book  조회, list에 담음
    }

    override fun read(): ArcaCrawlerTest? {
        if(nextIndex < list.size){
            return list[nextIndex++]  // list에서 순차적으로 read
        }
        return null
    }
}