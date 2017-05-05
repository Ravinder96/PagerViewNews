package codekamp.in.pagerviewnews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hp1 on 12-07-2016.
 */
public interface NewsService {

    @GET("stories")
    Call<NewsResponse> fetchStories();

/*    @GET("lists/members")
    Call<ContactResponse> fetchContact(@Query("apikey") String apiKey, @Query("id") String listId);*/
}

