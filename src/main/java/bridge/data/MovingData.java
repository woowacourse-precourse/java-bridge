package bridge.data;

import bridge.domain.Moving;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임 입력한 값 저장 위한 데이터
 */
public class MovingData {
    private static final List<Moving> movings = new ArrayList<>();

    public static void add(Moving moving){
        movings.add(moving);
    }

    public static int getRecentMovingIndex(){
        return movings.size() - 1 ;
    }

    public static int getMovingDataSize(){
        return movings.size();
    }

    public static void reset() {
        movings.clear();
    }
}