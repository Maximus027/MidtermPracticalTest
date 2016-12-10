package nyc.c4q.maxrosado.midtermpracticaltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import nyc.c4q.maxrosado.midtermpracticaltest.POJOs.HeadPOJO;
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
        Call<HeadPOJO> callApi = service.pojoGetter();
        callApi.enqueue(new Callback<HeadPOJO>() {
            @Override
            public void onResponse(Call<HeadPOJO> call, Response<HeadPOJO> response) {
                HeadPOJO headPOJO = response.body();
                List<MainPOJO> pojos = headPOJO.getData().getRecords();
                textView1.setText(pojos.get(0).getUsername());
            }

            @Override
            public void onFailure(Call<HeadPOJO> call, Throwable t) {
                Log.e(TAG, "failed " + t);
            }

        });
    }
}
