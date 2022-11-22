package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameProcess {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    int userBridgeSize = bridgeSizeProcess();
    List<String> bridgeAnswer = bridgeGenerateProcess(userBridgeSize);

    List<String> userInput = new ArrayList<>();
    Integer gameTryCount = 0;

    public int bridgeSizeProcess() {
        int userBridgeSize = 0;
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        userBridgeSize = userBridgeSizeInput(userBridgeSize);
        return userBridgeSize;
    }

    private int userBridgeSizeInput(int userBridgeSize) {
        while(true) {
            System.out.println("다리의 길이를 입력해주세요");
            try {
                userBridgeSize = inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return userBridgeSize;
        }
    }

    public List<String> bridgeGenerateProcess(int userBridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeAnswer = bridgeMaker.makeBridge(userBridgeSize);
        System.out.println(bridgeAnswer);
        return bridgeAnswer;
    }

    public void bridgeGameProcess() {
        RoundResult roundResult = new RoundResult(true, true, "Q");
//        boolean passFail = true;
//        boolean passFailFinal = true;
//        String userGameCommandInput = "Q";
        do {
            roundResult = new RoundResult(true, true, "Q");
            RoundResult gameRoundResult = gameRound(roundResult.passFail, roundResult.passFailFinal, roundResult.userGameCommandInput);
            roundResult.setUserGameCommandInput(gameRoundResult.getUserGameCommandInput());
            roundResult.setPassFail(gameRoundResult.isPassFail());
            roundResult.setPassFailFinal(gameRoundResult.isPassFailFinal());
            gameTryCount++;
        } while (roundResult.userGameCommandInput.equals("R"));
        System.out.println();
        System.out.println("최종 게임 결과");
        outputView.printMap(userInput, roundResult.passFailFinal);
        System.out.println();
        gamePassFail(roundResult.passFailFinal);
        System.out.println("총 시도한 횟수: " + gameTryCount);
    }

    private RoundResult gameRound(boolean passFail, boolean passFailFinal, String userGameCommandInput) {
        do {
            passFail = userMove(passFail);
            passFailFinal = passFail;
            passFail = false;
        } while(passFail);
        if (!passFailFinal) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            userGameCommandInput = inputView.readGameCommand();
            if (userGameCommandInput.equals("R")) {
                userInput.clear();
            }
        }
        return new RoundResult(passFail, passFailFinal, userGameCommandInput);
    }

    private boolean userMove(boolean passFail) {
        for (int index = 0 ; index < userBridgeSize ; index++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String userUpOrDownInput = inputView.readMoving();
            userInputAdd(userUpOrDownInput);
            passFail = bridgeGame.move(bridgeAnswer, userInput);
            outputView.printMap(userInput, passFail);
            if (!passFail) {
                break;
            }
        }
        return passFail;
    }

    private void userInputAdd(String userMovingInput) {
        userInput.add(userMovingInput);
    }

    public void gamePassFail (boolean passFailFinal) {
        Map<Boolean, String> gameResultPrint = Map.of(true, "성공", false, "실패");
        System.out.println("게임 성공 여부: " + gameResultPrint.get(passFailFinal));
    }


}
