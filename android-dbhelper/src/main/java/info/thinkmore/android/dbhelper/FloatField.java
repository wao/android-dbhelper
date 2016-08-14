package info.thinkmore.android.dbhelper;

import android.database.Cursor;

public class FloatField extends BaseField implements FieldGetter<Float> {

	public FloatField(String fieldName, Cursor cursor) {
		super(fieldName, cursor);
	}

    public float get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return cursor.getFloat( columnIndex() );
    }

    public Float getField(){
        return get();
    }

    public float get( float defvalue ){
        if( isNull() ){
            return defvalue;
        }
        return cursor.getFloat( columnIndex() );
    }
}
