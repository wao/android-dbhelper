package info.thinkmore.android.dbhelper;

import com.google.java.contract.Requires;

import android.database.sqlite.SQLiteDatabase;

public class QueryBuilder extends QueryBuilderBase<QueryBuilder, Integer> {
    //String from;
    //String[] columns;
    //String where;
    //String[] whereArgs;
    //String groupBy;
    //String having;
    //String orderBy;
    //String limit;

    //SQLiteDatabase db;

    //public QueryBuilder columns( String[] value ){
        //columns = value;
        //return this;
    //}

    //public QueryBuilder whereArgs( String[] value ){
        //whereArgs = value;
        //return this;
    //}

    //public QueryBuilder from( String tableName ){
        //this.from = tableName;
        //return this;
    //}

    //public QueryBuilder where( String whereClause ){
        //this.where = whereClause;
        //return this;
    //}

    //public QueryBuilder groupBy( String gp ){
        //groupBy = gp;
        //return this;
    //}

    //public QueryBuilder having( String value ){
        //having = value;
        //return this;
    //}

    //public QueryBuilder orderBy( String value ){
        //orderBy = value;
        //return this;
    //}

    //public QueryBuilder limit( String value ){
        //limit = value;
        //return this;
    //}

    //@Requires( { " db != null ", " from != null ", "columns != null" })
        //public Cursor queryCursor(){
            //return db.query( from, columns, where, whereArgs, groupBy, having, orderBy, limit );
        //}

    @Requires( " db != null " )
        public QueryBuilder( SQLiteDatabase db ){
            super(db);
        }
    
    public Integer query(){
        throw new RuntimeException( "Not implment query() function" );
    }

    public Integer first(){
        throw new RuntimeException( "Not implment query() function" );
    }

    public QueryBuilder getThis(){
        return this;
    }
}
