package com.no502zhang.goods.service

import com.no502zhang.goods.dto.ListGoodsParam
import com.no502zhang.goods.entity.Goods
import org.springframework.data.domain.Page

interface GoodsService {
    fun createGoods(name: String, picUrl: String, remark: String?): Goods

    fun listGoods(param: ListGoodsParam): Page<Goods>
}