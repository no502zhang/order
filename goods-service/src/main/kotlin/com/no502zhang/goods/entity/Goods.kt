package com.no502zhang.goods.entity

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "goods_info")
@SQLDelete(sql = "update goods_info set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
class Goods(id: String, name: String, picUrl: String, remark: String? = null) {
    constructor(name: String, picUrl: String, remark: String? = null) : this(UUID.randomUUID().toString().replace("-", ""), name, picUrl, remark)

    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 32)
    val id: String = id
    @Column(name = "name", nullable = false, length = 255)
    var name: String = name
    @Column(name = "pic_url", nullable = false)
    var picUrl: String = picUrl
    @Column(name = "remark", nullable = true)
    var remark: String? = remark

    @Column(name = "is_deleted", nullable = false)
    private var deleted: Boolean = false
}