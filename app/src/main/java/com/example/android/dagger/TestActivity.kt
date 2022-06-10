package com.example.android.dagger

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.dagger.di.TestModule
import com.example.android.dagger.di.TestType
import javax.inject.Inject

class TestActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        Log.d("JAQ", "Before component init")
        (application as MyApplication).component()
            .createUserComponent(TestModule(TestType("Hey Y'all!")))
            .inject(this)
        Log.d("JAQ", "After component init")

        findViewById<TextView>(R.id.hello).text = viewModel.message
    }
}