package com.example.ktornotesapp.auth.data

import com.example.ktornotesapp.auth.domain.model.AuthResultData


internal fun AuthResponseData.toAuthResultData():AuthResultData{
    return AuthResultData(userId,name,bio,imageUrl)
}