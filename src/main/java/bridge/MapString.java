package bridge;

import java.util.ArrayList;
import java.util.List;

public class MapString {
    public static String upstairs = "";
    public static String downstairs = "";

    public List<String> makeMapString(String upstairs, String downstairs){
        List<String> mapString = new ArrayList<>();
        mapString.add(upstairs);
        mapString.add(downstairs);
        return (mapString);
    }
}
