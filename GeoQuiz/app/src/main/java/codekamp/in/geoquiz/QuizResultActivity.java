package codekamp.in.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
    }


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, QuizResultActivity.class);
        return intent;
    }
}
