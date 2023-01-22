package com.shushant.chattiez.data.utils

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatchers {
  val main: CoroutineDispatcher
  val mainImmediate: CoroutineDispatcher
  val io: CoroutineDispatcher
}