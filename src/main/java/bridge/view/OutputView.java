package bridge.view;

import static bridge.constants.OutputConstants.CHOICE_UP_DOWN_MESSAGE;
import static bridge.constants.OutputConstants.END;
import static bridge.constants.OutputConstants.Fail;
import static bridge.constants.OutputConstants.MIDDLE;
import static bridge.constants.OutputConstants.RESULT_MESSAGE;
import static bridge.constants.OutputConstants.SELECT_RESTART_OR_QUIT;
import static bridge.constants.OutputConstants.SET_SIZE_BRIDGE_MESSAGE;
import static bridge.constants.OutputConstants.START;
import static bridge.constants.OutputConstants.START_MESSAGE;
import static bridge.constants.OutputConstants.SUCCEES;
import static bridge.constants.OutputConstants.TOTAL_TRY;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private StringBuffer upSb = new StringBuffer();
    private StringBuffer downSb = new StringBuffer();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(boolean moveCheck, String userMove, int location) {

        String moveResult = changeOX(moveCheck);
        if (location == 0) {
            firstIndex(userMove, moveResult);
        }
        if (location != 0) {
            afterFirst(userMove, moveResult);
        }
        printUpDownSb();
    }

    private void firstIndexIsU(String userMove, String moveResult) {
        upSb.append(START.getMessage() + " " + moveResult + " " + END.getMessage());
        downSb.append(START.getMessage() + "   " + END.getMessage());
    }

    private void firstIndexIsD(String userMove, String moveResult) {
        upSb.append(START.getMessage() + "   " + END.getMessage());
        downSb.append(START.getMessage() + " " + moveResult + " " + END.getMessage());
    }

    private void firstIndex(String userMove, String moveResult) {
        if (userMove.equals("U")) {
            firstIndexIsU(userMove, moveResult);
        }
        if (userMove.equals("D")) {
            firstIndexIsD(userMove, moveResult);
        }
    }

    private void afterFirst(String userMove, String moveResult) {
        if (userMove.equals("U")) {
            afterFirstCheckIsU(userMove, moveResult);
        }
        if (userMove.equals("D")) {
            afterFistCheckIsD(userMove, moveResult);
        }
    }

    private void afterFirstCheckIsU(String userMove, String moveResult) {
        upSb.deleteCharAt(upSb.length() - 1);
        upSb.append(MIDDLE.getMessage() + " " + moveResult + " " + END.getMessage());
        downSb.deleteCharAt(downSb.length() - 1);
        downSb.append(MIDDLE.getMessage() + "   " + END.getMessage());
    }

    private void afterFistCheckIsD(String userMove, String moveResult) {
        upSb.deleteCharAt(upSb.length() - 1);
        upSb.append(MIDDLE.getMessage() + "   " + END.getMessage());
        downSb.deleteCharAt(downSb.length() - 1);
        downSb.append(MIDDLE.getMessage() + " " + moveResult + " " + END.getMessage());
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean moveCheck, int cnt) {
        if (moveCheck == true) {
            printResultIsTrue(cnt);
        }
        if (moveCheck == false) {
            printResultIsFalse(cnt);
        }
    }

    private void printResultIsTrue(int cnt) {
        RESULT_MESSAGE.printMessage();
        printUpDownSb();
        System.out.println(SUCCEES.getMessage() + "" + TOTAL_TRY.getMessage() + "" + cnt);
    }

    private void printResultIsFalse(int cnt) {
        RESULT_MESSAGE.printMessage();
        printUpDownSb();
        System.out.println(Fail.getMessage() + "" + TOTAL_TRY.getMessage() + "" + cnt);
    }


    public void startMessage() {
        START_MESSAGE.printMessage();
        SET_SIZE_BRIDGE_MESSAGE.printMessage();
    }

    public void restartMessage() {
        SELECT_RESTART_OR_QUIT.printMessage();
    }

    public void choiceUpDown() {
        CHOICE_UP_DOWN_MESSAGE.printMessage();
    }

    private String changeOX(boolean moveCheck) {
        if (moveCheck == true) {
            return "O";
        }
        return "X";
    }

    public void printUpDownSb() {
        System.out.println(upSb + "\n" + downSb + "\n");
    }

}

