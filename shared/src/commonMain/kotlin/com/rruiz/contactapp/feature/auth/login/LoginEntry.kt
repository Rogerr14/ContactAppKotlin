package com.rruiz.contactapp.feature.auth.login

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun LoginEntry(
    viewModel: LoginViewModel = viewModel()
){
    LoginScreen(
        uiState = viewModel.uiState,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onLoginClick = viewModel::onLoginClick,

    )
}
