package com.ayuhani.demo.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ayuhani.demo.R;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    private MyDatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        //        helper = new MyDatabaseHelper(this, "BookStore.db", null, 3);

        Button btnCreate = findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                helper.getWritableDatabase();
                LitePal.getDatabase();
            }
        });

        Button btnAdd = findViewById(R.id.btn_add_data);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                SQLiteDatabase db = helper.getWritableDatabase();
                //                ContentValues values = new ContentValues();
                //                values.put("name", "The Da Vinci Code");
                //                values.put("author", "Dan Brown");
                //                values.put("pages", 454);
                //                values.put("price", 16.69);
                //                db.insert("book", null, values);
                //                values.clear();
                //                values.put("name", "The Lost Symbol");
                //                values.put("author", "Dan Brown");
                //                values.put("pages", 510);
                //                values.put("price", 19.95);
                //                db.insert("book", null, values);

                Book book = new Book();
                book.setAuthor("Dan Brown");
                book.setName("The Da Vinci Code");
                book.setPages(454);
                book.setPrice(16.69);
                book.setPress("Unknow");
                book.save();
            }
        });

        Button btnUpdate = findViewById(R.id.btn_update_data);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                SQLiteDatabase db = helper.getWritableDatabase();
                //                ContentValues values = new ContentValues();
                //                values.put("price", 10.99);
                //                db.update("book", values, "name = ?", new String[]{"The Da Vinci Code"});
                //                db.execSQL("update book set price = 9.99 where name = 'The Lost Symbol';");

                //                Book book = new Book();
                //                book.setAuthor("Dan Brown");
                //                book.setName("The Lost Symbol");
                //                book.setPages(510);
                //                book.setPrice(19.95);
                //                book.setPress("Unknow");
                //                book.save();
                //                book.setPrice(9.9);
                //                book.save();

                //                Book book = new Book();
                //                book.setPrice(14.95);
                //                book.setPress("Anchor");
                //                book.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");

                Book book = new Book();
                book.setToDefault("pages");
                book.updateAll("name = ?", "The Lost Symbol");
            }
        });

        Button btnDel = findViewById(R.id.btn_del_data);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                SQLiteDatabase db = helper.getWritableDatabase();
                //                db.delete("book", "pages > ?", new String[]{"500"});

                DataSupport.deleteAll(Book.class, "price < ?", "15");
            }
        });

        Button btnQuery = findViewById(R.id.btn_query_data);
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                SQLiteDatabase db = helper.getWritableDatabase();
                //                Cursor cursor = db.query("book", null, null, null, null, null, null, null);
                //                if (cursor.moveToFirst()) {
                //                    do {
                //                        String name = cursor.getString(cursor.getColumnIndex("name"));
                //                        String author = cursor.getString(cursor.getColumnIndex("author"));
                //                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                //                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                //                        Log.d("DatabaseActivity", "book name is " + name);
                //                        Log.d("DatabaseActivity", "book author is " + author);
                //                        Log.d("DatabaseActivity", "book pages is " + pages);
                //                        Log.d("DatabaseActivity", "book name is " + price);
                //                    } while (cursor.moveToNext());
                //                    cursor.close();
                //                }

                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book : books) {
                    Log.d("DatabaseActivity", "book name is " + book.getName());
                    Log.d("DatabaseActivity", "book author is " + book.getAuthor());
                    Log.d("DatabaseActivity", "book pages is " + book.getPages());
                    Log.d("DatabaseActivity", "book name is " + book.getPrice());
                    Log.d("DatabaseActivity", "book press is " + book.getPress());
                }
            }
        });
    }
}
