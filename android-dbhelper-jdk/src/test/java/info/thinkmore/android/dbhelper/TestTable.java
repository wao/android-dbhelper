//Auto generated file, don't override. Please use android_dbhelper_generator to regenerate it

package info.thinkmore.android.dbhelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import info.thinkmore.android.dbhelper.*;
import java.util.Date;

public class TestTable {

    public static final String TableName = "TestTable";

    public static final String[] Columns = { "id","name","age","birthday","nullField","blob" };

    public static final String CreateTableSql = "create table TestTable ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' TEXT, 'age' INTEGER, 'birthday' DateTime, 'nullField' TEXT, 'blob' BLOB )";

    public static class CursorReader {
        Cursor cursor;

        public CursorReader(Cursor cursor){
            this.cursor = cursor;
        }

        public Cursor getCursor(){
            return cursor;
        }

        public boolean moveToNext(){
            return cursor.moveToNext();
        }

        private IntegerField fieldId;

        public IntegerField id(){
            if( fieldId == null ){
                fieldId = new IntegerField( "id", cursor );
            }
            return fieldId;
        }

        private StringField fieldName;

        public StringField name(){
            if( fieldName == null ){
                fieldName = new StringField( "name", cursor );
            }
            return fieldName;
        }

        private IntegerField fieldAge;

        public IntegerField age(){
            if( fieldAge == null ){
                fieldAge = new IntegerField( "age", cursor );
            }
            return fieldAge;
        }

        private DateField fieldBirthday;

        public DateField birthday(){
            if( fieldBirthday == null ){
                fieldBirthday = new DateField( "birthday", cursor );
            }
            return fieldBirthday;
        }

        private StringField fieldNullfield;

        public StringField nullField(){
            if( fieldNullfield == null ){
                fieldNullfield = new StringField( "nullField", cursor );
            }
            return fieldNullfield;
        }

        private BlobField fieldBlob;

        public BlobField blob(){
            if( fieldBlob == null ){
                fieldBlob = new BlobField( "blob", cursor );
            }
            return fieldBlob;
        }


    }

    public static class ContentValuesBuilder {
        ContentValues content;
        SQLiteDatabase db;
        String where;
        String[] args;

        ContentValuesBuilder( SQLiteDatabase db ){
            content = new ContentValues();
            this.db = db;
        }

        ContentValuesBuilder( ContentValues content ){
            assert content != null;
            this.content = content;
        }
        
        public ContentValuesBuilder id( Integer value ){
            content.put( "id", value );
            return this;
        }
        
        public ContentValuesBuilder name( String value ){
            content.put( "name", value );
            return this;
        }
        
        public ContentValuesBuilder age( Integer value ){
            content.put( "age", value );
            return this;
        }
        
        public ContentValuesBuilder birthday( Date value ){
            content.put( "birthday", value.getTime() );
            return this;
        }
        
        public ContentValuesBuilder nullField( String value ){
            content.put( "nullField", value );
            return this;
        }
        
        public ContentValuesBuilder blob( byte[] value ){
            content.put( "blob", value );
            return this;
        }
        

        public ContentValues values(){
            return content;
        }

        public ContentValuesBuilder where( String value ){
            where = value;
            return this;
        }

        public ContentValuesBuilder args( String[] value ){
            args = value;
            return this;
        }
        
        public long insert(){
           return db.insert( TableName, null, content ); 
        }

        public int update(){
            return db.update( TableName, content, where, args );
        }
    }

    public static ContentValuesBuilder writeBuilder( SQLiteDatabase db ){
        return new ContentValuesBuilder( db );
    }

    public static ContentValuesBuilder contentBuilder(ContentValues content){
        return new ContentValuesBuilder( content );
    }

    public static ContentValuesBuilder contentBuilder(){
        return new ContentValuesBuilder( new ContentValues() );
    }


    public static CursorReader cursorReader(Cursor cursor){
        return new CursorReader( cursor );
    }

    public static class QueryBuilder extends QueryBuilderBase<QueryBuilder, CursorReader>{
        public QueryBuilder( SQLiteDatabase db ){
            super(db);
        }

        public CursorReader query(){
            return new CursorReader( queryCursor() );
        }

        public QueryBuilder getThis(){
            return this;
        }
    }

    public static QueryBuilder queryBuilder( SQLiteDatabase db ){
        return new QueryBuilder( db ).from( TableName ).columns( Columns );
    }
}
