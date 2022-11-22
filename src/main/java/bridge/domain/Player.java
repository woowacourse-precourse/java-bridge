package bridge.domain;

import java.util.List;

public class Player {
    private int position;
    private int tryCount;
    private boolean lastCrossSuccess;

    public Player() {
        position = 0;       // bridge에서의 현재 위치
        tryCount = 1;
        lastCrossSuccess = true;
    }

    public boolean move(List<String> bridge, String command){
        if (bridge.get(position).equals(command)){
            position++;
            return lastCrossSuccess = true;
        }
        return lastCrossSuccess = false;
    }

    public void retry(){
        position = 0;
        tryCount++;
        lastCrossSuccess = true;
    }

    public int getPosition() {
        return position;
    }
    public int getTryCount() {
        return tryCount;
    }

    public boolean isLastCrossSuccess() {
        return lastCrossSuccess;
    }
}
