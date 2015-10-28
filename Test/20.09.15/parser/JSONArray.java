import java.util.ArrayList;
import java.util.Iterator;



public class JSONArray extends ArrayList {
        public String toString(){
                ItemList list=new ItemList();
                
                Iterator iter=iterator();
                
                while(iter.hasNext()){
                        Object value=iter.next();                               
                        if(value instanceof String){
                                list.add("\""+JSONObject.escape((String)value)+"\"");
                        }
                        else
                                list.add(String.valueOf(value));
                }
                return "["+list.toString()+"]";
        }
                
}