package android.database.sqlite;

import java.io.File;

import android.content.Context;
import android.database.DatabaseErrorHandler;

public abstract class SQLiteOpenHelper {
    Context context;
    String databaseName;
    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        this.context = context;
        databaseName = name;
    }

    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler handler){
        this.context = context;
        databaseName = name;
    }

    public synchronized void close(){
    }

    public SQLiteDatabase getWritableDatabase(){
        File dbFile = context.getDatabasePath( databaseName );
        boolean needCreate = ! dbFile.exists();
        SQLiteDatabase db = new SQLiteDatabase( dbFile );
        if( needCreate ){
            onCreate( db );
        }

        return db;
    }

    public abstract void onCreate(SQLiteDatabase db);
    public void onOpen(SQLiteDatabase db){}
    public abstract void onUpgrade(SQLiteDatabase db, int oldversion, int newversion);
}
