package com.example.android.dagger

import com.example.android.dagger.di.TestType
import javax.inject.Inject

class TestViewModel @Inject constructor(testType: TestType) {
    val message = testType.message
}