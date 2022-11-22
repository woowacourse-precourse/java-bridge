package userdomain.userinterface;

import java.util.List;


public class OutputView {

    public void printStart() {
        System.out.println(Message.START_GAME.getMessage());
    }

    public void printInputBridgeSize() {
        System.out.println(Message.BRIDGE_SIZE.getMessage());
    }

    public void printSelectMove() {
        System.out.println(Message.SELECT_MOVING.getMessage());
    }
    public void printMap(List<String> bridgeGameResult) {
        for (int i = 0; i < bridgeGameResult.size(); i++) {
            System.out.println(bridgeGameResult.get(i));
        }
    }
    public void printResult(List<String> bridgeGameResult,int totalTry,boolean gameContinue) {
        printGameResult();
        printMap(bridgeGameResult);
        if(gameContinue==true){
            printGameFail(totalTry);
            return;
        }
        printGameSuccess(totalTry);
    }
    public void printReStart() {
        System.out.println(Message.RE_START.getMessage());
    }

    public void printGameResult() {
        System.out.println(Message.GAME_RESULT.getMessage());
    }

    public void printGameSuccess(int totalTry) {
        System.out.println(Message.GAME_SUCCESS.getMessage()+" "+Message.SUCCESS.getMessage());
        printGameTry(totalTry);
    }

    public void printGameFail(int totalTry){
        System.out.println(Message.GAME_SUCCESS.getMessage()+" "+Message.FAIL.getMessage());
        printGameTry(totalTry);
    }

    public void printGameTry(int totalTry) {
        System.out.printf(Message.TOTAL_TRY.getMessage() + "%d\n", totalTry);
    }


}
