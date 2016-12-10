package nyc.c4q.maxrosado.midtermpracticaltest;

import nyc.c4q.maxrosado.midtermpracticaltest.POJOs.HeadPOJO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by maxrosado on 12/10/16.
 */

public interface ApiService {
    @GET("api/timelines/users/918753190470619136")
    Call<HeadPOJO> pojoGetter();
}
