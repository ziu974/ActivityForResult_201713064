package kr.ac.konkuk.activityforresult_201713064;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SubActivity extends AppCompatActivity {
    static final int GET_STRING2 = 2;       // request code(2번째 텍스트 받기 위한)
    TextView sub2;
    EditText edit;
    boolean intentFlag = false;         //  sub2 액티비티의 내용 입력한 경우에만 main에서 텍스트 표시하기 위해, false면 빈 줄 출력됨

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        edit = (EditText) findViewById(R.id.edit);          // 첫번쨰 텍스트 입력할 곳
        sub2 = (TextView) findViewById(R.id.input_sub2);
        Button button_sub2 = (Button) findViewById(R.id.button_sub2);    // sub2 액티비티로 넘어가는 부분
        button_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this, SubActivity2.class);
                startActivityForResult(intent, GET_STRING2);            // 두 번째 텍스트 받기 위해 intent

            }
        });

        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       // 입력한 텍스트들을 인텐트에 담아서 보냄
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT1", edit.getText().toString());
                if(intentFlag)      // SubActivity2 내용 입력한 경우에만
                intent.putExtra("INPUT_TEXT2", sub2.getText().toString());
                setResult(RESULT_OK, intent);   // 인텐트에 result 코드와 intent 내용 담아서 보냄
                finish();       // 액티비티 끝냄
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);     // 취소되었다는 정보 전송 (입력 없음)
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GET_STRING2) {
            if(resultCode == RESULT_OK){        // sub2로부터 텍스트가 넘어옴
                sub2.setText(data.getStringExtra("INPUT_TEXT2"));
                intentFlag = true;              // Main 액티비티 위해서: sub2의 텍스트 있음을 알림
            }
        }
    }
}
