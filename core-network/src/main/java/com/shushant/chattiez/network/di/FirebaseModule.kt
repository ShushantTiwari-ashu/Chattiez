package com.shushant.chattiez.network.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import com.google.firebase.storage.ktx.storage
import com.shushant.chattiez.network.client.AccountService
import com.shushant.chattiez.network.client.AccountServiceImpl
import org.koin.dsl.module

val firebaseModule = module {
    single<AccountService> { AccountServiceImpl(get()) }
    single { Firebase.auth }
    single { Firebase.database }
    single { Firebase.storage }
    single { Firebase.firestore }
    single { Firebase.messaging }
}