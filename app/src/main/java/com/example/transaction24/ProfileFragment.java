package com.example.transaction24;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    private RequestQueue mRequestQue;
    private String URL = "https://fcm.googleapis.com/fcm/send";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        if (getActivity().getIntent().hasExtra("category")){
            Intent intent = new Intent(getActivity(),ReceiveNotificationActivity.class);
            intent.putExtra("category",getActivity().getIntent().getStringExtra("category"));
            intent.putExtra("brandId",getActivity().getIntent().getStringExtra("brandId"));
            startActivity(intent);
        }
        Button button = view.findViewById(R.id.btn);
        mRequestQue = Volley.newRequestQueue(getContext());
        FirebaseMessaging.getInstance().subscribeToTopic("news");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtFrom = view.findViewById(R.id.edtTitle);
                String NOTIFICATION_FROM= edtFrom.getText().toString();

                EditText edtMsg = view.findViewById(R.id.edtMsg);
                String NOTIFICATION_MSG= edtMsg.getText().toString();


                JSONObject json = new JSONObject();
                try {
                    json.put("to","/topics/"+"news");
                    JSONObject notificationObj = new JSONObject();
                    notificationObj.put("title",NOTIFICATION_FROM);
                    notificationObj.put("body",NOTIFICATION_MSG);

                    JSONObject extraData = new JSONObject();
                    extraData.put("brandId",NOTIFICATION_MSG);
                    extraData.put("category",NOTIFICATION_FROM);



                    json.put("notification",notificationObj);
                    json.put("data",extraData);


                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL,
                            json,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {

                                    Log.d("MUR", "onResponse: ");
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("MUR", "onError: "+error.networkResponse);
                        }
                    }
                    ){
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String,String> header = new HashMap<>();
                            header.put("content-type","application/json");
                            header.put("authorization","key=AAAAKy0Gz8k:APA91bGxHZhlZGMwpnmT5VuhsQZRH9iL6OaQCo1EfodIhqHrwNhPOQjXkw4oHiYFo12G-ItzmhR7Hsp-ZtLh7znAgUc1dYdDI2HbfcJzfDHsjhwaU8owuCv_-21P4UghfhiY1arCESIa");
                            return header;
                        }
                    };
                    mRequestQue.add(request);
                }
                catch (JSONException e)

                {
                    e.printStackTrace();
                }
            }




        });
            return view;
    }
}



