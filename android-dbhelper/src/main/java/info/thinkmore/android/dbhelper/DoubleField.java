package info.thinkmore.android.dbhelper;

import android.database.Cursor;

public class DoubleField extends BaseField {

	public DoubleField(String fieldName, Cursor cursor) {
		super(fieldName, cursor);
	}

    public double get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return cursor.getDouble( columnIndex() );
    }

    public double get( double defvalue){
        if( isNull() ){
            return defvalue;
        }
        return cursor.getDouble( columnIndex() );
    }
}
