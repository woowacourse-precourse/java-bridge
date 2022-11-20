package bridge;

import static constant.Message.*;
import static constant.Message.*;

import constant.Message;
import java.util.List;
import view.InputView;

public class Bridge {
    private final List<String> bridge;
    private int current;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.current = -1;
    }



    public int getCurrent() {
        return current;
    }

    public int getNextPosition(int index) {
        return index + 1;
    }

    public void move() {
        current += 1;

    }

    public boolean isUpside(int index) {
        return bridge.get(index) == UP;
    }

    public boolean isDownside(int index) {
        return bridge.get(index) == DOWN;
    }

    public String get(int index) {
        return bridge.get(index);
    }

    public boolean isNextMovable(String upperOrLower) {
        if (bridge.get(getNextPosition(getCurrent())).equals(upperOrLower)) {
            return true;
        }
        return false;
    }

    public boolean whetherFollowingEndOrNot() {
        return getCurrent() == getBridgeEndIndex();
    }

    public int getBridgeEndIndex() {
        return bridge.size() - 1;
    }

    public void readAndMove(InputView inputView) {

        do {
            String upperOrLower = inputView.readMoving();

            if (isNextMovable(upperOrLower)) {
                printSuccess();
                move();
                continue;
            }
            printFailure();
            return;

        } while (whetherFollowingEndOrNot());
    }

    /**
     *  만약 current가 -1(처음 이동할 칸이 건널 수 없는 칸일 때)이고
     *  바로 X를 출력해야 할 때도 고려해야 한다.
     *  그리고 마지막 경계 검사도
     */
    public void printFailure() {
        printUpperLine(getNextPosition(getCurrent()), false);
        printLowerLine(getNextPosition(getCurrent()), false);
    }

    public void printSuccess() {
        // current + 1 까지 범위의 로그 메시지를 출력한다.
        printUpperLine(getNextPosition(getCurrent()), true);
        printLowerLine(getNextPosition(getCurrent()), true);
    }

    private void printLowerLine(int until, boolean isLastIndexMatching) {
        String str = BRIDGE_BEGIN;
        for (int i = 0; i < until; i++) {
            if (isDownside(i)) {
                str += CORRECT + BRIDGE_DIVIDING_LINE;
                continue;
            }
            str += EMPTY + BRIDGE_DIVIDING_LINE;
        }
        // isLastIndexMatching 말고 그냥 upOrDown을 인자로 전달하면?
        // 마지막이 D이면
        if (isLastIndexMatching && isDownside(until)) {
            str += CORRECT + BRIDGE_END;
        }
        // 마지막이 'O'이지만 'D'가 아니라면
        if (isLastIndexMatching && isUpside(until)) {
            str += EMPTY + BRIDGE_END;
        }
        // 마지막 'X'이고 ('U'인데 'D'를 입력)
        if (!isLastIndexMatching && isUpside(until)) {
            str += WRONG + BRIDGE_END;
        }
        if (!isLastIndexMatching && isDownside(until)) {
            str += EMPTY + BRIDGE_END;
        }
        System.out.println(str + NEWLINE);
    }

    private void printUpperLine(int until, boolean isLastIndexMatching) {
        String str = BRIDGE_BEGIN;
        for (int i = 0; i < until; i++) {
            if (isUpside(i)) {
                str += CORRECT + BRIDGE_DIVIDING_LINE;
                continue;
            }
            str += EMPTY + BRIDGE_DIVIDING_LINE;
        }

        if (isUpside(until) && isLastIndexMatching) {
            str += CORRECT + BRIDGE_END;
        }
        if (isDownside(until) && isLastIndexMatching) {
            str += EMPTY + BRIDGE_END;
        }
        if (isUpside(until) && !isLastIndexMatching) {
            str += EMPTY + BRIDGE_END;
        }
        if (isDownside(until) && !isLastIndexMatching) {
            str += WRONG + BRIDGE_END;
        }

        System.out.println(str);
    }


    public void minusCurrent() {
        current -= 1;
    }
}
