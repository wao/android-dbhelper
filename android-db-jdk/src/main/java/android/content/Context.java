package android.content;

import java.io.File;
import java.io.FilenameFilter;

public class Context {
    File baseDir;

    public Context(File baseDir ){
        this.baseDir = baseDir;
        baseDir.mkdirs();
    }

    public File getDatabasePath(String name){
        return new File( baseDir, name );
    }

    public boolean deleteDatabase( final String name ){
        for( File one : baseDir.listFiles( new FilenameFilter() {
            @Override
            public boolean accept( File dir, String onename ){
                return onename.startsWith( name );
            }
        }) ){
            one.delete();
        }
        return true;
    }
}
