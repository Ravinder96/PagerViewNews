package codekamp.in.pagerviewnews;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private Datum datum;
    private WebView webView;
    private TextView mMoreInfoTextView;




    public NewsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(Datum datum) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putSerializable("rmn",datum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            datum = (Datum)getArguments().getSerializable("rmn");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_news, container, false);
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        TextView titleText = (TextView) view.findViewById(R.id.title_textview);
        TextView descTextView = (TextView) view.findViewById(R.id.description_textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        webView = (WebView) view.findViewById(R.id.web_view);
        mMoreInfoTextView = (TextView) view.findViewById(R.id.expand_textview);
        mMoreInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        if(datum !=null){
            titleText.setText(datum.getTitle());
            descTextView.setText(datum.getDescription());
            Log.e("hello", datum.getThumbnailUrl());
            webView.loadUrl(datum.getArticleLink());

            Picasso.with(getActivity())
                    .load(datum.getThumbnailUrl())
                    .fit()
                    .into(imageView);
        } else
        view = inflater.inflate(R.layout.final_page, container, false);

        return view;
    }


}
