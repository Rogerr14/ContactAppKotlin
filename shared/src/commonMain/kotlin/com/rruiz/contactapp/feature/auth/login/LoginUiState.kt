package com.rruiz.contactapp.feature.auth.login

data class LoginUiState(
    val email: String = "",
    val password: String ="",
    val emailError: String? = null,
    val passwordError: String? = null,

)