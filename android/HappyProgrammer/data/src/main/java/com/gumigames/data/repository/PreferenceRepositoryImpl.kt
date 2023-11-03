package com.gumigames.data.repository

import com.gumigames.data.datasource.sharedpreference.PreferenceDataSource
import com.gumigames.domain.repository.PreferenceRepository

class PreferenceRepositoryImpl(
    private val preferenceDataSource: PreferenceDataSource
): PreferenceRepository{
    override fun getAccessToken(): String? {
        return preferenceDataSource.getAccessToken()
    }

    override fun setAccessToken(newToken: String) {
        preferenceDataSource.setAccessToken(newToken)
    }

    override fun getRefreshToken(): String? {
        TODO("Not yet implemented")
    }

    override fun setRefreshToken(newToken: String) {
        TODO("Not yet implemented")
    }

    override fun resetToken() {
        TODO("Not yet implemented")
    }

    override fun setPermissionRejected(key: String, value: Boolean) {
        preferenceDataSource.setPermissionRejected(key, value)
    }

    override fun getPermissionRejected(key: String): Boolean {
        return preferenceDataSource.getPermissionRejected(key)
    }

    override fun setIsShowedPermissionDialog(key: String, value: Boolean) {
        preferenceDataSource.setIsShowedPermissionDialog(key, value)
    }

    override fun getIsShowedPermissionDialog(key: String): Boolean {
        return preferenceDataSource.getIsShowedPermissionDialog(key)
    }

    override fun getIsAlreadyShowedDialog(): Boolean {
        return preferenceDataSource.getIsAlreadyShowedDialog()
    }

    override fun setIsAlreadyShowedDialog(value: Boolean) {
        preferenceDataSource.setIsAlreadyShowedDialog(value)
    }
}