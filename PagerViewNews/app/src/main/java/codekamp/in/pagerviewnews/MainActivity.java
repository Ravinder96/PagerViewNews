package codekamp.in.pagerviewnews;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements Callback<NewsResponse>{

    private ViewPager viewpager;
    FragmentPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news.vaetas.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService newsService = retrofit.create(NewsService.class);
        Call<NewsResponse> call = newsService.fetchStories();
        call.enqueue(this);


    }

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        viewpager = (ViewPager)findViewById(R.id.View_Pager);
       // adapterViewPager = (getSupportFragmentManager(), List<Datum> response);
        viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),response.body().getData()));







    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
       if (t==null){
           Toast.makeText(getApplicationContext(), "Make sure you have active internet connection!", Toast.LENGTH_SHORT).show();
       }


    }
}
