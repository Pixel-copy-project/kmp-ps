package org.example.project.utill

import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.good_4
import kmpproject.composeapp.generated.resources.goods_1
import kmpproject.composeapp.generated.resources.goods_2
import kmpproject.composeapp.generated.resources.goods_3
import kmpproject.composeapp.generated.resources.sold_out
import org.jetbrains.compose.resources.DrawableResource

object DrawableMapper {
    private val drawableMap = mapOf(
        "sold_out" to Res.drawable.sold_out,
        "goods_1" to Res.drawable.goods_1,
        "goods_2" to Res.drawable.goods_2,
        "goods_3" to Res.drawable.goods_3,
        "goods_4" to Res.drawable.good_4,
        // ... 모든 이미지 추가
    )

    fun getDrawable(name: String): DrawableResource {
        return drawableMap[name] ?: Res.drawable.sold_out
    }
}