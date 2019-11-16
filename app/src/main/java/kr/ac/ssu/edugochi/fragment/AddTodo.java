package kr.ac.ssu.edugochi.fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

import kr.ac.ssu.edugochi.R;
import kr.ac.ssu.edugochi.TodoDB.TodoDBManager;

public class AddTodo extends AppCompatActivity {


    private ImageButton mAdd;
    private EditText taskEditText;
    private TodoDBManager mTodoDBManager;
    private ImageButton DateBtn;
    TextView mTxtDate;
    Calendar c = Calendar.getInstance();
    int mYear= c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        mTxtDate = findViewById(R.id.txtdate);


        taskEditText = findViewById(R.id.todo_title);
        DateBtn = findViewById(R.id.data_btn);
        DateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDate();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp); //뒤로가기 버튼 이미지 지정


    }
    void ChooseDate(){
        new DatePickerDialog(this, mDateSetListener, mYear,
                mMonth, mDay).show();

    }
    DatePickerDialog.OnDateSetListener mDateSetListener =

            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    // TODO Auto-generated method stub
                    //사용자가 입력한 값을 가져온뒤
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    //텍스트뷰의 값을 업데이트함
                    UpdateNow();
                }
            };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            case R.id.action_add_task: { // 오른쪽 상단 버튼 눌렀을 때
                AddClick();
                //  Toast.makeText(this, "추가되었습니다.", Toast.LENGTH_SHORT).show();

            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.todo_menu, menu);

        return true;
    }
    void UpdateNow(){

        mTxtDate.setText(String.format("%d년 %d월 %d일", mYear, mMonth + 1, mDay));

    }
    private void AddClick() {
    }
}