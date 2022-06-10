package com.example.android.dagger.di

import com.example.android.dagger.TestActivity
import com.example.android.dagger.user.LoggedUserScope
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.migration.DisableInstallInCheck

@LoggedUserScope
@Subcomponent(modules = [TestModule::class])
interface TestComponent {
    fun inject(activity: TestActivity)
}

@Module
@DisableInstallInCheck
class TestModule(var testType: TestType) {
    @Provides
    fun providesTestType() = testType
}

data class TestType(val message: String)