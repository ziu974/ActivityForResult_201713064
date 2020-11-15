package kr.ac.konkuk.activityforresult_201713064;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {
    EditText edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);
        edit = (EditText) findViewById(R.id.edit);          // 두번쨰 텍스트 입력하는 곳
        Button button_ok = (Button) findViewById(R.id.button_ok);   // 확인 버튼
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();       // sub1(호출한 액티비티)에게
                intent.putExtra("INPUT_TEXT2", edit.getText().toString());      // 입력한 텍스트를 인텐트에 담아서 보냄
                setResult(RESULT_OK, intent);       // result code
                finish();           // 액티비티 끝냄
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       // sub2 취소
                setResult(RESULT_CANCELED);     // result code sub1에게 보냄
                finish();          // 액티비티 끝냄
            }
        });
    }
}
