package bridge.data;

import bridge.domain.Moving;

import java.util.ArrayList;
import java.util.List;

public class MovingData {
    private static final List<Moving> movings = new ArrayList<>();

    public static void add(Moving moving){
        movings.add(moving);
    }

    public static int getRecentMovingIndex(){
        return movings.size() - 1 ;
    }
}