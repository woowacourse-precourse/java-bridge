package bridge.view;

import static bridge.constants.OutputConstants.END;
import static bridge.constants.OutputConstants.Fail;
import static bridge.constants.OutputConstants.MIDDLE;
import static bridge.constants.OutputConstants.RESULT_MESSAGE;
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

        if (location == 0) {
            if (userMove.equals("U")) {
                upSb.append(START.getMessage() + " " + moveResult + " " + END.getMessage());
                downSb.append(START.getMessage() + "   " + END.getMessage());
            }
            if (userMove.equals("D")) {
                upSb.append(START.getMessage() + "   " + END.getMessage());
                downSb.append(START.getMessage() + " " + moveResult + " " + END.getMessage());
            }
        } else {

            if (userMove.equals("U")) {
                upSb.deleteCharAt(upSb.length() - 1);
                upSb.append(MIDDLE.getMessage() + " " + moveResult + " " + END.getMessage());
                downSb.deleteCharAt(downSb.length() - 1);
                downSb.append(MIDDLE.getMessage() + "   " + END.getMessage());
            }
            if (userMove.equals("D")) {
                upSb.deleteCharAt(upSb.length() - 1);
                upSb.append(MIDDLE.getMessage() + "   " + END.getMessage());
                downSb.deleteCharAt(downSb.length() - 1);
                downSb.append(MIDDLE.getMessage() + " " + moveResult + " " + END.getMessage());

            }
        }
        System.out.println(upSb + "\n" + downSb);
    }
    public void printResult(boolean moveCheck, int cnt) {
        if (moveCheck == true) {
            RESULT_MESSAGE.printMessage();
            System.out.println(upSb + "\n" + downSb + "\n");
            System.out.println(SUCCEES.getMessage() + "" + TOTAL_TRY.getMessage() + "" + cnt);

            if (moveCheck == false) {
                RESULT_MESSAGE.printMessage();
                System.out.println(upSb + "\n" + downSb + "\n");
                System.out.println(Fail.getMessage() + "" + TOTAL_TRY.getMessage() + "" + cnt);
            }
        }
    }
    public void startMessage() {
        START_MESSAGE.printMessage();
        SET_SIZE_BRIDGE_MESSAGE.printMessage();
    }
}
