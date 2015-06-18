package info.thinkmore.android.dbhelper;

import android.database.Cursor;
import android.util.Log;
import java.util.Date;

public class DateField extends BaseField implements FieldGetter<Date> {

	public DateField(String fieldName, Cursor cursor) {
		super(fieldName, cursor);
	}

    public Date get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        long v = cursor.getLong(columnIndex());
        return new Date(v);
    }

    public Date getField(){
        return get();
    }

    public Date get( Date defvalue){
        if( isNull() ){
            return defvalue;
        }
        long v = cursor.getLong(columnIndex());
        return new Date(v);
    }
}
