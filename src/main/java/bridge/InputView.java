package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            checkBridgeSizeInRange(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 다리 길이는 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String selectedBridge = Console.readLine();
        checkSelectedBridgeAppropriate(selectedBridge);
        return selectedBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        checkGameCommandAppropriate(gameCommand);
        return gameCommand;
    }

    private void checkBridgeSizeInRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] : 다리 길이는 3이상 20이하여야 합니다.");
        }
    }

    private void checkSelectedBridgeAppropriate(String selectedBridge){
        if(selectedBridge.equals("U")){
            return;
        }
        if(selectedBridge.equals("D")){
            return;
        }
        throw new IllegalArgumentException("[ERROR] : 이동할 칸은 U 또는 D로 선택해 주세요.");
    }

    private void checkGameCommandAppropriate(String gameCommand){
        if(gameCommand.equals("R")){
            return;
        }
        if(gameCommand.equals("Q")){
            return;
        }
        throw new IllegalArgumentException("[ERROR] : R(재시작) 또는 Q(종료)만 입력 가능합니다.");
    }
}
