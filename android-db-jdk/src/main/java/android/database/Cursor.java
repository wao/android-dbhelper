package android.database;

public interface Cursor {
    byte[] getBlob(int columnIndex);
    int getInt(int columnIndex);
    float getFloat(int columnIndex);
    double getDouble(int columnIndex);
    String getString(int columnIndex);
    long getLong(int columnIndex);
    boolean isNull(int columnIndex);
    int getColumnIndex( String columnName );

    public boolean moveToNext();
    public boolean moveToFirst();
}
