package com.dini.book.ui.screen.book

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dini.book.R
import com.dini.book.model.Menu
import com.dini.book.model.dummyCategory
import com.dini.book.model.dummyMenu
import com.dini.book.ui.components.CategoryItem
import com.dini.book.ui.components.HomeSection
import com.dini.book.ui.components.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreen(navigateToDetail: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Explore Books") }
            )
        }
    ) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            CategoryRow(navigateToDetail)
            HomeSection(title = stringResource(R.string.section_favorite_menu), content = {
                MenuRow(dummyMenu, navigateToDetail = navigateToDetail)
            })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun CategoryRow(navigateToDetail: (Int) -> Unit) {
    LazyRow(modifier = Modifier.padding(16.dp)) {
        items(dummyCategory, key = { it.textCategory }) {
            CategoryItem(
                it,
                modifier = Modifier.clickable { navigateToDetail(it.imageCategory) })
        }
    }
}

@Composable
fun MenuRow(listMenu: List<Menu>, modifier: Modifier = Modifier, navigateToDetail: (Int) -> Unit) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu, modifier = Modifier.clickable { navigateToDetail(menu.image) })
        }
    }
}

