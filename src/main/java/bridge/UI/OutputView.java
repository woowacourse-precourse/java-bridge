package bridge.UI;

import bridge.Constants.FrontMan;
import bridge.Constants.StandardTools;
import bridge.Constants.StandardTools.GameStatus;
import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(List<String> bridgeDesignByUser, List<String> bridge) {
        System.out.print(StandardTools.BRIDGE_HEAD);
        printUpperBridge(bridgeDesignByUser, bridge);
        System.out.print(StandardTools.BRIDGE_HEAD);
        printLowerBridge(bridgeDesignByUser, bridge);
        System.out.println();
    }

    private void printUpperBridge(List<String> bridgeDesignByUser, List<String> bridgeDesign) {
        for (int i = 0; i < bridgeDesignByUser.size() - 1; i++) {
            if (Objects.equals(bridgeDesignByUser.get(i), "U")) {
                System.out.print(" O |");
            }
            if (Objects.equals(bridgeDesignByUser.get(i), "D")) {
                System.out.print("   |");
            }
        }
        printUpperLastStep(bridgeDesign.get(bridgeDesignByUser.size() - 1),
                bridgeDesignByUser.get(bridgeDesignByUser.size() - 1));
    }

    private void printUpperLastStep(String lastStep, String lastStepByUser) {
        if (isEndX(lastStep, lastStepByUser, "D")) {
            System.out.println(" X ]");
        }
        if (isBlank(lastStep, lastStepByUser, "D", "U")) {
            System.out.println("   ]");
        }
        if (isEndO(lastStepByUser, "U")) {
            System.out.println(" O ]");
        }
    }

    private void printLowerBridge(List<String> bridgeDesignByUser, List<String> bridgeDesign) {
        for (int i = 0; i < bridgeDesignByUser.size() - 1; i++) {
            if (Objects.equals(bridgeDesignByUser.get(i), "D")) {
                System.out.print(" O |");
            }
            if (Objects.equals(bridgeDesignByUser.get(i), "U")) {
                System.out.print("   |");
            }
        }
        printLowerLastStep(bridgeDesign.get(bridgeDesignByUser.size() - 1),
                bridgeDesignByUser.get(bridgeDesignByUser.size() - 1));
    }

    private void printLowerLastStep(String lastStep, String lastStepByUser) {
        if (isEndX(lastStep, lastStepByUser, "U")) {
            System.out.println(" X ]");
        }
        if (isBlank(lastStep, lastStepByUser, "U", "D")) {
            System.out.println("   ]");
        }
        if (isEndO(lastStepByUser, "D")) {
            System.out.println(" O ]");
        }
    }

    private boolean isEndX(String lastStep, String lastStepByUser, String otherSide) {
        return Objects.equals(lastStepByUser, "X") && Objects.equals(lastStep, otherSide);
    }

    private boolean isBlank(String lastStep, String lastStepByUser, String otherSide,
            String thisSide) {
        return (Objects.equals(lastStepByUser, "X") && Objects.equals(lastStep, thisSide)) ||
                (!Objects.equals(lastStepByUser, " X ") && Objects.equals(lastStepByUser,
                        otherSide));
    }

    private boolean isEndO(String lastStepByUser, String thisSide) {
        return !Objects.equals(lastStepByUser, " X ") && Objects.equals(lastStepByUser, thisSide);
    }

    public void printResult(GameStatus gameStatus, int totalAttempt) {
        if (gameStatus == GameStatus.SUCCEED) {
            System.out.println(FrontMan.SUCCEED_OR_FAIL + "성공");
        }
        if (gameStatus == GameStatus.QUIT) {
            System.out.println(FrontMan.SUCCEED_OR_FAIL + "실패");
        }
        System.out.println(FrontMan.TOTAL_NUMBER_OF_ATTEMPT + totalAttempt);
    }

    public void handleOutput(List<String> bridgeByUser, List<String> bridge, GameStatus status) {
        if (status == GameStatus.PROGRESSING || status == GameStatus.SUCCEED) {
            printMap(bridgeByUser, bridge);
        }
        if (status == GameStatus.QUIT || status == GameStatus.SUCCEED) {
            System.out.println(FrontMan.FINAL_GAME_RESULT);
            printMap(bridgeByUser, bridge);
        }
    }

    public OutputView() {
        System.out.println(FrontMan.BRIDGE_GAME_IS_BEGINNING + "\n");
    }
}
