package com.example.android.dagger

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.android.dagger.di.TestModule
import com.example.android.dagger.di.TestType
import javax.inject.Inject

class TestActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        (application as MyApplication).component()
            .createUserComponent(TestModule(TestType("Hey Y'all!")))
            .inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[TestViewModel::class.java]
        findViewById<TextView>(R.id.hello).text = viewModel.message
    }
}