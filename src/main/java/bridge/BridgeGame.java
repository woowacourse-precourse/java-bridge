package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> bridge, boolean isUpper, String input) {
        bridge.add(isBlank(isUpper, input));
        return bridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        return command.equals("R");
    }


    /**
     * 사용자가 게임을 시도한 횟수를 세는 메서드
     *
     * @param command : 사용자가 재시도 하면
     * @param cnt     : cnt + 1
     * @return
     */
    public int countGameNum(String command, int cnt) {
        if (command.equals("R")) {
            return cnt + 1;
        }
        return cnt;
    }

    /**
     * 사용자가 이동한 칸이 이동 가능한지 확인하는 메서드
     *
     * @param equals : 사용자가 선택한 칸이 이동 가능한지
     * @return 이동가능하면 O, 이동 불가능하면 X
     */
    public String canGo(boolean equals) {
        if (equals) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 선택한 칸이 위칸인지 아래칸인지 확인하는 메서드
     *
     * @param userChoice : 유저가 입력한 Command(U or D)
     * @return 위칸 다리라면 true, 아래칸 다리라면 false
     */
    public boolean upperOrLower(String userChoice) {
        return userChoice.equals("U");
    }

    /**
     * 선택한 다리의 반대 다리에는 공백을 넣어주는 메서드
     *
     * @param isUpper : 선택한 다리가 위칸 다리인지, 아래 카 다리인지
     * @param OorX    : 선택한 다리가 건널 수 있으면 O, 건널 수 없으면 X
     * @return 선택한 다리라면 O or X, 선택한 다리가 아니라면 공백
     */
    public String isBlank(boolean isUpper, String OorX) {
        if (isUpper) {
            return OorX;
        }
        return " ";
    }
}