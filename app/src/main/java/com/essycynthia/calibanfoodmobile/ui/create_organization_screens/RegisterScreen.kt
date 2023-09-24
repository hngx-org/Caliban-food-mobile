package com.essycynthia.calibanfoodmobile.ui.create_organization_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.essycynthia.calibanfoodmobile.data.remote.dto.CreateOrganizationRequest

@Composable
fun RegisterScreen(){
    var companyName by remember { mutableStateOf("") }
    var lunchPrice by remember { mutableStateOf("") }
    var currency by remember { mutableStateOf("") }
val viewModel : CreateOrganizationViewModel = hiltViewModel()
    // Create a state to track the current UI state
    val uiState by viewModel.organizationCreateState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display organization creation form
        TextField(
            value = companyName,
            onValueChange = { companyName = it },
            label = { Text("Company Name") }
        )

        TextField(
            value = lunchPrice,
            onValueChange = { lunchPrice = it },
            label = { Text("Lunch Price") }
        )

        TextField(
            value = currency,
            onValueChange = { currency = it },
            label = { Text("Currency") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display loading indicator if in loading state
        if (uiState.isLoading) {
            CircularProgressIndicator()
        }

        // Display success message if in success state
        if (uiState.success != null) {
            Text(text = uiState.success.toString(), color = Color.Green)
        }

        // Display error message if in error state
        if (uiState.error != null) {
            Text(text = uiState.error.toString(), color = Color.Red)
        }

        // Create button
        Button(
            onClick = {
                viewModel.createOrganization(
                    accessToken = "your_access_token", // Replace with actual access token
                    CreateOrganizationRequest(companyName, lunchPrice)
                )
            }
        ) {
            Text(text = "Create")
        }
    }
}