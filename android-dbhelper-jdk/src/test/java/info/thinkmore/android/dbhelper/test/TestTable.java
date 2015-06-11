//Auto generated file, don't override. Please use android_dbhelper_generator to regenerate it

package info.thinkmore.android.dbhelper.test;

import android.content.ContentValues;
import android.database.Cursor;
import info.thinkmore.android.dbhelper.*;
import java.util.Date;

public class TestTable {

    public static final String TableName = "TestTable";

    public static final String[] Columns = { "id","name","age","birthday","nullField" };

    public static final String CreateTableSql = "create table TestTable ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' TEXT, 'age' INTEGER, 'birthday' DateTime, 'nullField' TEXT )";

    public static class CursorReader {
        Cursor cursor;

        CursorReader(Cursor cursor){
            this.cursor = cursor;
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


    }

    public static class ContentValuesBuilder {
        ContentValues content;

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
        

        public ContentValues values(){
            return content;
        }
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
}
