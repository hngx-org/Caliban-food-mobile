package com.essycynthia.calibanfoodmobile.data.remote

import com.essycynthia.calibanfoodmobile.data.remote.data_classes.BankRequest
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.BankResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.GetALunchResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.GetAllLunchesResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginRequest
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.LoginResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.RedeemLunchRequest
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.RedeemLunchResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SendLunchResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpRequest
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.SignUpResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.StaffSignUpResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UpdateOrganizationLaunchPriceResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UpdateOrganizationLaunchWalletBalanceResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UserProfileResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UserResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.UsersResponse
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.WithdrawalRequest
import com.essycynthia.calibanfoodmobile.data.remote.data_classes.WithdrawalResponse
import com.essycynthia.calibanfoodmobile.data.remote.dto.CreateOrganizationRequest
import com.essycynthia.calibanfoodmobile.data.remote.dto.CreateOrganizationResponse
import com.essycynthia.calibanfoodmobile.data.remote.dto.SignUpResponseDto
import com.essycynthia.calibanfoodmobile.data.remote.dto.StaffSignUpRequest
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface FoodApi {
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("api/auth/user/signup")
    suspend fun signup(@Body request: SignUpRequest): SignUpResponseDto

    @Headers("Authorization: Bearer <access_token>") // Replace <access_token> with the actual access token
    @PUT("api/organization/create")
    suspend fun createOrganization(
        headers: Map<String, String>,
        @Body request: CreateOrganizationRequest
    ): CreateOrganizationResponse

    @POST("api/organization/staff/signup")
    suspend fun staffSignup(@Body request: StaffSignUpRequest): StaffSignUpResponse

    @Headers("Authorization: Bearer <access_token>")
    @POST("/api/organization/invite") //
    suspend fun createOrganizationInvite(@Field("email") email: String): CreateOrganizationInviteResponse

    @Headers("Authorization: Bearer <access_token>")
    @PATCH("api/organization/wallet/update") //
    suspend fun updateOrganizationLaunchWalletBalance(@Field("amount") amount: String): UpdateOrganizationLaunchWalletBalanceResponse

    @Headers("Authorization: Bearer <access_token>")
    @PATCH("api/organization/launch/update") //
    suspend fun updateOrganizationLaunchWalletBalanceResponse(@Field("launch_price") launch_price: String): UpdateOrganizationLaunchPriceResponse

    @Headers("Authorization: Bearer <access_token>")
    @GET("/api/user/profile")
    suspend fun getUser(): UserProfileResponse

    @Headers("Authorization: Bearer <access_token>")
    @PATCH("api/user/bank")
    suspend fun addBankAccount(@Body request: BankRequest): BankResponse

    @Headers("Authorization: Bearer <access_token>")
    @GET("api/user/all")
    suspend fun getAllUsers(): UsersResponse

    @Headers("Authorization: Bearer <access_token>") // Replace with the actual access token
    @GET("api/user?search={email}") // Replace with the actual API endpoint
    suspend fun searchUser(
        @Path("email") email: String
    ): UserResponse

    @Headers("Authorization: Bearer <your-auth-token-here>") // Replace with the actual access token
    @POST("api/lunch/send") // Replace with the actual API endpoint
    suspend fun sendLunchRequest(
        @Field("receivers") receivers: List<String>,
        @Field("quantity") quantity: Int,
        @Field("note") note: String
    ): SendLunchResponse

    @GET("api/lunch/{id}")
    suspend fun getLunch(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): GetALunchResponse

    @GET("api/lunch/all")
    suspend fun getAllLunches(
        @Header("Authorization") token: String
    ): GetAllLunchesResponse

    @POST("api/user/redeem")
    suspend fun redeemLunch(
        @Header("Authorization") token: String,
        @Body request: RedeemLunchRequest
    ): RedeemLunchResponse

    @POST("api/withdrawal/request")
    suspend fun createWithdrawalRequest(
        @Header("Authorization") token: String,
        @Body request: WithdrawalRequest
    ): WithdrawalResponse


}
