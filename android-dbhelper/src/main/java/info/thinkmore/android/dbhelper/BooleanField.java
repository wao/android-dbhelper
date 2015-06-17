package info.thinkmore.android.dbhelper;

import android.database.Cursor;

public class BooleanField extends BaseField {

	public BooleanField(String fieldName, Cursor cursor) {
        super( fieldName, cursor );
	}

    public boolean get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return cursor.getInt( columnIndex() ) != 0;
    }

    public boolean get(boolean defval){
        if( isNull() ){
            return defval;
        }
        return cursor.getInt( columnIndex() ) != 0;
    }
}
