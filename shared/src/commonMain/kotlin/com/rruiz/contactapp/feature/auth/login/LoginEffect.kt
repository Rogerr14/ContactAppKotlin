package com.rruiz.contactapp.feature.auth.login

sealed interface LoginEffect {
    data object NavigateToHome: LoginEffect
}