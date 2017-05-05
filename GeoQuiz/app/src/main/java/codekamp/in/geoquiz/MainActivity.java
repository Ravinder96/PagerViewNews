package codekamp.in.geoquiz;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mquestionTextView;
    private Button mtrueButton;
    private Button mfalseButton;
    private Button mnextButton;
    private Button mbackButton;
    public int mCurrentIndex = 0;

    private int mTextResId;
    private boolean mAnswerTrue;
    private String mQuestion;



    private Question[] mQuestionBank = new Question[]{
            new Question(1, false, "Lightning never strikes in the same place twice."),
            new Question(2, true, "If you cry in space the tears just stick to your face."),
            new Question(3, false, "If you cut an earthworm in half, both halves can regrow their body."),
            new Question(4, true, "Humans can distinguish between over a trillion different smells."),
            new Question(5, true, "Adults have fewer bones than babies do."),
            new Question(6, false, "Napoleon Bonaparte was extremely short."),
            new Question(7, false, "Goldfish only have a memory of three seconds."),
            new Question(8, true, "There are more cells of bacteria in your body than there are human cells."),
            new Question(9, false, "Your fingernails and hair keep growing after you die."),
            new Question(10, true, "Birds are dinosaurs."),
            new Question(11, true, "It costs the U.S. Mint more to make pennies and nickels than the coins are actually worth."),
            new Question(12, false, "Water spirals down the plughole in opposite directions in the northern and southern hemispheres."),
            new Question(13, true, "Buzz Aldrin was the first man to urinate on the moon."),
            new Question(14, false, "Twinkies have an infinite shelf life."),
            new Question(15, true, "Humans can’t breathe and swallow at the same time."),
            new Question(16, false, "The popular image of Santa Claus – chubby, bearded, in red and white clothes – was invented by Coca-Cola for an ad campaign."),
            new Question(17, true, "The top of the Eiffel Tower leans away from the sun."),
            new Question(18, false, "Drinking alcohol kills brain cells."),
            new Question(19, true, "The owner of the company that makes Segways died after accidentally driving his Segway off a cliff."),
            new Question(20, true, "A man’s beard grows fastest when he anticipates sex."),
            new Question(21, false, "You do not use only 10% of your brain. You use 100%."),
            new Question(22, true, "Earth is closest to the Sun in january"),
            new Question(23, false, "Astronauts shrink while they are in space"),
            new Question(24, true, "A chicken can live for up to two years without its head."),
            new Question(25, false, "An octopus has two hearts")};

    public int textResId ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mquestionTextView = (TextView) findViewById(R.id.ques_text_view);
        updateAnswer();

        final Question uu = new Question(mTextResId, mAnswerTrue, mQuestion);

        mtrueButton = (Button) findViewById(R.id.true_button);
        mtrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAnswer();
                if (mQuestionBank[mCurrentIndex].isAnswerTrue() == true) {
                    Toast.makeText(getApplicationContext(), "Yeah! You got it right:)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Oops! Better luck next time.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mfalseButton = (Button) findViewById(R.id.false_button);
        mfalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateAnswer();
                if (mQuestionBank[mCurrentIndex].isAnswerTrue() == false) {
                    Toast.makeText(getApplicationContext(), "Yeah! You got it right:)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Oops! Better luck next time.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mnextButton = (Button) findViewById(R.id.next_button);
        mnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;

                if (mCurrentIndex == 24) {
                    nextActivity(v);
                } else {
                    updateAnswer();
                }
            }
        });
        updateAnswer();

        mbackButton = (Button) findViewById(R.id.Previous_button);
        mbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                if (mCurrentIndex < 0) {
                    mCurrentIndex = 0;
                    updateAnswer();
                } else {
                    updateAnswer();
                }
            }
        });
        updateAnswer();


    }

    private void nextActivity(View v) {
        Intent intent = QuizResultActivity.newIntent(this);
        startActivity(intent);
    }

    public void updateAnswer() {
        String question = mQuestionBank[mCurrentIndex].getQuestion();
        mquestionTextView.setText(question);
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        textResId = mCurrentIndex+1;

    }

    public void cheat(View view) {
        updateAnswer();
        Intent intent = CheatActivity.newIntent(this,textResId);
        startActivity(intent);

    }


}