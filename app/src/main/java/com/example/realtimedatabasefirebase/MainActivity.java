package com.example.realtimedatabasefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView name , family;
    Button loginButton;
    String txtname,txtfamily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        family=findViewById(R.id.family);
        loginButton=findViewById(R.id.lig_in);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtname=name.getText().toString();
                txtfamily=family.getText().toString();

                if(!txtname.isEmpty() && !txtfamily.isEmpty()) {
                    Users users =new Users(txtname,txtfamily);
                    firebaseDatabase=FirebaseDatabase.getInstance();
                    databaseReference=firebaseDatabase.getReference("Users");
                    databaseReference.child(txtname).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            name.setText("");
                            family.setText("");
                            Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}