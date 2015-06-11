package android.util;

public class Log {
    public static void v(String tag, String msg){
        System.out.printf( "%s:%s\n", tag, msg );
    }
}
