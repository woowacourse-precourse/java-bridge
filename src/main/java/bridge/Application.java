package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int gameTryCount = 0; // 게임 시도 횟수
        String retry = "R";
        boolean last = true;
        InputView iv = new InputView();
        int bridgeSize = iv.readBridgeSize(); // 다리 길이
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> answer = bm.makeBridge(bridgeSize); // 다리 생성

        BridgeGame bridgeGame = new BridgeGame();
        OutputView ov = new OutputView();

        int bridgeTmp = 0; //현재 다리에서의 위치 index
        while (!retry.equals("Q") || bridgeTmp <= bridgeSize - 1) { //사용자가 Q 입력할 때까지 반복문 시행
            if (!bridgeGame.move(iv.readMoving(), bridgeTmp, answer)) {  //입력받은 경로가 실제와 다른 경우
                last = false; //마지막 틀렸다고 표시
                gameTryCount++; //게임 시행 횟수 증가
                ov.printMap(answer, bridgeTmp, last);
                retry = iv.readGameCommand(); //재시작 여부 확인
                if (retry.equals("R")) {
                    bridgeTmp = bridgeGame.retry();
                    last = true;
                }
                continue;
            }
            if (bridgeTmp == bridgeSize - 1){
                last = true;
                gameTryCount++;
                break;
            }

            ov.printMap(answer, bridgeTmp, last);
            bridgeTmp++;
        }
        ov.printResult(answer, bridgeTmp, last);
        System.out.println("총 시도한 횟수: " + gameTryCount);
    }
}
