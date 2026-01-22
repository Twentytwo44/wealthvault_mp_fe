package org.example.project.data.local

import com.liftric.kvault.KVault

class TokenStore(private val kvault: KVault) {

    companion object {
        private const val KEY_TOKEN = "access_token"
    }


    fun saveToken(token: String) {
        kvault.set(KEY_TOKEN, token)
    }


    fun getToken(): String? {
        return kvault.string(KEY_TOKEN)
    }


    fun clear() {
        kvault.deleteObject(KEY_TOKEN)
    }
}