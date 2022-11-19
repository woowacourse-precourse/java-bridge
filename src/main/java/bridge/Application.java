package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    /**
     1) 위 아래 두칸으로 이어진 다리
        - 다리는 왼쪽 > 오른쪽으로 건넘
        - 위 아래 둘 중 하나의 칸만 건널 수 있음

     2) 다리 길이를 숫자로 입력받은 후 다리 생성
        - 다리 생성할 때 위/아래 칸 중 건널 수 있는 칸은 0 / 1 중 무작위로 정함
        - 위 칸을 건널 수 있는 경우 U / 아래 칸을 건널 수 있는 경우 D 표시
        - 무작위 값이 0인 경우 아래칸 / 1인 경우 위 칸이 건널 수 있는 칸

     3) 다리 생성되면 플레이어가 이동할 칸을 선택
        - 이동할 때 위 칸은 U, 아래 칸은 D 입력
        - 이동할 칸을 건널 수 있으면 O, 못건너면 X 표시

     4) 다리를 끝까지 건너면 게임 종료
     5) 다리를 건너다 실패하면 게임 재시작 (R) 또는 종료 (Q)
        - 재시작시 처음에 만든 다리 재사용
        - 총 시도 횟수 : 첫 시도를 포함해 게임 종료될때까지 시도한 횟수
        - 총 시도 횟수 출력

     [ 추가 요구 사항 ]
     1) 함수 길이 10라인 이하
     2) 메서드 피라미터는 최대 3개
     3) InputView 클래스에서만 readLine() 가능
     4) BridgeGame 클래스에서 InputView, OutputView 를 사용 안함

    **/

    static InputView inputView;
    static List<String> randomBridge;
    static BridgeMaker bridgeMaker;
    static BridgeGame bridgeGame;
    static OutputView outputView;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();
        기능_테스트();
    }

    public static void init() {
        inputView = new InputView();
        randomBridge = new ArrayList<>();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
    }

    public static void 기능_테스트() {
        int retrySelect, decision = -1;
        randomBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        if(randomBridge.size() == 0) return;
        while (true) { // 게임 반복
            decision = bridgeGame.move(randomBridge);
            if(decision != -1) break; // 게임 정답이 맞음
            retrySelect = bridgeGame.retry();
            if(decision == -1) break; // 틀린 길을 선택
        }
        List<String> result = bridgeGame.getResult();
        printResult(result, decision);
    }

    public static void printResult(List<String> result, int decision) {
        System.out.println("최종 게임 결과");
        outputView.printResult(result);
        System.out.print("게임 성공 여부: ");
        if(result.get(result.size()-1) != "XU" && result.get(result.size()-1) != "XD") System.out.println("성공");
        if(result.get(result.size()-1) == "XU" || result.get(result.size()-1) == "XD") System.out.println("실패");
        System.out.print("총 시도한 횟수: " + decision);
    }
}
