package com.essycynthia.calibanfoodmobile.ui.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginRequest
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository
import com.essycynthia.calibanfoodmobile.ui.create_account_screen.CreateAccountState
import com.essycynthia.calibanfoodmobile.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: FreeLunchRepository) : ViewModel() {
    private val _loginState= MutableStateFlow(LoginState())
    val loginState: MutableStateFlow<LoginState> = _loginState
    fun login(loginRequest: LoginRequest){
        viewModelScope.launch (Dispatchers.IO){
            val response = repository.login(loginRequest)
            when(response){
                is Resource.Success -> {
                    _loginState.value = LoginState(success = response.data)
                }
                is Resource.Loading -> {
                    _loginState.value = LoginState(isLoading = true)

                }
                is Resource.Error -> {
                    _loginState.value = LoginState(error = response.message ?: "An unexpected error occurred")

                }
            }
        }
    }
}