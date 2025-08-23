package com.zeckydev.applist

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableNativeArray
import com.facebook.react.bridge.WritableNativeMap
import android.util.Log
import android.content.pm.PackageManager
import android.content.Intent
import android.content.pm.ResolveInfo
import android.content.pm.ApplicationInfo

class AppListModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
        return "AppList"
    }

    @ReactMethod
    fun getInstalledApps(promise: Promise) {
        val packageManager = reactApplicationContext.packageManager
        val installedApps = WritableNativeArray()
        
        try {
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            val packages: List<ResolveInfo> = packageManager.queryIntentActivities(intent, 0)
            for (resolveInfo in packages) {
                val appInfo = resolveInfo.activityInfo.applicationInfo
                val appName = packageManager.getApplicationLabel(appInfo).toString()
                val packageName = appInfo.packageName                
                installedApps.pushMap(WritableNativeMap().apply {
                    putString("appName", appName)
                    putString("packageName", packageName)
                })
            }
            promise.resolve(installedApps)
        } catch (e: Exception) {
            promise.reject("GET_INSTALLED_USER_APPS_ERROR", "An error occurred while retrieving the user application list.", e)
            Log.e("AppListModule", "Error while retrieving user application list: " + e.message)
        }
    }

    @ReactMethod
    fun isAppInstalled(packageName: String, promise: Promise) {
        val packageManager = reactApplicationContext.packageManager
        try {
            packageManager.getPackageInfo(packageName, 0)
            promise.resolve(true)
        } catch (e: PackageManager.NameNotFoundException) {
            promise.resolve(false)
        } catch (e: Exception) {
            promise.reject("IS_PACKAGE_INSTALLED_ERROR", "An error occurred while checking package status.", e)
            Log.e("AppListModule", "Error while checking package status: " + e.message)
        }
    }
}
