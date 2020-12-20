package {{packageName}}.{{repositoryFolder}}

import {{packageName}}.{{entityFolder}}.{{EntityName}}
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface {{EntityName}}Repository : JpaRepository<{{EntityName}}, Long> {
}