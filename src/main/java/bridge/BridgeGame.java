package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<String> userInputList = new ArrayList<>();
    private final List<String> bridgeLineOne = new ArrayList<>();
    private final List<String> bridgeLineTwo = new ArrayList<>();
    private static boolean nowState;
    private static int count = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String bridgeState ,String userInput) {

        boolean state = bridgeState.equals(userInput);
        makeUserInputList(userInput, state);
        nowState = state;
        return state;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userInputList.clear();
        bridgeLineOne.clear();
        bridgeLineTwo.clear();
        count++;
    }

    private void makeUserInputList (String userInput, boolean state) {
        if (userInput.equals("U")) {
            inputUp(state);
        }
        if (userInput.equals("D")) {
            inputDown(state);
        }
    }

    private void inputUp (boolean state) {
        if (state) {
            bridgeLineOne.add("O");
        }
        if (!state) {
            bridgeLineOne.add("X");
        }
        bridgeLineTwo.add(" ");
    }

    private void inputDown (boolean state) {
        if (state) {
            bridgeLineTwo.add("O");
        }
        if (!state) {
            bridgeLineTwo.add("X");
        }
        bridgeLineOne.add(" ");
    }

    public List<String> getBridgeLineOne() {
        return bridgeLineOne;
    }

    public List<String> getBridgeLineTwo() {
        return bridgeLineTwo;
    }

    public boolean getNowState() {
        return nowState;
    }


    public int getCount() {
        return count;
    }
}
