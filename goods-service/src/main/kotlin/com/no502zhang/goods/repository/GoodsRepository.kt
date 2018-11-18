package com.no502zhang.goods.repository

import com.no502zhang.goods.entity.Goods
import org.springframework.data.jpa.repository.JpaRepository

interface GoodsRepository : JpaRepository<Goods, String>