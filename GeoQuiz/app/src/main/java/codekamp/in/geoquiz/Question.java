package codekamp.in.geoquiz;

import java.util.List;

/**
 * Created by hp1 on 20-07-2016.
 */
public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;
    private String mQuestion;

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }



    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }


    public Question(int textResId, boolean answerTrue, String question) {
        this.mTextResId = textResId;
        this.mAnswerTrue = answerTrue;
        this.mQuestion = question;
    }
}
