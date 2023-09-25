package com.essycynthia.calibanfoodmobile

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.essycynthia.calibanfoodmobile.staffNavigation.MainActivityAdmin
import com.essycynthia.calibanfoodmobile.staffNavigation.OrgFreeLunchBalanceActivity
import com.essycynthia.calibanfoodmobile.staffNavigation.UserInviteActivity
import com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel.HomeViewModel
import com.essycynthia.calibanfoodmobile.staffNavigation.viewmodel.Reward
import com.essycynthia.calibanfoodmobile.ui.theme.CalibanFoodMobileTheme
import com.essycynthia.calibanfoodmobile.ui.theme.Grey
import com.essycynthia.calibanfoodmobile.ui.theme.Neutral1
import com.essycynthia.calibanfoodmobile.ui.theme.Primary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAdmin(
    context: MainActivityAdmin,
    navController: NavController,
    onNavigateToReward: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = HomeViewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Welcome, ${viewModel.homeState.name} \uD83D\uDC4B",
                        style = CalibanFoodMobileTheme.typography.bodyMedium,
                        color = Grey
                    )
                },
                actions = {

                    Icon(
                            imageVector = Icons.Filled.PersonAdd,
                            contentDescription = "Search",
                            tint = Grey,
                            modifier = modifier.clickable {
                                Intent(
                                    context,
                                    UserInviteActivity::class.java
                                ).also {
                                    context.startActivity(it)
                                }
                            }
                        )

                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search",
                        tint = Grey,
                        modifier = modifier.clickable{}
                    )

                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Setting",
                        tint = Grey,
                        modifier = modifier.clickable {
                            Intent(
                                context,
                                OrgFreeLunchBalanceActivity::class.java
                            ).also {
                                context.startActivity(it)
                            }
                        }
                    )

                }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            FreeLunchSection(freeLunch = viewModel.homeState.freeLunch)
            Spacer(modifier = Modifier.height(16.dp))
            RewardHistorySection(
                rewardList = viewModel.homeState.rewardList,
                onSeeAllClicked = {
                    navController.navigate(RewardDestination.route)
                    onNavigateToReward()
                }
            )
        }
    }
}

@Composable
private fun FreeLunchSection(
    freeLunch: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Primary)
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 14.dp,
                    start = 16.dp,
                    end = 16.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Free Lunch",
                style = CalibanFoodMobileTheme.typography.h3Bold,
                color = Neutral1,
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color.Cyan)
            )
        }

        Text(
            text = freeLunch.toString(),
            style = CalibanFoodMobileTheme.typography.h1Bold,
            color = Neutral1,
            modifier = Modifier.padding(top = 10.dp)
        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Neutral1
            ),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 20.dp,
                    bottom = 14.dp,
                )
        ) {
            Text(text = "Withdraw Lunch", color = Primary, style = CalibanFoodMobileTheme.typography.button)
        }
    }
}

@Composable
private fun RewardHistorySection(
    rewardList: List<Reward>,
    onSeeAllClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
    ) {
        Row{
            Text(
                text = "Reward History",
                style = CalibanFoodMobileTheme.typography.bodyMedium,
                color = Grey,
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Text(
                text = "See all",
                style = CalibanFoodMobileTheme.typography.bodyMedium,
                color = Primary,
                modifier = Modifier.clickable {
                    onSeeAllClicked()
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        rewardList.forEach { reward ->
            Column(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Neutral1)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp,
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color.Cyan)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = buildAnnotatedString {
                            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                            append(reward.name)
                            pop()
                            append(" sent you a free lunch")
                        },
                        modifier = Modifier.weight(1.0f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = reward.foodCount.toString(),
                        style = CalibanFoodMobileTheme.typography.h3Bold,
                        color = Primary
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        imageVector = Icons.Outlined.CheckCircle,
                        contentDescription = "food"
                    )
                }

                Text(
                    text = reward.time,
                    style = CalibanFoodMobileTheme.typography.caption,
                    modifier = Modifier.align(Alignment.End),
                    color = Grey,
                )
            }
        }
    }
}

