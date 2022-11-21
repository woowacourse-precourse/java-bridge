package bridge.UI;

import bridge.Constants.StandardTools;
import bridge.Database.BridgeData;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeData bridgeData) {
        printUpperBridge(bridgeData.getBridgeDesignByUser(), bridgeData.getBridge());
        printLowerBridge(bridgeData.getBridgeDesignByUser(), bridgeData.getBridge());
    }

    private void printUpperBridge(List<String> bridgeDesignByUser, List<String> bridgeDesign) {
        System.out.print(StandardTools.BRIDGE_HEAD);
        for(int i = 0; i < bridgeDesignByUser.size()-1; i++) {
            if (Objects.equals(bridgeDesignByUser.get(i), "U")) {
                System.out.print(" O |");
            }
            if (Objects.equals(bridgeDesignByUser.get(i), "D")) {
                System.out.print("   |");
            }
        }
        printUpperLastStep(bridgeDesign.get(bridgeDesignByUser.size()-1), bridgeDesignByUser.get(bridgeDesignByUser.size()-1));
    }

    private void printUpperLastStep(String lastStep, String lastStepByUser) {
        if (Objects.equals(lastStepByUser, "X") && Objects.equals(lastStep, "D")) {
            System.out.println(" X ]");
        }
        if ((Objects.equals(lastStepByUser, "X") && Objects.equals(lastStep, "U")) ||
                (!Objects.equals(lastStepByUser, " X ") && Objects.equals(lastStepByUser, "D"))) {
            System.out.println("   ]");
        }
        if (!Objects.equals(lastStepByUser, " X ") && Objects.equals(lastStepByUser, "U")) {
            System.out.println(" O ]");
        }
    }

    private void printLowerBridge(List<String> bridgeDesignByUser, List<String> bridgeDesign) {
        System.out.print(StandardTools.BRIDGE_HEAD);
        for(int i = 0; i < bridgeDesignByUser.size()-1; i++) {
            if (Objects.equals(bridgeDesignByUser.get(i), "D")) {
                System.out.print(" O |");
            }
            if (Objects.equals(bridgeDesignByUser.get(i), "U")) {
                System.out.print("   |");
            }
        }
        printLowerLastStep(bridgeDesign.get(bridgeDesignByUser.size()-1), bridgeDesignByUser.get(bridgeDesignByUser.size()-1));
    }

    private void printLowerLastStep(String lastStep, String lastStepByUser) {
        if (Objects.equals(lastStepByUser, "X") && Objects.equals(lastStep, "U")) {
            System.out.println(" X ]");
        }
        if ((Objects.equals(lastStepByUser, "X") && Objects.equals(lastStep, "D")) ||
                (!Objects.equals(lastStepByUser, " X ") && Objects.equals(lastStepByUser, "U"))) {
            System.out.println("   ]");
        }
        if (!Objects.equals(lastStepByUser, " X ") && Objects.equals(lastStepByUser, "D")) {
            System.out.println(" O ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
