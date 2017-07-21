package tipsung.example.com.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {
    private DatabaseReference mRootRef;
    private DatabaseReference mAccountsRef;
    private Button Submit;
    private EditText Name, Tel, Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRootRef = FirebaseDatabase.getInstance().getReference();
        mAccountsRef = mRootRef.child("accounts");

        Submit = (Button) findViewById(R.id.Submit);
        Name = (EditText) findViewById(R.id.Name);
        Tel = (EditText) findViewById(R.id.Tel);
        Email = (EditText) findViewById(R.id.Email);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountName = Name.getText().toString();
                String accountTel = Tel.getText().toString();
                String accountEmail = Email.getText().toString();
                Account account = new Account(accountName, accountTel, accountEmail);

                mAccountsRef.push().setValue(account);
                finish();
            }
        });
    }
}
