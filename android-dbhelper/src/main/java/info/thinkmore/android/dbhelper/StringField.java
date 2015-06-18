package info.thinkmore.android.dbhelper;

import android.database.Cursor;

public class StringField extends BaseField implements FieldGetter<String> {

	public StringField(String fieldName, Cursor cursor) {
        super( fieldName, cursor );
	}

    public String get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return cursor.getString( columnIndex() );
    }

    public String getField(){
        return get();
    }

    public String get(String defval){
        if( isNull() ){
            return defval;
        }
        return cursor.getString( columnIndex() );
    }
}
