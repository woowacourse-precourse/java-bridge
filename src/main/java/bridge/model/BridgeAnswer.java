package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class BridgeAnswer {
    public List<String> answer;
    private static Integer currentSpot = 0;

    private BridgeAnswer(final List<String> answerBridge) {
        this.answer = answerBridge;
    }


    public static BridgeAnswer using(final BridgeRandomNumberGenerator bridgeGenerator, BridgeLength bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeGenerator);
        return new BridgeAnswer(bridgeMaker.makeBridge(bridgeLength.getLength()));
    }
    public String printAnswer(int printCase) {
        BridgeScreenGenerator bridgeScreenGenerator = new BridgeScreenGenerator(answer, currentSpot, printCase);
        return bridgeScreenGenerator.generateOutputScreen();
    }

    public int compareWithUserMove(int place, String userInput) {
        currentSpot = place;
        if (place == answer.size() -1 && answer.get(place).equals(userInput) == true) {
            return 1;
        }
        if (answer.get(place).equals(userInput) == true) {
            return 2;
        }
        return 3;
    }

    public String printFinalResult(String latestOutput, int tryCount, String successOrFail) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 게임 결과\n" + latestOutput+ "\n");
        sb.append(("게임 성공 여부: " + successOrFail));
        sb.append("총 시도한 횟수:" + tryCount);
        return sb.toString();
    }

    public void resetCurrentSpot() {
        currentSpot = 0;
    }
    public void printAnswerInBeginForTest() {
        System.out.println(answer);
    }
}
