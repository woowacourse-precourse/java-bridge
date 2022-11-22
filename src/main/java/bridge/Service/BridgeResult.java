package bridge.Service;

import bridge.Entity.Bridge;
import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.View.ValidateSet;

import java.util.List;

public class BridgeResult {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final ValidateSet validateSet = new ValidateSet();

    public static void getresult(List<Bridge> bridgeList, List<String> userList) {
        int floor;
        for (int j=0;j<2;j++) {
            outputView.openBranket();
            cycle(bridgeList, userList, getFloor(j));
            outputView.closeBrank();
        }
    }

    private static void cycle(List<Bridge> bridgeList, List<String> userList, int floor) {
        for (int i=0;i<bridgeList.size();i++) {
            Bridge result = compare(bridgeList.get(i).getLetter(), userList.get(i));
            if (Bridge.fintByLetter(userList.get(i)).getNumber() == floor)
                outputView.printMap(result);
            if (Bridge.fintByLetter(userList.get(i)).getNumber() != floor)
                outputView.printBlank();
            if (i+1 < bridgeList.size())
                outputView.line();
        }
    }

    private static int getFloor(int index) {
        if (index == 0)
            return 1;
        return 0;
    }

    private static Bridge compare(String bridge, String user) {
        return Bridge.compareTo(bridge, user);
    }

    public static void endGame(List<Bridge> bridgeList, List<String> userList) {
        outputView.printResult();
        getresult(bridgeList, userList);
    }

    public static void printAllResult(boolean status, int count) {
        outputView.printCount(status, count);
    }

    public static boolean requestReGame() {
        outputView.guideEnterReGame();
        String answer;
        if (!IsValideRegameAnswer(answer = inputView.readGameCommand()))
            outputView.guideEnterReGame();
        if (answer.equals("R"))
            return true;
        return false;
    }

    private static boolean IsValideRegameAnswer(String answer) {
        validateSet.reGame(answer);
        return true;
    }
}
