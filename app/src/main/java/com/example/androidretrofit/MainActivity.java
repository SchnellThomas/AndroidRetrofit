package com.example.androidretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidretrofit.Model.Ip;
import com.example.androidretrofit.Remote.IpService;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    IpService mService;
    TextView txtIp;
    Button btnGetIp;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getIpService();

        btnGetIp = (Button)findViewById(R.id.btnGetIP);
        txtIp = (TextView)findViewById(R.id.txtIP);
        dialog = new SpotsDialog(MainActivity.this);

        btnGetIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                getIpAddress();
            }
        });
    }

    private void getIpAddress() {
        mService.getIP().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                dialog.dismiss();
                txtIp.setText(response.body().getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                Log.e("Error",t.getMessage());
                dialog.dismiss();
            }
        });
    }
}
