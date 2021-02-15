package slim.project.instawish

class User {

    var nome    : String?   = null
    var tipo : String?   = null
    var email : String? = null
    var urlImage : String? = null
    var morada : String? = null
    var codpos : String? = null
    var andar : String? = null

    constructor(
            nome: String?,
            tipo: String?,
            email: String?,
            urlImage: String?,
            morada: String?,
            codpos: String?,
            andar: String?

    ) {
        this.nome      = nome
        this.tipo      = tipo
        this.email     = email
        this.urlImage  = urlImage
        this.morada    = morada
        this.codpos    = codpos
        this.andar     = andar
    }

    fun toHashMap() : HashMap<String, Any?>{
        val hasMap = HashMap<String, Any?>()
        hasMap["nome"] = nome
        hasMap["tipo"] = tipo
        hasMap["email"] = email
        hasMap["urlImage"] = urlImage
        hasMap["morada"] = morada
        hasMap["codpos"] = codpos
        hasMap["andar"] = andar

        return hasMap
    }

    companion object{
        fun fromHash(hashMap:  HashMap<String, Any?>) : User{
            val item = User(
                    hashMap["nome"].toString(),
                    hashMap["tipo"].toString(),
                    hashMap["email"].toString(),
                    hashMap["urlImage"].toString(),
                    hashMap["morada"].toString(),
                    hashMap["codpos"].toString(),
                    hashMap["andar"].toString()
            )
            return item
        }
    }
}