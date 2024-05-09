package org.d3if3168.assessment2.navigation

sealed class Screen(val route: String) {

    data object Home: Screen("mainScreen")

    data object DetailContact: Screen("detailContact/{id}") {
        fun withId(id: Long): String {
            val routeWithId = route.replace("{id}", id.toString())
            println("DetailContact: Id included in route: $routeWithId")
            return routeWithId
        }
    }

    data object AddContact: Screen("addContact")
}