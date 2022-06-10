package com.example.android.dagger.di

import androidx.lifecycle.ViewModel
import com.example.android.dagger.TestActivity
import com.example.android.dagger.TestViewModel
import com.example.android.dagger.user.LoggedUserScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap

@LoggedUserScope
@Subcomponent(modules = [TestModule::class, TestViewModelModule::class])
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

@Module
@DisableInstallInCheck
abstract class TestViewModelModule {
    @Binds
    @IntoMap
    @LoggedUserScope
    @ViewModelKey(TestViewModel::class)
    internal abstract fun bindNetworkLogsDetailViewModel(viewModel: TestViewModel): ViewModel
}
