package org.ktlib.cache

import org.ktlib.*

/**
 * Interface for accessing a cache
 */
interface Cache {
    companion object : Cache by lookupInstance()

    val connected: Boolean
    fun delete(key: String)
    fun set(key: String, value: Any, ttlSecond: Long? = null)
    fun add(key: String, value: Any, ttlSecond: Long? = null)
    fun update(key: String, value: Any, ttlSecond: Long? = null)
    fun get(key: String): String?

    fun <T> getAs(key: String, type: TypeRef<T>) = get(key)?.fromJson(type)
}

inline fun <reified T> Cache.getAs(key: String): T? = getAs(key, typeRef())