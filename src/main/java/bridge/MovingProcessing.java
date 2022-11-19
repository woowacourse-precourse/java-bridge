package bridge;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

public class MovingProcessing {

    private final InputView inputView;
    private final List<String> upSide;
    private final List<String> downSide;

    public MovingProcessing() {
        inputView = new InputView();
        upSide = new ArrayList<>();
        downSide = new ArrayList<>();
    }

    //이부분 바꿀 수 있다면 노력해보자
    //랜덤으로 입력된 브릿지를 매개변수로 사용자의 입력과 매치한다.
    public boolean compareBridgeToInput(List<String> bridge) {
        boolean isSuccess = true;
        while (upSide.size() < bridge.size()) {
            int index = upSide.size();
            isSuccess = readNextMoving(bridge.get(index));
            printBridge();
            if (!isSuccess) {
                return isSuccess;
            }
        }
        return isSuccess;
    }

    private boolean readNextMoving(String bridge) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = inputView.readMoving();
        if (input.length() == 0)
            return true;
        boolean isSuccess = jumpToBridge(input, bridge);
        return isSuccess;
    }

    private boolean jumpToBridge(String input, String bridge) {
        boolean isEquals = input.equals(bridge);
        if (!isEquals) {
            selectedBridgeIsFail(input);
            return false;
        }
        selectedBridgeIsSucceed(input);
        printBridge();
        return true;
    }

    private void selectedBridgeIsSucceed(String input) {
        if (input.equals("U")) {
            upSide.add("O");
            downSide.add(" ");
        }
        if (input.equals("D")) {
            upSide.add(" ");
            downSide.add("O");
        }
    }

    private void selectedBridgeIsFail(String input) {
        if (input.equals("U")) {
            upSide.add("X");
            downSide.add(" ");
        }
        if (input.equals("D")) {
            upSide.add(" ");
            downSide.add("X");
        }
    }

    private void printBridge() {
        String upSideBridge = upSide.stream().collect(joining(" | ", "[ ", " ]"));
        String downSideBridge = downSide.stream().collect(joining(" | ", "[ ", " ]"));
        System.out.println(upSideBridge);
        System.out.println(downSideBridge);
    }
}
