package com.essycynthia.calibanfoodmobile.domain.repository

import com.essycynthia.calibanfoodmobile.data.remote.FoodApi
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.BankRequest
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.BankResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.CreateOrganizationInviteResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.GetALunchResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.GetAllLunchesResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginRequest
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SendLunchResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpRequest
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UpdateOrganizationLaunchPriceResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UpdateOrganizationLaunchWalletBalanceResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UserProfileResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UserResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UsersResponse
import com.essycynthia.calibanfoodmobile.data.remote.dto.CreateOrganizationRequest
import com.essycynthia.calibanfoodmobile.data.remote.dto.StaffSignUpRequest
import com.essycynthia.calibanfoodmobile.util.Resource
import javax.inject.Inject

class FreeLunchRepository @Inject constructor(
    private val api : FoodApi
) {
    suspend fun login(loginRequest: LoginRequest): Resource<LoginResponse> {
        return try {
            val response = api.login(loginRequest)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred during login", null)
        }
    }
    suspend fun signup(signUpRequest: SignUpRequest): Resource<SignUpResponse> {
        return try {
            val response = api.signup(signUpRequest)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred during signup", null)
        }

    }
    suspend fun createOrganization(createOrganizationRequest: CreateOrganizationRequest): Resource<SignUpResponse> {
        return try {
            val response = api.createOrganization(createOrganizationRequest)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while creating an organization", null)
        }
    }

    suspend fun staffSignup(staffSignUpRequest: StaffSignUpRequest): Resource<SignUpResponse> {
        return try {
            val response = api.staffSignup(staffSignUpRequest)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred during staff signup", null)
        }
    }

    suspend fun createOrganizationInvite(email: String): Resource<CreateOrganizationInviteResponse> {
        return try {
            val response = api.createOrganizationInvite(email)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while creating an organization invite", null)
        }
    }

    suspend fun updateOrganizationLaunchWalletBalance(amount: String): Resource<UpdateOrganizationLaunchWalletBalanceResponse> {
        return try {
            val response = api.updateOrganizationLaunchWalletBalance(amount)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while updating organization launch wallet balance", null)
        }
    }

    suspend fun updateOrganizationLaunchPrice(launchPrice: String): Resource<UpdateOrganizationLaunchPriceResponse> {
        return try {
            val response = api.updateOrganizationLaunchWalletBalanceResponse(launchPrice)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while updating organization launch price", null)
        }
    }

    suspend fun getUserProfile(): Resource<UserProfileResponse> {
        return try {
            val response = api.getUser()
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while fetching user profile", null)
        }
    }

    suspend fun addBankAccount(bankRequest: BankRequest): Resource<BankResponse> {
        return try {
            val response = api.addBankAccount(bankRequest)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while adding a bank account", null)
        }
    }

    suspend fun getAllUsers(): Resource<UsersResponse> {
        return try {
            val response = api.getAllUsers()
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while fetching all users", null)
        }
    }

    suspend fun searchUser(nameOrEmail: String): Resource<UserResponse> {
        return try {
            val response = api.searchUser(nameOrEmail)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while searching for a user", null)
        }
    }

    suspend fun sendLunchRequest(receivers: List<String>, quantity: Int, note: String): Resource<SendLunchResponse> {
        return try {
            val response = api.sendLunchRequest(receivers, quantity, note)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while sending a lunch request", null)
        }
    }

    suspend fun getLunch(token: String, id: String): Resource<GetALunchResponse> {
        return try {
            val response = api.getLunch("Bearer $token", id)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while fetching a lunch", null)
        }
    }

    suspend fun getAllLunches(token: String): Resource<GetAllLunchesResponse> {
        return try {
            val response = api.getAllLunches("Bearer $token")
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("An error occurred while fetching all lunches", null)
        }
    }
}