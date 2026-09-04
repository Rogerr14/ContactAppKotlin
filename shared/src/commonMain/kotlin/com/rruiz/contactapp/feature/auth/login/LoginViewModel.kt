package com.rruiz.contactapp.feature.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(value: String){
        uiState = uiState.copy(
            email =  value,
            emailError = null
        )
    }

    fun onPasswordChange(value: String){
        uiState = uiState.copy(
            password = value,
            passwordError = null
        )
    }

    fun onLoginClick(){
        val emailError =  validateEmail(uiState.email)
        val passwordError = validatePassword(uiState.password)

        uiState = uiState.copy(
            emailError = emailError,
            passwordError = passwordError
        )

        if(emailError != null || passwordError != null){
            return
        }

        login()
    }

    private  fun login(){

    }


    private fun validateEmail(email: String): String? {

        if (email.isBlank()) {
            return "El correo es obligatorio"
        }

        val emailRegex = Regex(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        )

        if (!emailRegex.matches(email)) {
            return "Ingresa un correo válido"
        }

        return null
    }


    private fun validatePassword(password: String): String?{

        if (password.isBlank()) {
            return "La contraseña es obligatoria"
        }

        if (password.length < 8) {
            return "Debe contener mínimo 8 caracteres"
        }

        if (!password.any { it.isUpperCase() }) {
            return "Debe contener una mayúscula"
        }

        if (!password.any { it.isLowerCase() }) {
            return "Debe contener una minúscula"
        }

        if (!password.any { it.isDigit() }) {
            return "Debe contener un número"
        }

        if (!password.any { !it.isLetterOrDigit() }) {
            return "Debe contener un carácter especial"
        }

        return null
    }
}