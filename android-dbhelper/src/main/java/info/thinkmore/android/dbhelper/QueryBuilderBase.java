package info.thinkmore.android.dbhelper;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.java.contract.Requires;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class QueryBuilderBase<E, T>{
    String from;
    String[] columns;
    String where;
    String[] whereArgs;
    String groupBy;
    String having;
    String orderBy;
    String limit;

    protected SQLiteDatabase db;

    public E columns( String[] value ){
        columns = value;
        return getThis();
    }

    public E whereArgs( String[] value ){
        whereArgs = value;
        return getThis();
    }

    public E from( String tableName ){
        from = tableName;
        return getThis();
    }

    public E where( String whereClause ){
        where = whereClause;
        return getThis();
    }

    public E groupBy( String gp ){
        groupBy = gp;
        return getThis();
    }

    public E having( String value ){
        having = value;
        return getThis();
    }

    public E orderBy( String value ){
        orderBy = value;
        return getThis();
    }

    public E limit( String value ){
        limit = value;
        return getThis();
    }

    @Requires( { " db != null ", " from != null ", "columns != null" })
        public Cursor queryCursor(){
            return db.query( from, columns, where, whereArgs, groupBy, having, orderBy, limit );
        }

    @Requires( " db != null " )
        public QueryBuilderBase( SQLiteDatabase db ){
            this.db = db;
        }

    abstract public T query();
    abstract public T first();
    abstract public E getThis();
}
