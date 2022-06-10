package com.example.android.dagger

import androidx.lifecycle.ViewModel
import com.example.android.dagger.di.TestType
import javax.inject.Inject

class TestViewModel @Inject constructor(testType: TestType): ViewModel() {
    val message = testType.message
}