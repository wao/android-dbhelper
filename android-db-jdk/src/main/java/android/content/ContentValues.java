package android.content;

import java.util.HashMap;
import java.util.Map;

public class ContentValues {
    Map<String,Object> valueMap = new HashMap<String,Object>();

	public ContentValues() {
	}

    public void put( String name, Object value ){
        valueMap.put( name, value );
    }

    public String[] columnNames(){
        return valueMap.keySet().toArray(new String[valueMap.size()]);
    }

    public Object getValue(String name){
        return valueMap.get(name);
    }
}
