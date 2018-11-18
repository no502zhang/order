package com.no502zhang.goods.controller

import com.alibaba.fastjson.JSON
import com.no502zhang.goods.dto.CreateGoodsParam
import com.no502zhang.goods.dto.CreateGoodsResult
import com.no502zhang.goods.dto.ListGoodsParam
import com.no502zhang.goods.dto.ListGoodsResult
import com.no502zhang.goods.service.GoodsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/goods")
class GoodsController(private val goodsService: GoodsService) {
    @PostMapping("")
    fun create(@RequestBody param: CreateGoodsParam): CreateGoodsResult {
        val goods = goodsService.createGoods(param.name, param.picUrl, param.remark)
        return CreateGoodsResult(goods.id, goods.name, goods.picUrl, goods.remark)
    }

    @GetMapping("")
    fun list(param: ListGoodsParam): ListGoodsResult {
        val pageGoods = goodsService.listGoods(param)
        return if (pageGoods.hasContent()) {
            ListGoodsResult(pageGoods.size, pageGoods.number + 1, pageGoods.totalPages, pageGoods.totalElements, Array(pageGoods.numberOfElements) { i ->
                ListGoodsResult.GoodsResult(pageGoods.elementAt(i).id, pageGoods.elementAt(i).name, pageGoods.elementAt(i).picUrl, pageGoods.elementAt(i).remark)
            })
        } else {
            ListGoodsResult(pageGoods.size, pageGoods.number, pageGoods.totalPages, pageGoods.totalElements, emptyArray())
        }
    }
}