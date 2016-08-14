package info.thinkmore.android.dbhelper;

import android.database.Cursor;

public class ShortField extends BaseField implements FieldGetter<Short> {

	public ShortField(String fieldName, Cursor cursor) {
        super( fieldName, cursor );
	}

    public short get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return cursor.getShort( columnIndex() );
    }

    public Short getField(){
        return get();
    }

    public short get(short defval){
        if( isNull() ){
            return defval;
        }
        return cursor.getShort( columnIndex() );
    }
}
