package com.example.mvvmapp.data

data class Welcome7 (
    val meta: Meta,
    val data: List<Datum>
) {
    companion object {
    }
}

data class Datum (
    val id: Long,
    val name: String,
    val email: String,
    val gender: String,
    val status: String
)

enum class Gender(val value: String) {
    Female("female"),
    Male("male");

    companion object {
        public fun fromValue(value: String): Gender = when (value) {
            "female" -> Female
            "male"   -> Male
            else     -> throw IllegalArgumentException()
        }
    }
}

enum class Status(val value: String) {
    Active("active"),
    Inactive("inactive");

    companion object {
        public fun fromValue(value: String): Status = when (value) {
            "active"   -> Active
            "inactive" -> Inactive
            else       -> throw IllegalArgumentException()
        }
    }
}

data class Meta (
    val pagination: Pagination
)

data class Pagination (
    val total: Long,
    val pages: Long,
    val page: Long,
    val limit: Long,
    val links: Links
)

data class Links (
    val previous: Any? = null,
    val current: String,
    val next: String)
