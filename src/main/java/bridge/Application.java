package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Application {

    public static List<String> userInput = new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요");
        String userBridgeSizeInput = InputView.readBridgeSize();
        userBridgeSizeInputValidation(userBridgeSizeInput);
        int userBridgeSize = Integer.parseInt(userBridgeSizeInput);
        userBridgeSizeValidation(userBridgeSize);
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeAnswer = bridgeMaker.makeBridge(userBridgeSize);
        System.out.println(bridgeAnswer);
        for (int index = 0; index < userBridgeSize; index++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String userUpOrDownInput = InputView.readMoving();
            userInputAdd(userUpOrDownInput);
            boolean passFail = move(bridgeAnswer, userInput);
            printMap(userInput, passFail);
            if (!passFail) {
                break;
            }
        }
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String userGameCommandInput = InputView.readGameCommand();
    }

    public static void userBridgeSizeInputValidation (String userBridgeSizeInput) {
        try {
            Integer.parseInt(userBridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다");
        }
    }

    public static void userBridgeSizeValidation(int userBridgeSize) {
        if (userBridgeSize < 3 || 20 < userBridgeSize) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void userInputAdd(String userMovingInput) {
        userInput.add(userMovingInput);
    }

    public static boolean move(List<String> makeBridgeResult, List<String> userInput) {
        if (userInput.get(userInput.size()-1).equals(makeBridgeResult.get(userInput.size()-1))) {
            return true;
        }
        return false;
    }

    public static void printMap(List<String> userInput, boolean passFail) {
        String[][] bridge = bridgeResult(userInput, passFail);
        System.out.println("[ " + String.join(" | ", bridge[0]) + " ]");
        System.out.println("[ " + String.join(" | ", bridge[1]) + " ]");
    }

    public static String[][] bridgeResult(List<String> userInput, boolean passFail) {
        Map<String, Integer> upDownAndNumber = Map.of("U", 0, "D", 1);
        String[][] bridgeOutput = new String[2][userInput.size()];
        for (int index = 0 ; index< userInput.size()-1 ; index++) {
            bridgeOutput[upDownAndNumber.get(userInput.get(index))][index] = "O";
            bridgeOutput[1-upDownAndNumber.get(userInput.get(index))][index] = " ";
        }
        if (passFail) {
            bridgeOutput[upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = "O";
            bridgeOutput[1-upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = " ";
            return bridgeOutput;
        }
        bridgeOutput[upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = "X";
        bridgeOutput[1-upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = " ";
        return bridgeOutput;
    }
}
