package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTurn {

    //클래스 변수로 설정
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    public static String bridgeInput;
    public static int bridgeLength;
    public static List<String> bridge;
    public static List<String> bridgeFrame = new ArrayList<>(Arrays.asList("[ ]","[ ]"));
    public static int Cnt = 0;

    public static void BridgeGameStart(){
        //게임 시작
        outputView.printStart();
        try {
            BridgeGameTurn();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void BridgeGameTurn(){
        //한 게임 안에서 반복되는 게임 순서들
        //한번 생성한 다리로 계속 진행
        bridgeLength = getBridgeLength();
        bridge = bridgeMaker.makeBridge(bridgeLength);
        Cnt = 0;
        while(true){
            Cnt++;
            if(!GameRun(bridge, bridgeLength)) {
                break;
            }
        }
        BridgeGameEnd(bridgeFrame, Cnt);
    }

    public static boolean GameRun(List<String> bridge, int length) {
        bridgeFrame = new ArrayList<>(Arrays.asList("[ ]","[ ]"));
        for(int i=0; i<length; i++) {
            String status = getStatus(bridge, i);
            if(status.equals("X")){
                return bridgeGame.retry(inputView.readGameCommand());
            }
        }
        return false;
    }

    public static String getStatus(List<String> bridge, int idx) {
        String moving = inputView.readMoving();
        ExceptionBridgeDirection(moving);
        String status = BridgeGame.rightOrWrong(bridge, moving, idx);
        bridgeFrame = bridgeGame.move(bridgeFrame,status,moving);
        outputView.printMap(bridgeFrame);
        return status;
    }

    public static int getBridgeLength(){
        //다리 길이 입력 받고 예외 처리까지
        try {
            bridgeInput = inputView.readBridgeSize();
            bridgeLength = Integer.parseInt(bridgeInput);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다");
        }
        if(bridgeLength < 3 || bridgeLength > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3과 20 사이의 숫자여야 합니다");
        }
        return bridgeLength;
    }

    public static void ExceptionBridgeDirection(String direction){
        //이동할 방향 예외 처리
        if(!direction.equals("U") && !direction.equals("D")){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다");
        }
    }

    public static void BridgeGameEnd(List<String> bridge, int cnt){
        outputView.printResult(bridge, cnt);
    }
}
