package hitesh.asimplegame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class SignUpActivity extends Activity {

    private static final String TAG = "SignUpActivity";

    private FirebaseAuth mAuth;

    private QuestionDBOpenHelper dBOpenHelper = new QuestionDBOpenHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btn_ok).setOnClickListener(onClickListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_ok:
//                Log.e("CLick", "Click");
                    signUp();
                    break;
            }
        }
    };

    private void signUp() {
        final String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.verifyPasswordEditText)).getText().toString();


        if (email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {

            if (passwordCheck.equals(password)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("Sign-up is successful!");

                                    RankingInformation rankingInformation = new RankingInformation(0, email, 0);
                                    dBOpenHelper.addRankingInformation(rankingInformation);

                                    AlertDialog.Builder ad = new AlertDialog.Builder(SignUpActivity.this);
                                    ad.setTitle("Welcome!");
                                    ad.setMessage("Thank you for signing up!");
                                    ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            startActivity(new Intent(getApplicationContext(), MainPageActivity.class));
                                        }
                                    });

                                    ad.show();


                                } else {
                                    if (task.getException() != null) {
                                        startToast(task.getException().toString());
                                    }
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                }
                            }
                        });

            } else {
                Toast.makeText(this, "Check your password again", Toast.LENGTH_SHORT).show();
            }

        } else {
            startToast("Please enter your email or password. ");
        }


    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
