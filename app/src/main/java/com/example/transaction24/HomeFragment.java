package com.example.transaction24;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    private Button btn;
    Spinner spinner;
    String item;
    Uri uri;
    TextView tv;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn = view.findViewById(R.id.button2);
        spinner = view.findViewById(R.id.spin1);
        addListener();
        return view;
    }
    public void addListener(){
        //btn = viewfindViewById(R.id.button2);
        //spinner=findViewById(R.id.spin1);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.location, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                item = (String) parent.getItemAtPosition(position);
                System.out.println(item);




                // do something upon option selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinner.getSelectedItem().equals("Mumbai")){
                    System.out.println(item);
                    uri = Uri.parse("https://t.me/joinchat/psrx3FeyBcw2NDNl");

                }

                else if(spinner.getSelectedItem().equals("Nashik")){
                    System.out.println(item);
                    uri = Uri.parse("https://t.me/joinchat/Cs-UU9UrUccxOTY9");


                }
                else {
                    System.out.println(item);
                    uri = Uri.parse("https://t.me/joinchat/nqrQYnp20vNmYWU9");

                }


                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);






            }
        });

    }


}



