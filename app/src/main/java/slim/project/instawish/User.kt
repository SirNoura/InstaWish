package slim.project.instawish

class User {

    var nome    : String?   = null
    var tipo : String?   = null
    var email : String? = null
    var urlImage : String? = null

    constructor(
            nome: String?,
            tipo: String?,
            email: String?,
            urlImage: String?

    ) {
        this.nome      = nome
        this.tipo      = tipo
        this.email     = email
        this.urlImage  = urlImage
    }

    fun toHashMap() : HashMap<String, Any?>{
        val hasMap = HashMap<String, Any?>()
        hasMap["nome"] = nome
        hasMap["tipo"] = tipo
        hasMap["email"] = email
        hasMap["urlImage"] = urlImage

        return hasMap
    }

    companion object{
        fun fromHash(hashMap:  HashMap<String, Any?>) : User{
            val item = User(
                    hashMap["nome"].toString(),
                    hashMap["tipo"].toString(),
                    hashMap["email"].toString(),
                    hashMap["urlImage"].toString()
            )
            return item
        }
    }
}