package com.example.testact.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.testact.Helper.DatabaseHelper;

import java.sql.Array;
import java.util.ArrayList;

public class Comment {

    private int uid;
    private String comment, Date;

    public Comment(String comment, String date ) {
        this.comment = comment;
        Date = date;
    }

    public Comment(int uid, String comment, String date) {
        this.uid = uid;
        this.comment = comment;
        Date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    private ContentValues getSelfContentValues(){
        ContentValues vals = new ContentValues();
        vals.put("comment", this.comment);
        vals.put("Date", this.Date);
        return vals;
    }

    public static ArrayList<Comment> getAllComments(DatabaseHelper dbHelper){
        ArrayList<Comment> com = new ArrayList<>();

        Cursor cr = dbHelper.execRawQuery("SELECT * FROM comment", null);

        while(cr.moveToNext())
            com.add(new Comment(cr.getInt(0), cr.getString(1), cr.getString(2)));

        return com;
    }

    public boolean saveState(Context context, DatabaseHelper dbHelper, boolean isNew){
        if(isNew){
            if(dbHelper.insert(getSelfContentValues(), "comment")){
                Toast.makeText(context, "Comment Added", Toast.LENGTH_LONG).show();
                System.out.println("Comment Saved Self");
                return true;
            }else{
                Toast.makeText(context, "Failed to create", Toast.LENGTH_LONG);
                return false;
            }
        }else{
            if( !dbHelper.update(getSelfContentValues(), "uid="+uid, "comment") ){
                Toast.makeText(context, "Failed to save state", Toast.LENGTH_LONG).show();
                System.out.println("Comment Updated Self");
                return false;
            }else{
                fetchSelf(dbHelper);
                return true;
            }
        }
    }

    public boolean deleteSelf(Context context, DatabaseHelper dbHelper){
        Toast.makeText(context, "Comment Deleted", Toast.LENGTH_SHORT).show();
        return dbHelper.delete("comment", String.format("uid=%d", uid));
    }

    public void fetchSelf(DatabaseHelper dbHelper){
        try{
            Cursor findUser = dbHelper.execRawQuery(String.format("SELECT * FROM comment WHERE comment='%s';", comment), null);
            if (findUser == null || findUser.getCount() == 0 || !findUser.moveToNext()) return;
        }catch(Exception e){
            System.out.println("ERR ON FETCH " + e);
        }
    }

}
