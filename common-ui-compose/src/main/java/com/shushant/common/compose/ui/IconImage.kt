package com.shushant.common.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder

@Composable
fun IconImage(url: String) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                if (url.endsWith(".svg")) decoderFactory { result, options, _ ->
                    SvgDecoder(
                        result.source,
                        options
                    )
                }
            }
        ),
        contentDescription = "",
    )
}