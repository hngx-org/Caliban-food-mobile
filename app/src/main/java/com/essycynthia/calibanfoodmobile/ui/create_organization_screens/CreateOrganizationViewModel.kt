package com.essycynthia.calibanfoodmobile.ui.create_organization_screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpResponse
import com.essycynthia.calibanfoodmobile.data.remote.dto.CreateOrganizationRequest
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository
import com.essycynthia.calibanfoodmobile.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
//sealed class OrganizationCreateState {
//    object Loading : OrganizationCreateState()
//    data class Success(val response: Resource<SignUpResponse>) : OrganizationCreateState()
//    data class Error(val message: String) : OrganizationCreateState()
//}
@HiltViewModel
class CreateOrganizationViewModel @Inject constructor(private val repository: FreeLunchRepository) : ViewModel() {
    private val _organizationCreateState = MutableStateFlow(CreateOrganizationState())
    val organizationCreateState: MutableStateFlow<CreateOrganizationState> = _organizationCreateState

    fun createOrganization(accessToken: String, request: CreateOrganizationRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            _organizationCreateState.value = CreateOrganizationState(isLoading = true, error = null)
            try {
                val response = repository.createOrganization(accessToken, request)
                _organizationCreateState.value = CreateOrganizationState(
                    isLoading = false,
                    success = "An organization created successfully"
                )
            } catch (e: Exception) {
                _organizationCreateState.value = CreateOrganizationState(
                    isLoading = false,
                    error = "An error occurred while creating an organization"
                )
            }
        }
    }
}