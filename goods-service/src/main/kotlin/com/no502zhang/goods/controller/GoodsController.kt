package com.no502zhang.goods.controller

import com.no502zhang.goods.dto.ListGoodsParam
import com.no502zhang.goods.dto.ListGoodsResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/goods")
class GoodsController {

    @GetMapping("")
    fun list(param: ListGoodsParam): ListGoodsResult {
        return ListGoodsResult(10, 1, 1, 0)
    }
}