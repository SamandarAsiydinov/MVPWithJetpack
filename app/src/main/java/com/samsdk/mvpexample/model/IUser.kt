package com.samsdk.mvpexample.model

interface IUser {
    val email: String
    val password: String
    val isValid: Boolean
}