package com.example.testact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testact.Helper.DatabaseHelper;
import com.example.testact.Model.Comment;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private LinearLayout commentContainer;
    private EditText commentField;
    private DatabaseHelper dbHelper;
    private ArrayList<Comment> comments;
    private Button addComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DatabaseHelper(this);
        dbHelper.checkTableExist();
        commentContainer = findViewById(R.id.commentContainer);
        commentField = findViewById(R.id.commentField);
        addComment = findViewById(R.id.addComment);
        addComment.setOnClickListener(e -> {
            Toast.makeText(this, "Comment Added", Toast.LENGTH_SHORT).show();
            addComments();
        });
        renderComments();
    }

    void addComments(){
        Date d = new Date();
        String comment = commentField.getText().toString();
        String ndate = String.format("%d/%d/%d at %d:%d", d.getMonth(), d.getDate(), d.getYear(), d.getHours(), d.getMinutes());
        Comment ncom = new Comment(comment, ndate);
        ncom.saveState(this, dbHelper, true);
        ncom.fetchSelf(dbHelper);
        commentField.setText("");
        renderComments();
    }

    void renderComments(){
        comments = Comment.getAllComments(dbHelper);
        commentContainer.removeAllViews();
        for(Comment com : comments){
            View f = getLayoutInflater().inflate(R.layout.commentlayout, null);
            ((ImageButton) f.findViewById(R.id.edit)).setOnClickListener( e -> {
                Dialog edit = new Dialog(this);
                edit.show();
                edit.setContentView(R.layout.dialog_box);
                ((EditText) edit.findViewById(R.id.editME)).setText(com.getComment());
                ((Button) edit.findViewById(R.id.save)).setOnClickListener(view ->{
                    com.setComment(((EditText) edit.findViewById(R.id.editME)).getText().toString());
                    com.saveState(this,dbHelper,false);
                    edit.dismiss();
                    renderComments();
                });
            });
            ((TextView) f.findViewById(R.id.comment)).setText(com.getComment());
            ((TextView) f.findViewById(R.id.date)).setText(com.getDate());
            ((ImageButton) f.findViewById(R.id.deleteComment)).setOnClickListener( e -> {
                com.deleteSelf(this, dbHelper);
                renderComments();
            });
            commentContainer.addView(f);
        }
    }
}