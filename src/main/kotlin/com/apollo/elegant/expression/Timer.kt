package com.apollo.elegant.expression

import java.util.*

fun main(){
    println(System.currentTimeMillis()/1000 + 300)
    println(Date().time)
//    println(getTimeFormat(864000000 - (1000 * 60L)))
//    println(getTimeFormat(172342942))
//    val url = "https://ec-hwbeta.casstime.com/mall/public/terminal-h5/#/activity-H5/share/routine?from=yaoG6mMraZWJonphFF3h1JfBXHmEfNezNSqrcBcBMks=\n" +
//            "&fromCompanyId=OMhBBQV6yqGzuj2LBQnH8w==" +
//            "&productId=19371071314481561600" +
//            "&userAddressGeoId=44030710" +
//            "&platform=PLATFORM_APP" +
//            "&provinceGeoId=CN-44" +
//            "&cityGeoId=CN-44-3" +
//            "&countyGeoId=CN-44-3-5" +
//            "&jumpUrl=cassapp://route/rn/ProductDetail"
//    val split = url.split("?")
//    val cassUrl = "https://www.casstime.com?${split[1]}"
//    println(cassUrl)
}

private fun getTimeFormat(deadLine: Long): String? {
    if (deadLine == 0L) {
        return null
    }

//    val day = (deadLine / (1000 * 60 * 60 * 24)).toInt()
//    val hour = ((deadLine - 1000 * 60 * 60 * 24 * day) / (1000 * 60 * 60)).toInt()
//    val minResult = deadLine - (1000 * 60 * 60 * 24 * day + 1000 * 60 * 60 * hour)
//    val minR = minResult % (1000 * 60)
//    val min = (minResult / (1000 * 60)).toInt()
//    val stringBuilder = StringBuilder("还剩")
//    if (day > 0) {
//        stringBuilder.append(day).append("天")
//    }
//    stringBuilder.append(hour).append("时").append(if (minR > 0) min + 1 else min).append("分")

    val timeDisplay = deadLine + 59*1000
    val day = (timeDisplay / (1000 * 60 * 60 * 24)).toInt()
    val hour = ((timeDisplay - 1000 * 60 * 60 * 24 * day) / (1000 * 60 * 60)).toInt()
    val minResult = timeDisplay - (1000 * 60 * 60 * 24 * day + 1000 * 60 * 60 * hour)
    val min = (minResult / (1000 * 60)).toInt()
    val stringBuilder = StringBuilder("还剩")
    if (day > 0) {
        stringBuilder.append(day).append("天").append(hour).append("时").append(min).append("分")
    } else {
        if (hour > 0) {
            stringBuilder.append(hour).append("时").append(min).append("分")
        } else {
            stringBuilder.append(min).append("分钟")
        }
    }
    return stringBuilder.toString()
}