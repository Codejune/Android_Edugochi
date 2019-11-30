package kr.ac.ssu.edugochi.TodoDB;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kr.ac.ssu.edugochi.R;

public class TodoHolder {
    public TextView titleView;
    public TextView dateView;
    public TextView memoView;
    public ImageView deleteBtn;

    public TodoHolder(View root) {
        titleView = root.findViewById(R.id.todo_title);
        dateView = root.findViewById(R.id.todo_date);
        memoView= root.findViewById(R.id.todo_memo);
       deleteBtn = root.findViewById(R.id.delete_todo);


    }
}

