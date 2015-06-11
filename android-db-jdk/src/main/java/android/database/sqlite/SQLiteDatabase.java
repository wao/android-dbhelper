package android.database.sqlite;

import java.io.File;

import android.content.ContentValues;
import android.database.Cursor;

import com.almworks.sqlite4java.*;
import com.google.common.base.Joiner;

import android.util.Log;

public class SQLiteDatabase {
    public interface CursorFactory{
    }

    SQLiteConnection db;

	public SQLiteDatabase(File dbFile) {
        java.util.logging.Logger.getLogger("com.almworks.sqlite4java").setLevel(java.util.logging.Level.WARNING); 
        db = new SQLiteConnection( dbFile );
        try{
            db.open(true);
        }catch(SQLiteException e){
            throw new RuntimeException(e);
        }
	}

    public void close(){
        db.dispose();
    }

    public void execSQL( String sql ){
        try{
            db.exec( sql );
        }catch(SQLiteException e){
            throw new RuntimeException(e);
        }
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit){
        StringBuilder sql = new StringBuilder( "select " );
        sql.append( columns[0] );
        for( int i = 1; i < columns.length; ++i ){
            sql.append( ", " );
            sql.append( columns[i] );
        }

        sql.append( " from " );
        sql.append( table );

        if( selection != null ){
            sql.append( " where " );
            sql.append( selection );
        }

        if( groupBy != null ){
            sql.append( " group by " );
            sql.append( groupBy );
        }

        if( having != null ){
            sql.append( " having " );
            sql.append( having );
        }

        if( orderBy != null ){
            sql.append( " order by " );
            sql.append( orderBy );
        }

        if( limit != null ){
            sql.append( " limit " );
            sql.append( limit );
        }



        try{
            SQLiteStatement stat = db.prepare( sql.toString() );
            if( selectionArgs != null ){
                for( int i = 0; i < selectionArgs.length; ++i ){
                    stat.bind( i, selectionArgs[i] );
                }
            }

            return new SQLiteCursor( columns, stat );
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs){
        try{
            int wherelen = 0;

            if( whereArgs != null ){
                wherelen = whereArgs.length;
            }

            String[] columnNames = values.columnNames();
            StringBuilder args = new StringBuilder("update ");
            args.append( table );
            args.append( " set " );
            for( int i = 1; i < columnNames.length+1; ++i ){
                args.append ( columnNames[i-1] );
                args.append( "= ?" );
                args.append( i+ wherelen );
            }

            if( whereClause != null ){
                args.append( " where " );
                args.append( whereClause );
            }
            
            //Log.v( "Sqlite", args.toString() );

            SQLiteStatement sql = db.prepare( args.toString() );

            if( whereArgs != null ){
                for( int i = 0; i < whereArgs.length; ++i ){
                    //Log.v( "Bind", String.format( "%d=%s", i+1, whereArgs[i] ) );
                    sql.bind( i+1, whereArgs[i] );
                }
            }

            for( int i = 0; i < columnNames.length; ++i ){
                //Log.v( "Bind", String.format( "%d", i+wherelen+1 ) );
                Object value = values.getValue(columnNames[i]);
                if( value.getClass().equals(Integer.class) ){
                    sql.bind( i+wherelen+1, ((Integer)value).intValue() );
                }else if( value.getClass().equals(Long.class)){
                    sql.bind( i+wherelen+1, ((Long)value).longValue() );
                }else if( value.getClass().equals(Double.class)){
                    sql.bind( i+wherelen+1, ((Double)value).doubleValue() );
                }else if( value.getClass().equals(Float.class)){
                    sql.bind( i+wherelen+1, ((Float)value).floatValue() );
                }else if( value.getClass().equals(String.class)){
                    sql.bind( i+wherelen+1, (String)value );
                }else{
                    throw new RuntimeException( String.format( "Unsupport value type %s for field %s", value.getClass().toString(), columnNames[i] ) );
                }
            }

            while( sql.step() ){
            }
            sql.dispose();

            return db.getChanges();
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }

    public long insert(String table, String nullColumnHack, ContentValues values){
        try{
            String[] columnNames = values.columnNames();
            StringBuilder args = new StringBuilder(":1");
            for( int i = 1; i < columnNames.length; ++i ){
                args.append( ", :" );
                args.append( i+1 );
            }
            
            SQLiteStatement sql = db.prepare( String.format( "insert into %s (%s) values( %s )" , table, Joiner.on(",").join(columnNames), args.toString() ) , false );
            for( int i = 0; i < columnNames.length; ++i ){
                Object value = values.getValue(columnNames[i]);
                if( value.getClass().equals(Integer.class) ){
                    sql.bind( i+1, ((Integer)value).intValue() );
                }else if( value.getClass().equals(Long.class)){
                    sql.bind( i+1, ((Long)value).longValue() );
                }else if( value.getClass().equals(Double.class)){
                    sql.bind( i+1, ((Double)value).doubleValue() );
                }else if( value.getClass().equals(Float.class)){
                    sql.bind( i+1, ((Float)value).floatValue() );
                }else if( value.getClass().equals(String.class)){
                    sql.bind( i+1, (String)value );
                }else{
                    throw new RuntimeException( String.format( "Unsupport value type %s for field %s", value.getClass().toString(), columnNames[i] ) );
                }
            }


            sql.step();
            sql.dispose();

            return db.getLastInsertId();
        }catch(SQLiteException e){
            throw new RuntimeException( e );
        }
    }
}
