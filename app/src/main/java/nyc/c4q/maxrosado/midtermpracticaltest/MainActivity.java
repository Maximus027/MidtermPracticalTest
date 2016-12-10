package nyc.c4q.maxrosado.midtermpracticaltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import nyc.c4q.maxrosado.midtermpracticaltest.POJOs.Data;
import nyc.c4q.maxrosado.midtermpracticaltest.POJOs.MainPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    private static final String TAG = "Username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.tv_username);


        ApiService service = RetrofitBuilder.makeService();
        Call<Data> callApi = service.pojoGetter();
        callApi.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                try {
                    if(response.isSuccessful()) {
                        Data data = response.body();
                        List<MainPOJO> records = data.getRecords();
                        if (records == null) {
                            Log.d(TAG, "Unsuccessful");
                        } else {
                            Log.d(TAG, "Success: " + records);
                            textView1.setText(records.get(2).getUsername());
                        }
                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch(IOException e) {
                    Log.e(TAG, e.getMessage());
                }

//                Data data = response.body();
//                List<MainPOJO> records = data.getRecords();
//                textView1.setText(records.get(1).getUsername());
//                Log.d(TAG, "Username Called");
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }

        });
    }
}
