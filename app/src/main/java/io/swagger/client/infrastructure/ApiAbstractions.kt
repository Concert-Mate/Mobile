package io.swagger.client.infrastructure

typealias MultiValueMap = Map<String, List<String>>

fun collectionDelimiter(collectionFormat: String) = when (collectionFormat) {
    "csv" -> ","
    "tsv" -> "\t"
    "pipes" -> "|"
    "ssv" -> " "
    else -> ""
}

val defaultMultiValueConverter: (item: Any?) -> String = { item -> "$item" }

fun <T : Any?> toMultiValue(items: List<T>, collectionFormat: String, map: (item: Any?) -> String = defaultMultiValueConverter): List<String> {
    return when (collectionFormat) {
        "multi" -> items.map(map)
        else -> listOf(
            items.joinToString(
                separator = collectionDelimiter(collectionFormat),
                transform = map
            )
        )
    }
}