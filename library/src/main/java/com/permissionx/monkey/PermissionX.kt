package com.permissionx.monkey

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallback
    ) {
        val manager = activity.supportFragmentManager
        val tagFragment = manager.findFragmentByTag(TAG)
        val fragment = if (tagFragment != null) {
            tagFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            manager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.request(callback, *permissions)
    }

}