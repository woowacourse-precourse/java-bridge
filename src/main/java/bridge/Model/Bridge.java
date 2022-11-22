package bridge.Model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    public static final Bridge getInstance = new Bridge();
    private static List<String> up = new ArrayList<>();
    private static List<String> down = new ArrayList<>();
    private boolean rightAnswer = true; // X 결과가 나올 경우 게임 재시작 호출하기 위해서

    public void init() {
        up = new ArrayList<>();
        down = new ArrayList<>();
        this.rightAnswer = true;
    }

    public void updateUp(String up) {
        this.up.add(up);
    }

    public void updateDown(String down) {
        this.down.add(down);
    }

    public List<String> getUp() {
        return up;
    }

    public List<String> getDown() {
        return down;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }
}
