package com.plcoding.core.data.preferences

import android.content.SharedPreferences
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.model.ActivityLevel
import com.plcoding.core.model.Gender
import com.plcoding.core.model.GoalType
import com.plcoding.core.model.UserInfo

class DefaultPreferences (
    private val sharedPreferences: SharedPreferences
        )  : Preferences {
    override fun saveGender(gender: Gender) {
        sharedPreferences
            .edit()
            .putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()    }

    override fun saveWeight(weight: Float) {
        sharedPreferences
            .edit()
            .putFloat(Preferences.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPreferences
            .edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPreferences
            .edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.name)
            .apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPreferences
            .edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, goalType.name)
            .apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPreferences
            .edit()
            .putFloat(Preferences.KEY_CARB_RATIO, ratio)
            .apply()
    }

    override fun saveProteinRation(ratio: Float) {
        sharedPreferences
            .edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO, ratio)
            .apply()
    }

    override fun saveFatRation(ratio: Float) {
        sharedPreferences
            .edit()
            .putFloat(Preferences.KEY_FAT_RATIO, ratio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
       val age  = sharedPreferences.getInt(Preferences.KEY_AGE, -1)
       val height  = sharedPreferences.getInt(Preferences.KEY_HEIGHT, -1)
       val weight  = sharedPreferences.getFloat(Preferences.KEY_WEIGHT, -1f)
       val gender  = sharedPreferences.getString(Preferences.KEY_GENDER, null)
       val activityLeveLString  = sharedPreferences.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
       val goalType  = sharedPreferences.getString(Preferences.KEY_GOAL_TYPE, null)
       val carbRatio  = sharedPreferences.getFloat(Preferences.KEY_CARB_RATIO, -1f)
       val proteinRatio  = sharedPreferences.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
       val fatRatio  = sharedPreferences.getFloat(Preferences.KEY_FAT_RATIO, -1f)

   return UserInfo(
       Gender.fromString(gender ?: "male"),
       age  = age,
       weight = weight,
       height = height,
       activityLevel  = ActivityLevel.fromString(activityLeveLString ?: "medium"),
       goalType = GoalType.fromString(goalType ?: "keep_weight"),
       carbRatio = carbRatio,
       proteinRation = proteinRatio,
       fatRatio = fatRatio
   )
    }
}