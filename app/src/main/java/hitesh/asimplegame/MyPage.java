package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyPage extends Activity {
    private TextView name_view,email_view,id_view;

    @Override
    protected  void onCreate(Bundle savedinstancState) {
        super.onCreate(savedinstancState);
//        setContentView(R.layout.mypage);
//
//        name_view =(TextView) findViewById(R.id.textView12);
//        email_view =(TextView) findViewById(R.id.textView11);
//        id_view =(TextView) findViewById(R.id.textView10);

        Intent intent = getIntent() ;
        //로그인 액티비티에서 이름 맞출것.
        String userID = intent.getStringExtra("userID");
        String useremail = intent.getStringExtra("userEmail");
        String username = intent.getStringExtra("userName");

        name_view.setText(userID);
        email_view.setText(useremail);
        name_view.setText(username);
    }

}
