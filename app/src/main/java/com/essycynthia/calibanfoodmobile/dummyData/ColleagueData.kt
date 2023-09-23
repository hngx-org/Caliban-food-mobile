package com.essycynthia.calibanfoodmobile.dummyData

data class ColleagueData (
    val id: String,
    val name: String,
    val numberOfMeals: Int,
)

data class RewardHistory(
    val day : String,
    val colleagueDataList: List<ColleagueData>
)
// should be gotten from rest api this is test data, converts a list of a class to a of categories and lists eg day and list of coleagues
val colleagues = listOf(
    ColleagueData("Today", "Franklin sent you a reward", 3),
    ColleagueData("Yesterday", "Judith sent you a reward", 3),
    ColleagueData("Today", "Franklin sent you a reward", 3),
    ColleagueData("Older", "Franklin sent you a reward", 2),
    ColleagueData("Older", "Franklin sent you a reward", 3),
    ColleagueData("Today", "Favour sent you a reward", 3),
    ColleagueData("Older", "Franklin sent you a reward", 1),
    ColleagueData("Today", "Franklin sent you a reward", 3),
    ColleagueData("Yesterday", "Tobith sent you a reward", 3),
    ColleagueData("Yesterday", "Franklin sent you a reward", 3)
).groupBy {
    it.id
}

val colleaguesList = colleagues.map {
    RewardHistory(day = it.key, colleagueDataList = it.value)
}

val colleague = ColleagueData("Today", "Franklin sent you a reward", 3)
