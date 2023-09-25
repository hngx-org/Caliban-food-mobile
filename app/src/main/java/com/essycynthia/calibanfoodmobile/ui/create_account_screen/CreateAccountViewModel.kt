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

class CreateAccountViewModel @Inject constructor(private val repository: FreeLunchRepository) :
    ViewModel() {
    private val _createAccountState = MutableStateFlow(CreateAccountState())
    val createAccountState: MutableStateFlow<CreateAccountState> = _createAccountState

    fun signup(signUpRequest: SignUpRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            _createAccountState.value = CreateAccountState(isLoading = true, error = null)


            val response = repository.signup(signUpRequest)
            when (response) {
                is Resource.Success -> {
                    _createAccountState.value = CreateAccountState(success = response.data)
                }

                is Resource.Loading -> {
                    _createAccountState.value = CreateAccountState(isLoading = true)

                }

                is Resource.Error -> {
                    _createAccountState.value = CreateAccountState(
                        error = response.message ?: "An unexpected error occurred"
                    )

                }

            }

        }
    }
}
