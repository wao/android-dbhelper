package info.thinkmore.android.dbhelper;

import android.database.Cursor;

public class LongField extends BaseField {

	public LongField(String fieldName, Cursor cursor) {
		super(fieldName, cursor);
	}

    public long get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return cursor.getLong( columnIndex() );
    }

    public long get(long defvalue){
        if( isNull() ){
            return defvalue;
        }
        return cursor.getLong( columnIndex() );
    }
}
