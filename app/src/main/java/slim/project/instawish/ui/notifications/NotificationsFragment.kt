package slim.project.instawish.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import slim.project.instawish.MainActivity
import slim.project.instawish.R
import slim.project.instawish.User
import java.util.*
import kotlin.collections.HashMap

class NotificationsFragment : Fragment() {
    private lateinit var auth : FirebaseAuth
    var listUser: User? = null
    private var currentUser : User? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val uid  = FirebaseAuth.getInstance().uid
        val db = FirebaseFirestore.getInstance()
        //val reference = FirebaseFirestore.getInstance()
        //.collection("users")
        // .document(uid.toString())
        val year: Int =  Calendar.getInstance().get(Calendar.YEAR)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textNome : TextView = root.findViewById(R.id.txtnome)
        val textIdade : TextView = root.findViewById(R.id.txtemail)
        val logout : Button = root.findViewById(R.id.btnlogout)
        auth = Firebase.auth
        val currentUser = auth.currentUser



        currentUser!!.uid?.let {
            db.collection("users").document(it)
                    .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                        querySnapshot?.data?.let {
                            listUser = User.fromHash(querySnapshot.data as HashMap<String, Any?>)
                            listUser?.let{ User ->
                                textNome.setText(User.nome)
                                textIdade.setText(User.email)
                            }
                        }
                    }
        }
        logout.setOnClickListener {
            Firebase.auth.signOut()
            val intent= Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        return root
    }
}