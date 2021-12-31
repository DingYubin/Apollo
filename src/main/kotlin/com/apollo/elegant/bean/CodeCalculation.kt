package com.apollo.elegant.bean

import java.io.Serializable


data class CMCodeCalculation (
    val orderId: String?,// 订单id
    val itemId: String?,// 物品ID
    val itemIdType: String?,// 物品ID类型
    val waybillId: String?,// 运单号
    val storeId: String?,// 店铺ID
    var codes: List<ITraceCodeItem>,
    val singleTotal: Int
): Serializable {
    override fun toString(): String {
        return "CMCodeCalculation(orderId=$orderId, itemId=$itemId, itemIdType=$itemIdType, waybillId=$waybillId, storeId=$storeId, singleTotal=$singleTotal, codes=$codes)"
    }
}

class ITraceCodeItem (
    val batchCode: String = "",// 批量码
    val singleCodes: List<String>
) : Serializable {
    override fun toString(): String {
        return "ITraceCodeItem(batchCode='$batchCode', singleCodes=$singleCodes)"
    }
}