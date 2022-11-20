package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import bridge.domain.User;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
    private String mergeBride;
    private Bridge bridge = new Bridge();
    private User user = new User();
    private GameStatus gameStatus = new GameStatus();

    public void setMergeBridge() {
        List<String> bridgeLoad = bridge.getBridgeLoad();
        List<String> userMove = user.getMove();

        mergeBride = makeMergeBridge(bridgeLoad, userMove);
    }

    public String getMergeBridge() {
        return this.mergeBride;
    }

    public void setMatch(){
        List<String> bridgeLoad = bridge.getBridgeLoad();
        List<String> userMove = user.getMove();
        int userCheckSize = userMove.size() - 1;
        boolean check = userMove.get(userCheckSize).equals(bridgeLoad.get(userCheckSize));
        if (check){
            gameStatus.setMatchCorrect(true);
        }
        if (!check){
            gameStatus.setMatchCorrect(false);
        }
    }


    private String makeMergeBridge(List<String> bridgeLoad, List<String> userMove) {
        ArrayList<String> checkList = new ArrayList<>();
        for (int i = 0; i < userMove.size(); i++) {
            if (bridgeLoad.get(i).equals(userMove.get(i))) {
                checkList.add("O");
            } else if (!bridgeLoad.get(i).equals(userMove.get(i))) {
                checkList.add("X");
            }
        }
        return printMergeBridge(userMove, checkList);
    }

    private String printMergeBridge(List<String> userMove, List<String> checkList) {
        ArrayList<String> upperLog;
        ArrayList<String> lowerLog;

        upperLog = makeUpperMessage(checkList, userMove);
        lowerLog = makeLowerMessage(checkList, userMove);

        return makePrintMessage(upperLog, lowerLog);
    }

    private ArrayList<String> makeUpperMessage(List<String> checkList, List<String> userMove) {
        ArrayList<String> upperLog = new ArrayList<>();
        for (int i = 0; i < userMove.size(); i++) {
            if (userMove.get(i).equals("U")) {
                upperLog.add(checkList.get(i));
            } else if (userMove.get(i).equals("D")) {
                upperLog.add(" ");
            }
        }
        return upperLog;
    }

    private ArrayList<String> makeLowerMessage(List<String> checkList, List<String> userMove) {
        ArrayList<String> lowerLog = new ArrayList<>();
        for (int i = 0; i < userMove.size(); i++) {
            if (userMove.get(i).equals("U")) {
                lowerLog.add(" ");
            } else if (userMove.get(i).equals("D")) {
                lowerLog.add(checkList.get(i));
            }
        }
        return lowerLog;
    }

    private String makePrintMessage(ArrayList<String> upperLog, ArrayList<String> lowerLog) {
        String printMessage = "";

        printMessage += makeMessage(upperLog);
        printMessage += makeMessage(lowerLog);

        return printMessage;
    }

    private String makeMessage(ArrayList<String> log) {
        String returnMessage = "[ ";
        for (int i = 0; i < log.size(); i++) {
            returnMessage += log.get(i);
            if (i != log.size() - 1) {
                returnMessage += " | ";
            }
        }
        returnMessage += " ]\n";
        return returnMessage;
    }

}
