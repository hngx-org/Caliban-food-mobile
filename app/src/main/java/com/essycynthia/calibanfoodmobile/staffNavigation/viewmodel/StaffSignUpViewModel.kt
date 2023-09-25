package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpRequest
import com.essycynthia.calibanfoodmobile.data.remote.dto.StaffSignUpRequest
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository
import com.essycynthia.calibanfoodmobile.ui.create_account_screen.CreateAccountState
import com.essycynthia.calibanfoodmobile.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StaffSignUpViewModel @Inject constructor(private val repository: FreeLunchRepository) : ViewModel(){
    private val _staffSignUpStateState = MutableStateFlow(StaffSignUpState())
    val staffSignUpStateState: MutableStateFlow<StaffSignUpState> = _staffSignUpStateState

    fun signup(staffSignUpRequest: StaffSignUpRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            _staffSignUpStateState.value = StaffSignUpState(isLoading = true, error = null)


            val response = repository.staffSignup(staffSignUpRequest)
            when (response) {
                is Resource.Success -> {
                    _staffSignUpStateState.value = StaffSignUpState(success = response.data)
                }

                is Resource.Loading -> {
                    _staffSignUpStateState.value = StaffSignUpState(isLoading = true)

                }

                is Resource.Error -> {
                    _staffSignUpStateState.value = StaffSignUpState(
                        error = response.message ?: "An unexpected error occurred"
                    )

                }

            }

        }
    }
}