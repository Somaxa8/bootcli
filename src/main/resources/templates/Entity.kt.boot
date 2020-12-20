package {{packageName}}.{{entityFolder}}

import javax.persistence.*

@Entity
class {{EntityName}}(
        @Id @GeneratedValue
        var id: Long? = null
)