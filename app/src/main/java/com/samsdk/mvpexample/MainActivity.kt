package com.samsdk.mvpexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.samsdk.mvpexample.model.User
import com.samsdk.mvpexample.presenter.ILoginPresenter
import com.samsdk.mvpexample.presenter.LoginPresenter
import com.samsdk.mvpexample.ui.theme.MVPExampleTheme
import com.samsdk.mvpexample.view.ILoginView
import com.samsdk.mvpexample.view.LoginScreen

class MainActivity : ComponentActivity(), ILoginView {

    private lateinit var iLoginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVPExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    iLoginPresenter = LoginPresenter(this)
                    LoginScreen() {
                        iLoginPresenter.onLogin(it.email, it.password)
                    }
                }
            }
        }
    }

    override fun onLoginResult(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
