package bridge;

import java.util.List;

public class Utils {
    public static String change_delimter(List<String> positions){
            String str = positions.toString();
            str = str.replace("[", "[ ");
            str = str.replace(", ", " | ");
            str = str.replace("]", " ]");

            return str;
        }

}
