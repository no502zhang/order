package com.no502zhang.goods.dto

data class ListGoodsResult(val pageSize: Int, val pageNum: Int, val pageTotal: Int, val total: Long, val list: Array<GoodsResult>) {
    data class GoodsResult(val id: String, val name: String, val picUrl: String, val remark: String?)
}