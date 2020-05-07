package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends Activity {

    private static final String TAG = "SignUpActivity";

    private FirebaseAuth mAuth;

    SharedPreferences sharedPreferences = null;
    SharedPreferences.Editor editor = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btn_ok).setOnClickListener(onClickListener);
        findViewById(R.id.btn_toSignUp).setOnClickListener(onClickListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

//        updateUI(currentUser);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_ok:
                    signIn();
                    break;
                case R.id.btn_toSignUp:
                    startSignUpActivity();
                    break;
            }
        }
    };



    private void signIn() {
        final String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();

        if(email.length() >0 && password.length() >0) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail : success");


                            FirebaseUser user = mAuth.getCurrentUser();

//                            Intent intent = new Intent(SignInActivity.this, MainPageActivity.class);
//                            Bundle b = new Bundle();
//                            b.putString("email", email);
//                            intent.putExtras(b);

//                            editor.putString("email", email);
//                            editor.commit();

                            startToast("Sign-ip is successful!");
                            finishSignInActivity();
                        } else {
                            if (task.getException() != null) {
                                startToast("Check your email or password. ");
                            }
                        }
                    }
                });
            } else {
            startToast("Please enter your email or password. ");
        }


    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void finishSignInActivity() {
        startActivity(new Intent(getApplicationContext(), MainPageActivity.class));
    }

    private void startSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
