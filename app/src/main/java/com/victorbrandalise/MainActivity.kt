package com.victorbrandalise

import androidx.activity.ComponentActivity
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    companion object {
        init {
            Utils.init()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidView(factory = { context ->
                        val renderer = ModelRenderer()

                        SurfaceView(context).apply {
                            renderer.onSurfaceAvailable(this, lifecycle)
                        }
                    })
                }
            }
        }
    }
}