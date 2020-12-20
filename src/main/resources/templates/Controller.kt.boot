package {{packageName}}.{{controllerFolder}}

import {{packageName}}.{{entityFolder}}.{{EntityName}}
import {{packageName}}.{{serviceFolder}}.{{EntityName}}Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class {{EntityName}}Controller {

    @Autowired lateinit var {{entityName}}Service: {{EntityName}}Service


    @PostMapping("/api/{{entityName}}")
    fun post{{EntityName}}(
            //@RequestParam title: String
    ): ResponseEntity<{{EntityName}}> {
        return ResponseEntity.status(HttpStatus.CREATED).body({{entityName}}Service.create())
    }

    @PatchMapping("/api/{{entityName}}/{id}")
    fun path{{EntityName}}(
            //@PathVariable id: Long,
            //@RequestParam(required = false) title: String?,
    ): ResponseEntity<{{EntityName}}> {
        return ResponseEntity.status(HttpStatus.OK).body({{entityName}}Service.update())
    }

    @DeleteMapping("/api/{{entityName}}/{id}")
    fun delete{{EntityName}}(@PathVariable id: Long): ResponseEntity<Void> {
        {{entityName}}Service.delete(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
    }

    @GetMapping("/public/{{entityName}}")
    fun get{{EntityName}}s(): ResponseEntity<List<{{EntityName}}>> {
        return ResponseEntity.status(HttpStatus.OK).body({{entityName}}Service.findAll())
    }

    @GetMapping("/public/{{entityName}}/{id}")
    fun get{{EntityName}}(@PathVariable id: Long): ResponseEntity<{{EntityName}}> {
        return ResponseEntity.status(HttpStatus.OK).body({{entityName}}Service.findById(id))
    }

}