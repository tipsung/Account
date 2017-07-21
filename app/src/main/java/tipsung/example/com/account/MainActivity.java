package tipsung.example.com.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mRootRef;
    private DatabaseReference mAccountsRef;
    private Button addButton;
    private ListView listAccount;
    private ArrayList<Account> accountsList;
    private AccountAdapter accountAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ปุ่ม
        addButton = (Button) findViewById(R.id.AddAccount);
        listAccount = (ListView) findViewById(R.id.ListAccount);
        accountsList = new ArrayList<Account>();


        mRootRef = FirebaseDatabase.getInstance().getReference();
        mAccountsRef = mRootRef.child("accounts");

        accountAdapter = new AccountAdapter(getApplicationContext(), R.layout.list_account, accountsList);

       listAccount.setAdapter(accountAdapter);

        //ทำงานเมื่อคลิกปุ่มเพิ่มรายชื่อ
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        mAccountsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dss: dataSnapshot.getChildren()){
                    Account account = dss.getValue(Account.class);
                    accountsList.add(account);
                }
                accountAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    }

