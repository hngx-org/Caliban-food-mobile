import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpRequest
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository
import com.essycynthia.calibanfoodmobile.ui.create_account_screen.CreateAccountState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateAccountViewModel @Inject constructor(private val repository: FreeLunchRepository) : ViewModel() {
    private val _createAccountState = MutableStateFlow(CreateAccountState())
    val createAccountState: MutableStateFlow<CreateAccountState> = _createAccountState

    fun signup(signUpRequest: SignUpRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            _createAccountState.value = CreateAccountState(isLoading = true, error = null)
            try {
                repository.signup(signUpRequest) // Call the signup method from your repository
                _createAccountState.value = CreateAccountState(
                    isLoading = false,
                    success = "Account created successfully"
                )
            } catch (e: Exception) {
                _createAccountState.value = CreateAccountState(
                    isLoading = false,
                    error = "An error occurred while creating an account: ${e.message}"
                )
            }
        }
    }
}
