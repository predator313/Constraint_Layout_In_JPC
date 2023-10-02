package com.aamirashraf.constraint_layout_in_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.HorizontalChainReference
import com.aamirashraf.constraint_layout_in_jpc.ui.theme.Constraint_Layout_in_JPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraintSet= ConstraintSet {
                val greenBox=createRefFor("greenBox")
                val redBox=createRefFor("redBox")
                constrain(greenBox){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width= Dimension.value(100.dp)
                    height=Dimension.value(100.dp)
                }

                constrain(redBox){
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    width=Dimension.value(100.dp)
                    height=Dimension.value(100.dp)

                }
                createHorizontalChain(greenBox,redBox)
            }
            ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier
                    .background(Color.Green)
                    .layoutId("greenBox")

                ) {

                }
                Box(modifier = Modifier.background(Color.Red)
                    .layoutId("redBox"))
            }
        }
    }
}

//for using the constraint layout in the jetpack compose we need to add the dependency