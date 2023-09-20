package project.myapplication.viewModel

data class ConcertItem(
    val title : String,
    val description : String,
    val image : Int,
    var isFavorite: Boolean = false
)