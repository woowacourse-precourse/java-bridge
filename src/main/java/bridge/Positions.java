package bridge;

import java.util.ArrayList;
import java.util.List;

public class Positions {
    private static List<String> up_positions = new ArrayList<>();
    private static List<String> down_positions = new ArrayList<>();

    public static List<String> getUp_Positions(){
        return up_positions;
    }
    public static List<String> getDown_positions(){
        return down_positions;
    }
    public static void set_UpPositions(String position){
        up_positions.add(position);
    }

    public static void reset() {
        up_positions.clear();
        down_positions.clear();
    }
    public static void set_downPositions(String position) {
        down_positions.add(position);
    }

}
