package com.apollo.elegant.bean

import java.io.Serializable

data class CMLabelCode(
    var labelCode: String? = null,
    //是否有效的溯源码
    var isValidCode: Boolean = true,
) : Serializable {
    override fun toString(): String {
        return "CMLabelCode(labelCode=$labelCode, isValidCode=$isValidCode)"
    }
}