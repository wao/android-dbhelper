package android.test;

import java.io.File;

import android.content.Context;

import junit.framework.TestCase;

public class AndroidTestCase extends TestCase {
    Context context = new Context( new File( "tmp/test/android_test" ) );

    public Context getContext(){
        return context;
    }
}
