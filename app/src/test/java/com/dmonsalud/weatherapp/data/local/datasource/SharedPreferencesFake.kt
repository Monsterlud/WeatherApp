package com.dmonsalud.weatherapp.data.local.datasource

import android.content.SharedPreferences

class SharedPreferencesFake: SharedPreferences {

    /**
     * Maps the mock out the SharedPreferences file
     */

    // Map representing committed Preferences
    var weatherPreferenceMap = HashMap<String, Any>()

    // Map representing Preferences which have not been committed but have been inserted by the editor
    var uncommittedPreferenceMap = HashMap<String, Any>()

    /**
     * Mocked Editor & Listeners
     */

    // Mocked SharedPreferences.Editor
    private val weatherPreferencesEditor: MockSharedPreferenceEditor =
        MockSharedPreferenceEditor(weatherPreferenceMap, uncommittedPreferenceMap)

    // Mocked listeners edited by registerOnSharedPreferenceChangeListener & unregisterOnSharedPreferenceChangeListener
    private var listeners: MutableSet<SharedPreferences.OnSharedPreferenceChangeListener> = HashSet()

    /**
     * Override all methods
     */
    override fun getAll(): Map<String, *> = weatherPreferenceMap

    override fun getString(key: String?, defValue: String?): String? =
        weatherPreferenceMap.getOrDefault(key, defValue) as String?

    override fun getStringSet(key: String?, defValues: MutableSet<String>?): MutableSet<String>? =
        weatherPreferenceMap.getOrDefault(key, defValues) as MutableSet<String>

    override fun getInt(key: String, defaultValue: Int): Int =
        weatherPreferenceMap.getOrDefault(key, defaultValue) as Int

    override fun getLong(key: String, defaultValue: Long): Long =
        weatherPreferenceMap.getOrDefault(key, defaultValue) as Long

    override fun getFloat(key: String, defaultValue: Float): Float =
        weatherPreferenceMap.getOrDefault(key, defaultValue) as Float

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        weatherPreferenceMap.getOrDefault(key, defaultValue) as Boolean

    override fun contains(key: String): Boolean =
        key in weatherPreferenceMap

    override fun edit(): SharedPreferences.Editor = weatherPreferencesEditor

    /**
     * Mocked OnSharedPreferenceChange Listeners
     */

    // Mocked registerOnSharedPreferenceChangeListener
    override fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        listeners.add(listener)
    }

    // Mocked unregisterOnSharedPreferenceChangeListener
    override fun unregisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        listeners.remove(listener)
    }

    /**
     * Mocked SharedPreferences Editor
     */

    // Mocked SharedPreferences Editor
    class MockSharedPreferenceEditor(
        private val preferenceMap: MutableMap<String, Any>,
        private val uncommittedPreferenceMap: MutableMap<String, Any>,
        private var uncommittedRemoveKeys: MutableList<String> = ArrayList()
    ) : SharedPreferences.Editor {

        override fun putString(key: String?, value: String?): SharedPreferences.Editor {
            key?.let {
                value?.let {
                    uncommittedPreferenceMap[key] = value
                }
            }
            return this
        }

        override fun putStringSet(
            key: String?,
            values: MutableSet<String>?
        ): SharedPreferences.Editor {
            key?.let {
                uncommittedPreferenceMap[key] = values as MutableSet<String>
            }
            return this
        }

        override fun putInt(key: String, value: Int): SharedPreferences.Editor {
            uncommittedPreferenceMap[key] = value
            return this
        }

        override fun putLong(key: String, value: Long): SharedPreferences.Editor {
            uncommittedPreferenceMap[key] = value
            return this
        }

        override fun putFloat(key: String, value: Float): SharedPreferences.Editor {
            uncommittedPreferenceMap[key] = value
            return this
        }

        override fun putBoolean(key: String, value: Boolean): SharedPreferences.Editor {
            uncommittedPreferenceMap[key] = value
            return this
        }

        override fun remove(key: String): SharedPreferences.Editor {
            uncommittedPreferenceMap.remove(key)
            uncommittedRemoveKeys.add(key)
            return this
        }

        override fun clear(): SharedPreferences.Editor {
            uncommittedRemoveKeys.clear()
            preferenceMap.clear()
            uncommittedPreferenceMap.clear()
            return this
        }

        override fun commit(): Boolean {
            uncommittedRemoveKeys.forEach {
                preferenceMap.remove(it)
            }

            uncommittedPreferenceMap.forEach {
                preferenceMap[it.key] = it.value
            }

            uncommittedRemoveKeys.clear()
            uncommittedPreferenceMap.clear()
            return true
        }

        override fun apply() {
            commit()
        }
    }
}