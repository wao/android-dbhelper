package info.thinkmore.android.dbhelper;

import android.database.Cursor;

public class BlobField extends BaseField implements FieldGetter<byte[]> {

	public BlobField(String fieldName, Cursor cursor) {
        super( fieldName, cursor );
	}

    public byte[] get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return cursor.getBlob( columnIndex() );
    }

    public byte[] getField(){
        return get();
    }

    public byte[] get(byte[] defval){
        if( isNull() ){
            return defval;
        }
        return cursor.getBlob( columnIndex() );
    }
}
