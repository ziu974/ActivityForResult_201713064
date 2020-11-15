package kr.ac.konkuk.activityforresult_201713064;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text1;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);     // Sub1 시작 버튼
        text1 = (TextView) findViewById(R.id.text_from_sub1);   // sub1에서 입력한 텍스트
        text2 = (TextView) findViewById(R.id.text_from_sub2);   // sub2에서 입력한 텍스트
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, SubActivity.class);       // 버튼 누르면 sub1로 인텐트됨
                startActivityForResult(in, GET_STRING);                      // GET_STRING로 인텐트의 결과를 받아옴
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GET_STRING) {     // Sub1이 setResult()한 내용\
            if(resultCode == RESULT_OK){    // 성공적으로 처리되었다면
                text1.setText(data.getStringExtra("INPUT_TEXT1"));      // sub1 액티비티 텍스트 입력
                text2.setText(data.getStringExtra("INPUT_TEXT2"));      // sub2 액티비티 텍스트 입력
            }
        }
    }
}