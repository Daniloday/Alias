package com.missclick.alies.ui.screens.chooseVocabulary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.VocabularyCard
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.chooseVocabulary.models.ChooseVocabularyEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChooseVocabularyScreen(
    navController: NavController,
    vm: ChooseVocabularyViewModel = koinViewModel()
) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = context.getString(R.string.choose_vocabulary),
                style = AppTheme.typography.headerTextBold,
                modifier = Modifier.padding(top = 8.dp),
                color = AppTheme.colors.primary
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp), color = AppTheme.colors.primary
            )

            LazyColumn(modifier = Modifier
                .fillMaxHeight()
                .padding(top = 24.dp), verticalArrangement = Arrangement.spacedBy(24.dp),
                content = {
                    itemsIndexed(viewState.vocabularyList) { _, item ->
                        VocabularyCard(item) {
                            vm.obtainEvent(ChooseVocabularyEvent.ClickVocabulary(item))
                        }

                    }
                })
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            NextButton {
                vm.obtainEvent(ChooseVocabularyEvent.Next)
                navController.navigate(NavigationTree.PREPARE_FOR_GAME.name)
            }
        }

    }


}