package com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SentLunchResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpRequest
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository
import com.essycynthia.calibanfoodmobile.ui.create_account_screen.CreateAccountState
import com.essycynthia.calibanfoodmobile.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SentLunchViewModel @Inject constructor(private val repository: FreeLunchRepository) :
    ViewModel() {

    private val _sentLunchState = MutableStateFlow(SentLunchState())
    val sentLunchState: MutableStateFlow<SentLunchState> = _sentLunchState

    fun sendLunch(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _sentLunchState.value = SentLunchState(isLoading = true, error = null)


            val response = repository.getSentLunches(token)
            when (response) {
                is Resource.Success -> {
                    _sentLunchState.value = SentLunchState(success = response.data)
                }

                is Resource.Loading -> {
                    _sentLunchState.value = SentLunchState(isLoading = true)

                }

                is Resource.Error -> {
                    _sentLunchState.value = SentLunchState(
                        error = response.message ?: "An unexpected error occurred"
                    )

                }

            }

        }
    }
}
