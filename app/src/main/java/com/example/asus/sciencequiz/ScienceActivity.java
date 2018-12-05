package com.example.asus.sciencequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.asus.sciencequiz.R.id.username_input;

public class ScienceActivity extends AppCompatActivity {

    private static final String TAG ="QuizActivity";
    private static final String KEY_INDEX="index";

    private QuestionsBank mQuestionsBank = new QuestionsBank();

    private TextView mQuestion_number_view;
    private TextView mQuestion_view;
    private TextView mScore_view;
    private TextView username_view;

    private Button mBtn_choice1;
    private Button mBtn_choice2;
    private Button mBtn_choice3;

    private String mAnswer;
    private int mQuestion_number = 0;
    private int mScore_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        Intent intent = getIntent();
        String USERNAME_INPUT = getIntent().getStringExtra("USERNAME_INPUT");

        mQuestion_number_view = (TextView) findViewById(R.id.question_number_view);
        mQuestion_view = (TextView) findViewById(R.id.question_view);
        mScore_view = (TextView)findViewById(R.id.score_count);

        username_view = (TextView)findViewById(R.id.username_view);
        username_view.setText(USERNAME_INPUT);

        mBtn_choice1 = (Button) findViewById(R.id.btn_choice1);
        mBtn_choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtn_choice1.getText() == mAnswer){
                    mScore_count = mScore_count +1;
                    updateScore(mScore_count);
                    Toast.makeText(ScienceActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(ScienceActivity.this,mAnswer, Toast.LENGTH_SHORT).show();
            }updateQuestion();
            }
        });

        mBtn_choice2 = (Button) findViewById(R.id.btn_choice2);
        mBtn_choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtn_choice2.getText() == mAnswer){
                    mScore_count = mScore_count +1;
                    updateScore(mScore_count);
                    Toast.makeText(ScienceActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(ScienceActivity.this,mAnswer, Toast.LENGTH_SHORT).show();
                }updateQuestion();

            }
        });

        mBtn_choice3 = (Button) findViewById(R.id.btn_choice3);
        mBtn_choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtn_choice3.getText() == mAnswer){
                    mScore_count = mScore_count +1;
                    updateScore(mScore_count);
                    Toast.makeText(ScienceActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(ScienceActivity.this,mAnswer, Toast.LENGTH_SHORT).show();
                }updateQuestion();
            }
        });
    }

    private void updateScore(int point){
        if (mScore_count <= mQuestionsBank.getLength()) {
            mScore_view.setText("" + mScore_count + "/" + mQuestionsBank.getLength());
        }else
            Toast.makeText(ScienceActivity.this, "This is the last question!", Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion(){
        if(mQuestion_number<mQuestionsBank.getLength()){

        mQuestion_number_view.setText("Q" + (mQuestion_number+1));

        mQuestion_view.setText(mQuestionsBank.getQuestion(mQuestion_number));
        mBtn_choice1.setText(mQuestionsBank.getChoice1(mQuestion_number));
        mBtn_choice2.setText(mQuestionsBank.getChoice2(mQuestion_number));
        mBtn_choice3.setText(mQuestionsBank.getChoice3(mQuestion_number));

        mAnswer = mQuestionsBank.getAnswer(mQuestion_number);
        mQuestion_number++;

        }else
            Toast.makeText(ScienceActivity.this, "This is the last question!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mQuestion_number);
    }
}
