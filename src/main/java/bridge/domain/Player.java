package bridge.domain;

import java.util.List;

public class Player {
    private int position;
    private int tryCount;
    private boolean lastSuccess;

    public Player() {
        position = 0;       // bridge에서의 현재 위치
        tryCount = 1;
        lastSuccess = true;
    }

    public boolean move(List<String> bridge, String command){
        if (bridge.get(position).equals(command)){
            position++;
            return lastSuccess = true;
        }
        return lastSuccess = false;
    }

    public void retry(){
        position = 0;
        tryCount++;
        lastSuccess = true;
    }

    public int getPosition() {
        return position;
    }
    public int getTryCount() {
        return tryCount;
    }

    public boolean isLastSuccess() {
        return lastSuccess;
    }
}
