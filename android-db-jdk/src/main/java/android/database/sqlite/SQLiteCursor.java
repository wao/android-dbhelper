package android.database.sqlite;

import java.util.Arrays;
import java.util.List;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.google.common.collect.Lists;

import android.database.Cursor;

public class SQLiteCursor implements Cursor {

    List<String> columns;
    SQLiteStatement statement;

	public SQLiteCursor( SQLiteStatement statement) {
        this.statement = statement;
	}

    void fetchColumnNames(){
        if( columns == null ){
            try{
                columns = Lists.newArrayListWithCapacity( statement.columnCount() );

                for( int i = 0; i < statement.columnCount(); ++i ){
                    columns.add( statement.getColumnName( i ) );
                }
            }catch(SQLiteException e){
                throw new RuntimeException( "SQLite:Fill Columns Names Error!", e );
            }
        }
    }

    public byte[] getBlob(int columnIndex){
        try{
            return statement.columnBlob( columnIndex );
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public double getDouble(int columnIndex){
        try{
            return statement.columnDouble( columnIndex );
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public String getString(int columnIndex){
        try{
            return statement.columnString( columnIndex );
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public float getFloat(int columnIndex){
        try{
            return (float) statement.columnDouble( columnIndex );
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public long getLong(int columnIndex){
        try{
            return statement.columnLong( columnIndex );
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public int getInt(int columnIndex){
        try{
            return statement.columnInt( columnIndex );
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public boolean isNull(int columnIndex){
        try{
            return statement.columnNull( columnIndex );
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public int getColumnIndex(String columnName){
        return columns.indexOf(columnName);
    }

    public boolean moveToFirst(){
        try{
            statement.reset(false);
            boolean ret = statement.step();
            fetchColumnNames();
            return ret;
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public boolean moveToNext(){
        try{
            boolean ret = statement.step();
            fetchColumnNames();
            return ret;
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }
}
