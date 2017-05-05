package codekamp.in.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private TextView cheatTextview;

    public int textResId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        cheatTextview = (TextView)findViewById(R.id.cheat_text_view);



        Intent intent =  getIntent();
        textResId = intent.getIntExtra("textResId",-1);





        //cheatTextview.setText("good");
        Log.d("kkk",""+textResId);

        if(textResId==1 ){
            cheatTextview.setText("Lightning can and does strike the same place twice." +
                    " Since lightning’s aim is to find the fastest path to the ground, tall buildings," +
                    " trees, and such are at the greatest risk because the higher the object, the more " +
                    "likely it is to be struck.");
        } else if (textResId==2){
            cheatTextview.setText("There's no crying in space.");
        } else if (textResId==3){
            cheatTextview.setText("Only the part with head grows.");
        } else if (textResId==4){
            cheatTextview.setText("");
        } else if (textResId==5){
            cheatTextview.setText("Babies are born with 209 bones and some bones join making 206 bones in an adult.");
        } else if (textResId==6){
            cheatTextview.setText("");
        } else if (textResId==7){
            cheatTextview.setText("Your home goldfish has a better memory than you think." +
                    " A goldfish’s memory doesn’t last just a few seconds; rather, it’s upward of a few months.");
        }else if (textResId==8){
            cheatTextview.setText("");
        }else if (textResId==9){
            cheatTextview.setText("");
        }else if (textResId==10){
            cheatTextview.setText("");
        }else if (textResId==11){
            cheatTextview.setText("");
        }else if (textResId==12){
            cheatTextview.setText("");
        }else if (textResId==13){
            cheatTextview.setText("");
        }else if (textResId==14){
            cheatTextview.setText("");
        }else if (textResId==15){
            cheatTextview.setText("");
        }else if (textResId==16){
            cheatTextview.setText("");
        }else if (textResId==17){
            cheatTextview.setText("");
        }else if (textResId==18){
            cheatTextview.setText("");
        }else if (textResId==19){
            cheatTextview.setText("");
        }else if (textResId==20){
            cheatTextview.setText("");
        }else if (textResId==21){
            cheatTextview.setText("");
        }else if (textResId==22){
            cheatTextview.setText("");
        }else if (textResId==23){
            cheatTextview.setText("");
        }else if (textResId==24){
            cheatTextview.setText("");
        }else if (textResId==25){
            cheatTextview.setText("");
        }




    }


    public static Intent newIntent(Context context,int textResId) {
        Intent intent = new Intent(context, CheatActivity.class);
        intent.putExtra("textResId",textResId);
        return intent;
    }
}
