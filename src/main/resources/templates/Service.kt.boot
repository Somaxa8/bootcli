package {{packageName}}.{{serviceFolder}}

import {{packageName}}.{{entityFolder}}.{{EntityName}}
import {{packageName}}.{{repositoryFolder}}.{{EntityName}}Repository
import com.ieseuropa.spring.config.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class {{EntityName}}Service {

    @Autowired lateinit var {{entityName}}Repository: {{EntityName}}Repository


    fun init() {
        if ({{entityName}}Repository.count() <= 0) {
            TODO("IMPLEMENT THIS")
        }
    }

    fun create(): {{EntityName}} {
        val {{entityName}} = {{EntityName}}()

        return {{entityName}}Repository.save({{entityName}})
    }

    fun update(): {{EntityName}} {
            val {{entityName}} = {{EntityName}}()

            return {{entityName}}Repository.save({{entityName}})
    }

    fun findById(id: Long): {{EntityName}} {
        if (!{{entityName}}Repository.existsById(id)) {
            throw NotFoundException()
        }
        return {{entityName}}Repository.getOne(id)
    }

    fun delete(id: Long) {
        if (!{{entityName}}Repository.existsById(id)) {
            throw NotFoundException()
        }
        {{entityName}}Repository.deleteById(id)
    }

    fun findAll(): List<{{EntityName}}> {
        return {{entityName}}Repository.findAll()
    }
}