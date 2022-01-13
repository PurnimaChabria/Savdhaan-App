package com.example.transaction24;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import static android.widget.Toast.*;
import static com.example.transaction24.R.string.complain_notreg;

public class HistoryFragment extends Fragment
{   private FirebaseAuth mAuth;
    EditText Complainsubject;
    EditText Complaindesc;
    EditText email;
    Button btnadd;

    DatabaseReference databasecomplains;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            //String userid = getArguments().getString("params");
            View view = inflater.inflate(R.layout.fragment_history, container, false);
            databasecomplains = FirebaseDatabase.getInstance().getReference("Complains");
            btnadd = (Button) view.findViewById(R.id.button);
            Complainsubject = (EditText) view.findViewById(R.id.editTextTextPersonName2);
            Complaindesc = (EditText) view.findViewById(R.id.editTextTextMultiLine);
            email= (EditText) view.findViewById(R.id.editTextTextEmailAddress);

        btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddComplains();
                }
            });
            return view;

        }
        private void AddComplains() {
            String subject = Complainsubject.getText().toString().trim();
            String description = Complaindesc.getText().toString().trim();
            String username = email.getText().toString().trim();
            //FirebaseUser userid = mAuth.getCurrentUser();

            if (!TextUtils.isEmpty(subject)) {

                String id = databasecomplains.push().getKey();
                Complains complains = new Complains(id, subject, description,username);
                databasecomplains.child(id).setValue(complains);


            } else {

            }
        }


    }


