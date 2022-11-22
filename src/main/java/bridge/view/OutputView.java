package bridge.view;

import bridge.Command;
import bridge.UserStatus;
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
    public void printMap(List<String> bridge, int userLocation) {
        printUpperBridge(bridge, userLocation, false);
        printLowerBridge(bridge, userLocation, false);
    }

    private void printBridgeContent(String bridgeValue, Command command) {
        if (Objects.equals(bridgeValue, command.getCommandString())) {
            System.out.print(" O ");
        }
    }

    private void printEmptyContent(String bridgeValue, Command command) {
        if (Objects.equals(bridgeValue, command.getCommandString())) {
            System.out.print("   ");
        }
    }

    private void printEndBracket(int userLocation, int currentLocation) {
        if (userLocation - 1 == currentLocation) {
            System.out.print("] ");
        }
    }

    private void printHorizontalLine(int userLocation, int currentLocation) {
        if (userLocation - 1 != currentLocation) {
            System.out.print("|");
        }
    }

    private void printUpperBridge(List<String> bridge, int userLocation, boolean isFailed) {
        printBlock(bridge, userLocation, Command.UP);
        printAdditionalHorizontalLine(userLocation, isFailed);
        if (isFailed) {
            String failedValue = bridge.get(userLocation);
            handleFailedBlock(failedValue, Command.UP, isFailed);
        }
        printBridgeEndLine();
    }

    private void printAdditionalHorizontalLine(int userLocation, boolean isFailed) {
        if (userLocation != 0 && isFailed) {
            System.out.print("|");
        }
    }

    private void printBlock(List<String> bridge, int userLocation, Command commandTarget) {
        System.out.print("[");
        Command commandOpposite = Command.getOppositeCommand(commandTarget);
        for (int i = 0; i < userLocation; i++) {
            String bridgeValue = bridge.get(i);
            printBridgeContent(bridgeValue, commandTarget);
            printEmptyContent(bridgeValue, commandOpposite);
            printHorizontalLine(userLocation, i);
        }

    }

    private void printLowerBridge(List<String> bridge, int userLocation, boolean isFailed) {
        printBlock(bridge, userLocation, Command.DOWN);
        printAdditionalHorizontalLine(userLocation, isFailed);
        if (isFailed) {
            String failedValue = bridge.get(userLocation);
            handleFailedBlock(failedValue, Command.DOWN, isFailed);
        }
        printBridgeEndLine();
    }

    private void handleFailedBlock(String bridgeValue, Command command, boolean isFailed) {
        if (isFailed) {
            printFailedBlock(bridgeValue, command);
            printBlankBlock(bridgeValue, command);
        }
    }

    private void printFailedBlock(String bridgeValue, Command command) {
        if (Objects.equals(bridgeValue, command.getCommandString())) {
            System.out.print(" X ");
        }
    }

    private void printBlankBlock(String bridgeValue, Command command) {
        if (!Objects.equals(bridgeValue, command.getCommandString())) {
            System.out.print("   ");
        }
    }


    private void printBridgeEndLine() {
        System.out.print("] ");
        System.out.println("");
    }

    public void printFailedMap(List<String> bridge, int userLocation) {
        printUpperBridge(bridge, userLocation, true);
        printLowerBridge(bridge, userLocation, true);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, UserStatus userStatus) {
        String userResult = printSuccessFailure(bridge, userStatus);
        System.out.println("");
        System.out.println("게임 성공 여부: " + userResult);
        System.out.println("총 시도한 횟수: " + userStatus.getUserAttempt());
    }


    private String printSuccessFailure(List<String> bridge, UserStatus userStatus) {
        System.out.println("최종 게임 결과");
        if (userStatus.isGameResultSuccess()) {
            printMap(bridge, userStatus.getUserLocation());
            return "성공";
        }
        printFailedMap(bridge, userStatus.getUserLocation());
        return "실패";
    }


}
