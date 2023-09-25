package com.essycynthia.calibanfoodmobile.inviteuser
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class InviteUserViewModel @Inject constructor(
    private val freeLunchRepository: FreeLunchRepository ): ViewModel() {
    var recipient by mutableStateOf("owolabigbemisola@gmail.com")
    var message by mutableStateOf("Encourage users to join honorwave and start sending free lunch to their peer.")
    val inviteUserState = MutableStateFlow(InviteUserState())
    fun createOrganisationInvite(email:String){ viewModelScope.launch {
        inviteUserState.value = InviteUserState(isLoading = true)
        try {
        val response = freeLunchRepository.createOrganizationInvite(email)
        inviteUserState.value = InviteUserState(isLoading = false, successMessage = response.message)
    }catch (e: Exception){
        inviteUserState.value = InviteUserState(isLoading = false,
            errorMessage = "An error occurred while creating a user invite") }
    }
    } }
data class InviteUserState(
    var isLoading:Boolean = true, var successMessage:String? = "", var errorMessage: String = ""
)
