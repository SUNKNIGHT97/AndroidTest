package com.example.teamo.diary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class MainActivity extends Activity {
    private Button bt_write;
    private SQLiteDatabase db;
    private Database dop;
    private ListView lv_notes;
    private TextView tv_note_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_write = (Button)findViewById(R.id.btn_Write);
        bt_write.setOnClickListener(new ClickEvent());
        dop = new Database(this, db);
        lv_notes = (ListView)findViewById(R.id.Diary_list);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        showNotesList();
        lv_notes.setOnItemClickListener(new ItemClickEvent());
        lv_notes.setOnItemLongClickListener(new ItemLongClickEvent());
    }
    private void showNotesList(){
        dop.create_db();
        Cursor cursor = dop.query_db();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.list_item,
                cursor,
                new String[]{"_id","title","time"}, new int[]{R.id.list_id,R.id.list_content,R.id.list_date});
        lv_notes.setAdapter(adapter);
        dop.close_db();

    }

    class ItemLongClickEvent implements OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view,
                                       int position, long id) {
            tv_note_id = (TextView)view.findViewById(R.id.list_id);
            int item_id = Integer.parseInt(tv_note_id.getText().toString());
            simpleList(item_id);
            return true;
        }

    }

    public void simpleList(final int item_id){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("编辑日记");
        builder.setMessage("选择操作");
        builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dop.create_db();
                dop.delete_db(item_id);
                dop.close_db();
                lv_notes.invalidate();
                showNotesList();
            }
        });
        builder.setNegativeButton("修改", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this,Writing_page.class);
                intent.putExtra("editModel", "update");
                intent.putExtra("noteId", item_id);
                startActivity(intent);
            }
        });
        builder.create();
        builder.show();
    }

    class ItemClickEvent implements OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            tv_note_id = (TextView)view.findViewById(R.id.list_id);
            int item_id = Integer.parseInt(tv_note_id.getText().toString());
            Intent intent = new Intent(MainActivity.this,Writing_page.class);
            intent.putExtra("editModel", "update");
            intent.putExtra("noteId", item_id);
            startActivity(intent);
        }
    }

    class ClickEvent implements OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_Write :
                    Intent intent = new Intent(MainActivity.this,Writing_page.class);
                    intent.putExtra("editModel", "newAdd");
                    startActivity(intent);
            }
        }
    }
}
