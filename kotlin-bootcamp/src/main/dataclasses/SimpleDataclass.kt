package dataclasses

data class SimpleDataclass(
        val unchangeableString: String  = "originalValue",
        var changeableString: String = "originalValue",
        val nullableString: String? = null
)