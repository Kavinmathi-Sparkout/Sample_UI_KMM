package org.example.MobileApp.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateBounds
import com.skydoves.orbital.rememberMovableContentOf
import org.example.MobileApp.common.values.colors

/*
@Composable
fun DetailTransitionScreen (navController: NavController, itemId: String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.redDress), // Replace with your image resource
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .then(Transition(imageKey = "image_$itemId")) // Set transition key
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Item #$itemId Details",
            modifier = Modifier
                .then(Transition(textKey = "text_$itemId")) // Set transition key
        )
    }
}*/

@Composable
fun OrbitalLazyColumnSample() {
    val mocks = MockUtils.getMockPosters()

    Orbital {
        LazyColumn {
            items(mocks, key = { it.name }) { poster ->
                var expanded by rememberSaveable { mutableStateOf(false) }
                AnimatedVisibility(
                    remember { MutableTransitionState(false) }
                        .apply { targetState = true },
                    enter = fadeIn(),
                ) {
                    Orbital(modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            expanded = !expanded
                        }
                        .background(color = colors.pink, shape = RoundedCornerShape(10.dp))) {
                        val title = rememberMovableContentOf {
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .animateBounds(Modifier),
                            ) {
                                Text(
                                    text = "aaaaa",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                )

                                Text(
                                    text = "jkdnnvdojvokdmcopajw",
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                        val image = rememberMovableContentOf {
                            GlideImage(
                                imageModel = { poster.poster },
                                component = rememberImageComponent {
                                    +CrossfadePlugin()
                                },
                                modifier = Modifier
                                    .padding(10.dp)
                                    .animateBounds(
                                        if (expanded) {
                                            Modifier.fillMaxWidth()
                                        } else {
                                            Modifier.size(80.dp)
                                        },
                                        spring(stiffness = Spring.StiffnessLow),
                                    )
                                    .clip(RoundedCornerShape(5.dp)),
                                imageOptions = ImageOptions(requestSize = IntSize(600, 600)),
                            )
                        }

                        if (expanded) {
                            Column {
                                image()
                                title()
                            }
                        } else {
                            Row {
                                image()
                                title()
                            }
                        }
                    }
                }
            }
        }
    }
}