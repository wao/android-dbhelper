package info.thinkmore.android.dbhelper.test;

import java.util.Date;

import android.test.AndroidTestCase;
import android.database.Cursor;
import android.database.sqlite.*;
import lombok.*;
import android.util.*;

public class TestGeneratedCode extends AndroidTestCase {

	protected void setUp() throws Exception {
		super.setUp();
        getContext().deleteDatabase( "firstdb" );
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

    public void testTestTable(){
        TableOpenHelper helper = new TableOpenHelper( getContext(), "firstdb", null, 1 );
        SQLiteDatabase db = helper.getWritableDatabase();

        {
            Cursor cursor = db.query( TestTable.TableName, TestTable.Columns, null, null, null, null, null, null );
            assertTrue( !cursor.moveToNext() );
        }

        val now = new Date();

        
        db.insert( TestTable.TableName, null, TestTable.contentBuilder().age(13).name("mike").birthday(now).values() );

        Integer id;

        {
            Cursor cursor = db.query( TestTable.TableName, TestTable.Columns, null, null, null, null, null, null );
            assertTrue( cursor.moveToNext() );
            val reader = TestTable.cursorReader(cursor);
            //assertEquals( id, reader.id().get() );
            id = reader.id().get();
            Log.v( "Id", id.toString() );
            long v = 1416553316502L;
            Date date = new Date(v);
            Log.v( "DbhelperTest", String.format( "test %d", date.getTime() ) );
            Log.v( "DbhelperTest", String.format( "now %d", now.getTime() ) );
            Log.v( "DbhelperTest", String.format( "reader: %d", reader.birthday().get().getTime() ) );
            assertEquals( "mike", reader.name().get() );
            assertEquals( 13, reader.age().get() );
            assertEquals( now, reader.birthday().get() );
            assertTrue( reader.nullField().isNull() );
        }

        assertEquals( 1, db.update( TestTable.TableName, TestTable.contentBuilder().name("yang").values(), " id = ?1 ", new String[]{ id.toString() }  ) );

        {
            Cursor cursor = db.query( TestTable.TableName, TestTable.Columns, null, null, null, null, null, null );
            assertTrue( cursor.moveToNext() );
            val reader = TestTable.cursorReader(cursor);
            assertEquals( 13, reader.age().get() );
            assertEquals( "yang", reader.name().get() );
        }

        db.close();

    }
}
