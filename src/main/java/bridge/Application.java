package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeGame.move;

public class Application {

    /*
    입력
    [x] - 자동으로 생성할 다리 길이 입력 - 3~20이 아니라면 예외
    [x] - 라운드마다 플레이어가 이동할 칸 입력 - U(위), D(아래)중 문자 입력 아니라면 예외
    [x] - 게임 재시작 / 종료 여부 입력 - R(재시작), Q(종료)중 문자 입력 아니라면 예외

    출력
    [] - 게임 시작 문구
    [] - 게임 종료 문구

    구현
    [x] - 다리 생성 시 0과 1 중 무작위 값으로 설정
    [] -  U, D 입력시 판단하여 건널 수 있는지 없는지 여부 판단
    [] - 시도한 횟수 기억
    */
    static List<String> myBridge = new ArrayList<String>();
    static String[][] resultMap;
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = InputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeMaker.makeBridge(bridgeSize);
        // 다리 결과가 들어있는
        for(int i = 0; i < bridgeSize; i++){
            String movingPoint = InputView.readMoving();
            String[][] map = move(BridgeMaker.bridge, movingPoint);
            String result = OutputView.printMap(map);
            if(result.equals("R")) i = -1;
            if(result.equals("Q")) break;
        }
        OutputView.printResult();
    }
}
