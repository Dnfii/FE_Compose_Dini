package com.dini.book.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dini.book.R
import com.dini.book.model.Menu
import com.dini.book.model.dummyCategory
import com.dini.book.model.dummyMenu
import com.dini.book.ui.components.Banner
import com.dini.book.ui.components.CategoryItem
import com.dini.book.ui.components.HomeSection
import com.dini.book.ui.components.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigateToDetail: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hi, Dini!") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            Banner()
            HomeSection(title = stringResource(R.string.section_category), content = {
                CategoryRow(navigateToDetail = navigateToDetail)
            })
            HomeSection(title = stringResource(R.string.section_favorite_menu), content = {
                MenuRow(dummyMenu, navigateToDetail = navigateToDetail)
            })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier, navigateToDetail: (Int) -> Unit) {
    LazyRow(modifier = modifier.padding(16.dp)) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(
                category,
                modifier = Modifier.clickable { navigateToDetail(category.imageCategory) })
        }
    }
}

@Composable
fun MenuRow(listMenu: List<Menu>, modifier: Modifier = Modifier, navigateToDetail: (Int) -> Unit) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu, modifier = Modifier.clickable { navigateToDetail(menu.image) })
        }
    }
}
