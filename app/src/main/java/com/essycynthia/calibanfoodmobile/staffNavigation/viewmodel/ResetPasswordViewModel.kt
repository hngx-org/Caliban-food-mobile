package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpRequest
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository
import com.essycynthia.calibanfoodmobile.ui.create_account_screen.CreateAccountState
import com.essycynthia.calibanfoodmobile.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ResetPasswordViewModel @Inject constructor(private val repository: FreeLunchRepository) :
    ViewModel() {
    private val _resetPasswordState = MutableStateFlow(ResetPasswordState())
    val resetPasswordState: MutableStateFlow<ResetPasswordState> = _resetPasswordState

    fun resetPasswordRequest(authorization: String, email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _resetPasswordState.value = ResetPasswordState(isLoading = true, error = null)


            val response = repository.resetPassword(authorization,email)
            when (response) {
                is Resource.Success -> {
                    _resetPasswordState.value = ResetPasswordState(success = response.data)
                }

                is Resource.Loading -> {
                    _resetPasswordState.value = ResetPasswordState(isLoading = true)

                }

                is Resource.Error -> {
                    _resetPasswordState.value = ResetPasswordState(
                        error = response.message ?: "An unexpected error occurred"
                    )

                }

            }

        }
    }
}
