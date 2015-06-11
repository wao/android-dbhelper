package info.thinkmore.android.dbhelper;

import android.database.Cursor;

public class IntegerField extends BaseField {

	public IntegerField(String fieldName, Cursor cursor) {
        super( fieldName, cursor );
	}

    public int get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return cursor.getInt( columnIndex() );
    }

    public int get(int defval){
        if( isNull() ){
            return defval;
        }
        return cursor.getInt( columnIndex() );
    }
}
