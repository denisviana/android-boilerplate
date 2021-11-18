package com.app.presentation.base

interface ViewDiffContainer {
    val updated: HashMap<String, Any?>

    fun <T> part(name: String, newValue: T, updater: (T) -> Unit) {
        if (!updated.containsKey(name) || updated[name] != newValue) {
            updater(newValue)
            updated[name] = newValue
        }
    }
}
