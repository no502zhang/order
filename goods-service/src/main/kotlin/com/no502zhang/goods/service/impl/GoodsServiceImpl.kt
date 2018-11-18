package com.no502zhang.goods.service.impl

import com.no502zhang.goods.dto.ListGoodsParam
import com.no502zhang.goods.entity.Goods
import com.no502zhang.goods.repository.GoodsRepository
import com.no502zhang.goods.service.GoodsService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class GoodsServiceImpl(private val goodsRepository: GoodsRepository) : GoodsService {

    override fun createGoods(name: String, picUrl: String, remark: String?): Goods {
        var goods = Goods(name, picUrl, remark)
        goodsRepository.save(goods)
        return goods
    }

    override fun listGoods(param: ListGoodsParam): Page<Goods> {
        return goodsRepository.findAll(PageRequest.of(param.pageNumber - 1, param.pageSize))
    }
}