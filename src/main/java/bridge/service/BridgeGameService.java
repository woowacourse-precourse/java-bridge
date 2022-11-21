package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import bridge.domain.User;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
    private static String mergeBride;
    private static String endMessage;
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

    public boolean checkAllCorrect(){
        List<String> bridgeLoad = bridge.getBridgeLoad();
        List<String> userMove = user.getMove();
        if (bridgeLoad.size() == userMove.size()){
            return true;
        }
        return false;
    }
    public void setMatch() {
        List<String> bridgeLoad = bridge.getBridgeLoad();
        List<String> userMove = user.getMove();
        int userCheckSize = userMove.size() - 1;
        boolean check = userMove.get(userCheckSize).equals(bridgeLoad.get(userCheckSize));
        if (check) {
            gameStatus.setMatchCorrect(true);
        }
        if (!check) {
            gameStatus.setMatchCorrect(false);
        }
    }

    public void setEndMessage() {
        String endMessage = "최종 게임 결과\n";
        String endResult = mergeBride;
        String endCheck = "\n게임 성공 여부 :" + endCheckStatus(gameStatus.getMatchCorrect());
        String endCount = "총 시도한 횟수: " + gameStatus.getGameCount();
        this.endMessage = endMessage + endResult + endCheck + endCount;
    }

    public String getEndMessage(){
        return this.endMessage;
    }

    private String endCheckStatus(boolean isCorrect){
        if (isCorrect){
            return "성공\n";
        }
            return "실패\n";
    }
    private String makeMergeBridge(List<String> bridgeLoad, List<String> userMove) {
        ArrayList<String> checkList = new ArrayList<>();
        for (int i = 0; i < userMove.size(); i++) {
            boolean check = bridgeLoad.get(i).equals(userMove.get(i));
            if (check) {
                checkList.add("O");
            }
            if (!check) {
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
