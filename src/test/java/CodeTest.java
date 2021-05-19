import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CodeTest {
    public static void main(String[] args){
        Map<String, String> mutableMap = new HashMap<>();
        mutableMap.put("USA", "North America");

        ImmutableMap<String, String> immutableMap = ImmutableMap.copyOf(mutableMap);
        //immutableMap.containsKey("USA");
        //mutableMap.put("Canada", "North America");
        mutableMap.remove("USA");
        System.out.println("immutableMap:" + immutableMap);
        System.out.println("mutableMap:" + mutableMap);
    }

}
