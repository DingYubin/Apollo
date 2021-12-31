package com.casstime.ec.scan.bean

import java.io.Serializable

/**
 * @description:
 *
 *
 * @author: 孙莹莹(A01266)
 *
 *
 * @email: yingying.sun@casstime.com
 *
 *
 * @date: 2021/1/21 1:53 PM
 */
data class CMLabelCode(
    var labelCode: String? = null,
    //是否有效的溯源码
    var isValidCode: Boolean = true,
) : Serializable {
    override fun toString(): String {
        return "CMLabelCode(labelCode=$labelCode, isValidCode=$isValidCode)"
    }
}