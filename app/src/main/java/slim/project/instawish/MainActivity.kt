package slim.project.instawish

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide();
        val email = findViewById<TextView>(R.id.textemail)
        val password = findViewById<TextView>(R.id.textpass)
        val login = findViewById<Button>(R.id.btnlogin)
        val btninfo = findViewById<ImageButton>(R.id.btninfo)

        //Efetuo do Login
        login.setOnClickListener { auth = getInstance()

            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val intent = Intent(this, Home::class.java)
                        intent.putExtra("email", email.text.toString())
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithEmail:failure", task.exception)
                        Toast.makeText(this@MainActivity, "Email ou palavra-passe incorreta", Toast.LENGTH_SHORT).show()

                    }
                }
            //token de verificação da sessão
        }
        btninfo.setOnClickListener{
            val popup = LayoutInflater.from(this).inflate(R.layout.popupinformativo,null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(popup)
            val mAlertDialog = mBuilder.show()
        }
    }
}