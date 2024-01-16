package com.missclick.alies.common

interface EventHandler<E> {
    fun obtainEvent(event : E)
}