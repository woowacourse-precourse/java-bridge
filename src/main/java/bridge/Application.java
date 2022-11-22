package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Application {

//    public static List<String> userInput = new ArrayList<>();
//    public static Integer gameTryCount = 0;


    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameProcess gameProcess = new GameProcess();
//        InputView inputView = new InputView();
//        int userBridgeSize = gameProcess.bridgeSizeProcess();
//        List<String> bridgeAnswer = gameProcess.bridgeGenerateProcess(userBridgeSize);

        gameProcess.bridgeGameProcess();
//        boolean passFail = true;
//        boolean passFailFinal = true;
//        String userGameCommandInput = "Q";
//        do {
//            do {
//                for (int index = 0; index < userBridgeSize; index++) {
//                    System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
//                    String userUpOrDownInput = inputView.readMoving();
//                    userInputAdd(userUpOrDownInput);
//                    passFail = move(bridgeAnswer, userInput);
//                    printMap(userInput, passFail);
//                    if (!passFail) {
//                        break;
//                    }
//                }
//                passFailFinal = passFail;
//                passFail = false;
//            } while(passFail);
//            if (!passFailFinal) {
//                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
//                userGameCommandInput = inputView.readGameCommand();
//                if (userGameCommandInput.equals("R")) {
//                    userInput.clear();
//                }
//            }
//            gameTryCount++;
//        } while (userGameCommandInput.equals("R"));
//
//        System.out.println();
//        System.out.println("최종 게임 결과");
//        printMap(userInput, passFailFinal);
//        System.out.println();
//        gamePassFail(passFailFinal);
//        System.out.println("총 시도한 횟수: "+ gameTryCount);


    }

//    public static void userInputAdd(String userMovingInput) {
//        userInput.add(userMovingInput);
//    }
//
//    public static boolean move(List<String> makeBridgeResult, List<String> userInput) {
//        if (userInput.get(userInput.size()-1).equals(makeBridgeResult.get(userInput.size()-1))) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void printMap(List<String> userInput, boolean passFail) {
//        String[][] bridge = bridgeResult(userInput, passFail);
//        System.out.println("[ " + String.join(" | ", bridge[0]) + " ]");
//        System.out.println("[ " + String.join(" | ", bridge[1]) + " ]");
//    }
//
//    public static String[][] bridgeResult(List<String> userInput, boolean passFail) {
//        Map<String, Integer> upDownAndNumber = Map.of("U", 0, "D", 1);
//        String[][] bridgeOutput = new String[2][userInput.size()];
//        for (int index = 0 ; index< userInput.size()-1 ; index++) {
//            bridgeOutput[upDownAndNumber.get(userInput.get(index))][index] = "O";
//            bridgeOutput[1-upDownAndNumber.get(userInput.get(index))][index] = " ";
//        }
//        if (passFail) {
//            bridgeOutput[upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = "O";
//            bridgeOutput[1-upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = " ";
//            return bridgeOutput;
//        }
//        bridgeOutput[upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = "X";
//        bridgeOutput[1-upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = " ";
//        return bridgeOutput;
//    }
//
//    public static void gamePassFail (boolean passFailFinal) {
//        Map<Boolean, String> gameResultPrint = Map.of(true, "성공", false, "실패");
//        System.out.println("게임 성공 여부: " + gameResultPrint.get(passFailFinal));
//    }


}
