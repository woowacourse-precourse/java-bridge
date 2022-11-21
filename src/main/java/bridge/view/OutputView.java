package bridge.view;


import static bridge.enums.BridgeType.*;
import static bridge.enums.GameMapStatus.*;

import bridge.domain.User;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder upState = new StringBuilder();
    private StringBuilder downState = new StringBuilder();

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printChoiceBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printChoiceUpOrDown() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printChoiceRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세여.(재시도: R, 종료: Q)");
    }

    public void printProgressMap() {
        System.out.println(START_MAP.getSymbol() + upState + END_MAP.getSymbol());
        System.out.println(START_MAP.getSymbol() + downState + END_MAP.getSymbol());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int location, boolean pass, String moveUpOrDown) {
        setBoundaryLine(location);
        checkUpOrDown(moveUpOrDown, pass);
        printProgressMap();
    }

    private void setBoundaryLine(int location) {
        if (location >= 1) {
            upState.append(BOUNDARY_LINE.getSymbol());
            downState.append(BOUNDARY_LINE.getSymbol());
        }
    }

    private void checkUpOrDown(String UpAndDown, boolean pass) {
        if (UpAndDown.equals(UP.getCommand())) {
            setUpState(pass);
        }
        if (UpAndDown.equals(DOWN.getCommand())) {
            setDownState(pass);
        }
    }

    private void setUpState(boolean pass) {
        if (pass) {
            upState.append(PASS.getSymbol());
        }
        if (!pass) {
            upState.append(FAIL.getSymbol());
        }
        downState.append(SPACE.getSymbol());
    }

    private void setDownState(boolean pass) {
        if (pass) {
            downState.append(PASS.getSymbol());
        }
        if (!pass) {
            downState.append(FAIL.getSymbol());
        }
        upState.append(SPACE.getSymbol());
    }

    public void clearMap() {
        upState = new StringBuilder();
        downState = new StringBuilder();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user) {
        System.out.println("\n최종 게임 결과");
        printProgressMap();
        System.out.println("\n게임 성공 여부: " + isPass(user.isSuccessComplete()));
        System.out.println("총 시도한 횟수: " + user.getTryCount());
    }

    private String isPass(boolean pass) {
        if (pass) {
            return "성공";
        }
        return "실패";
    }
}
