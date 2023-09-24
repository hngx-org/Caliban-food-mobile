package com.essycynthia.calibanfoodmobile.ui.reward_screen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.data.remote.dto.UserResponseDto import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository import com.essycynthia.calibanfoodmobile.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SendLunchRewardViewModel @Inject constructor(
    private val freeLunchRepository: FreeLunchRepository ) : ViewModel() {
    private var usersList: List<UserResponseDto> = mutableListOf()
    val usersSearchList = mutableStateListOf<UserResponseDto>()
    var recipientText by mutableStateOf("")
    var complimentText by mutableStateOf("")

    init {
        getListUsers()
        getUsersSearchList()
    }

    fun getEnabledValue(): Boolean {
        return recipientText.isNotBlank() && complimentText.isNotBlank()
    }

    private fun getListUsers() {
        viewModelScope.launch {
            when (val resource = freeLunchRepository.getAllUsers()) {
                is Resource.Success -> usersList = resource.data!!.data
                else -> {
                }
            }
        }
    }

    //this function updates the search suggestions absed on the value of text in the recipient
    private fun getUsersSearchList() {
        for (user in usersList) {
            if (user.name.contains(recipientText, true)) {
                usersSearchList.add(user)
            }
        }
    }

    fun resetState() {
        complimentText = ""
        recipientText = ""
    }
}
