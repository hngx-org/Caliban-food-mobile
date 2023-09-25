package com.essycynthia.calibanfoodmobile.ui.reward_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.data.remote.dto.GetALunchDto
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository
import com.essycynthia.calibanfoodmobile.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReceivedRewardHistoryViewModel @Inject constructor(
    private val freeLunchRepository: FreeLunchRepository
): ViewModel() {
    var receivedRewardUiState by mutableStateOf(ReceivedRewardUiState())
        private set

    init {
        getAllLunches()
    }
    val groupedLunches = receivedRewardUiState.lunchList?.groupBy { it.created_at }
    val receivedRewards = groupedLunches?.map { RewardHistory(createdAt = it.key, lunchList = it.value) }
    private fun getAllLunches(){
        viewModelScope.launch {
            when (val response = freeLunchRepository.getAllLunches("Bearer")){
                is Resource.Success -> receivedRewardUiState = ReceivedRewardUiState(lunchList = response.data?.data)
                is Resource.Error -> receivedRewardUiState = ReceivedRewardUiState(message = response.message)
                is Resource.Loading -> {}
            }
        }
    }
}
data class ReceivedRewardUiState(
    val message: String? = "",
    val lunchList: List<GetALunchDto>? = listOf()
)

data class RewardHistory(
    val createdAt : String,
    val lunchList: List<GetALunchDto>
)