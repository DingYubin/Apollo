package com.apollo.elegant.experiment

class CECSupplierViewHolder {
    var isAllResolvedQuotedFlag: Boolean = false
    var resolvedTotalCount: Int = 8
    var resolvedQuotedCount: Int = 7
    var quotaDesc: String = "(可整单采购，最低价¥${141})"
    val partsBrandQualityIds: HashSet<String?> = HashSet()


//    fun showQuotation(){
//        if(isAllResolvedQuotedFlag) print("整单报出") else print("${resolvedQuotedCount}/${resolvedTotalCount}")
//        var price = ""
//        if (quotaDesc.contains("¥")){
//            price = quotaDesc
//        }
//    }
    fun addSet(){
       partsBrandQualityIds.add("SECOND_HAND")
       partsBrandQualityIds.add("OTHER_BRAND")
//       partsBrandQualityIds.add("ORIGINAL_BRAND")
//       partsBrandQualityIds.add("ORIGINAL_INLAND_4S")
//       partsBrandQualityIds.add("ORIGINAL_CURRENCY")
       partsBrandQualityIds.add("ORIGINAL_OTHERS")
       partsBrandQualityIds.add("BRAND")
       partsBrandQualityIds.add("EXTERNAL_BRAND")
       partsBrandQualityIds.add("INTERNAL_BRAND")
    }

    fun exchange(){
        val str = StringBuilder()
        val result = StringBuilder()
        partsBrandQualityIds.forEach{
            when (it) {
                "ORIGINAL_BRAND","ORIGINAL_INLAND_4S","ORIGINAL_CURRENCY" -> str.append("@ORIGINAL_BRAND")
                "BRAND","EXTERNAL_BRAND","INTERNAL_BRAND" -> str.append("@BRAND")
                "ORIGINAL_OTHERS" -> str.append("@ORIGINAL_OTHERS")
                "SECOND_HAND" -> str.append("@SECOND_HAND")
                "OTHER_BRAND" -> str.append("@OTHER_BRAND")
            }
        }
        result.append (
            if (str.contains("ORIGINAL_BRAND")) "原厂"
            else ""
        )

        result.append (
            if (result.isBlank() && str.contains("BRAND")) "品牌"
            else "/品牌"
        )

        result.append (
            if (result.isBlank() && str.contains("ORIGINAL_OTHERS")) "原厂再制造"
            else "/原厂再制造"
        )

        result.append (
            if (result.isBlank() && str.contains("SECOND_HAND")) "拆车件"
            else "/拆车件"
        )

        result.append (
            if (result.isBlank() && str.contains("OTHER_BRAND")) "其他"
            else "/其他"
        )

        print(result)
    }

    fun show(){
        partsBrandQualityIds.forEach{println(it)}
    }
}

fun main() {
    val supplier = CECSupplierViewHolder()
    supplier.addSet()
    supplier.show()
    supplier.exchange()
}