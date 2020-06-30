package km.project.firebaselogin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_detail.*

class LoginDetailActivity : Activity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_detail)
        auth = FirebaseAuth.getInstance()

        btn_logout.setOnClickListener { signOut() }
        btn_exit.setOnClickListener { signExit() }
    }

    @SuppressLint("ShowToast")
    private fun signOut() {
        auth.signOut()
        MainActivity.startMainActivity(this)
        Toast.makeText(this, getString(R.string.logout), Toast.LENGTH_SHORT)
    }

    @SuppressLint("ShowToast")
    private fun signExit() {
        auth.currentUser?.delete()
        Toast.makeText(this, getString(R.string.exit), Toast.LENGTH_SHORT)
    }

    companion object {
        fun startLoginDetailActivity(activity: Activity) {
            activity.startActivity(Intent(activity, LoginDetailActivity::class.java))
        }
    }
}