import com.tia.arcacrawler.batch.domain.entity.ArcaCralwerTest
import com.tia.arcacrawler.batch.domain.repository.ArcaCralwerTestRepository
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct
import org.springframework.batch.item.ItemReader

// CustomItemReader.kt


open class CustomItemReader : ItemReader<ArcaCralwerTest> {
    @Autowired
    private lateinit var bookRepository: ArcaCralwerTestRepository
    private lateinit var list: MutableList<ArcaCralwerTest>
    private var nextIndex: Int = 0

    @PostConstruct
    fun postConstruct(){
        list = bookRepository.findAll()  // book  조회, list에 담음
    }

    override fun read(): ArcaCralwerTest? {
        if(nextIndex < list.size){
            return list[nextIndex++]  // list에서 순차적으로 read
        }
        return null
    }
}