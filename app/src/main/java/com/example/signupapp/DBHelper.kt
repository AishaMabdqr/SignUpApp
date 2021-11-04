package com.example.signupapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class DBHelper (context: Context) : SQLiteOpenHelper(context, "Users.db", null, 1) {

    val sqLiteDatabase : SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("CREATE TABLE USER (pk INTEGER PRIMARY KEY AUTOINCREMENT, Name text, Mobile text, Location text, Password int )")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun saveData(details : Details){
        var cv = ContentValues()
        if(details.Name != null && details.Mobile != null && details.Location != null && details.Pass != null) {
            cv.put("Name", details.Name)
            cv.put("Mobile", details.Mobile)
            cv.put("Location", details.Location)
            cv.put("Password", details.Pass)
            sqLiteDatabase.insert("USER", null, cv)
        }
        else{
            Log.d("DBHelper", " Some fields are null")
        }
    }

    fun retrieveData (id : Int ) : Details {
      //  var userArray = ArrayList<Details>()
        try {
        var c: Cursor = sqLiteDatabase.rawQuery("SELECT * FROM USER WHERE pk= $id", null)
            c.moveToFirst()
        var name = c.getString(1)
            Log.d("DbHelper", "name = $name")
            var mob = c.getString(2)
        var loc = c.getString(3)
            Log.d("DbHelper", "loc = $loc")

       // userArray.add(Details(0, name, loc, mob, 0))
        return Details(0, name, loc,mob,0)
        }catch (e : Exception){
            return Details(0,"","","",0)
        }
    }

    fun checkCred(num : String ) : Int {
        //Read All data using cursor
        var c: Cursor =
            sqLiteDatabase.query("User", null, "Mobile = ?", arrayOf(num), null, null, null)

        if (c.count < 1) { // Handle empty table
            return 0
        } else {
            c.moveToFirst()
            return c.getInt(c.getColumnIndexOrThrow("pk"))

        }
    }
}