package bridge;

public class GameTurn {

    //클래스 변수로 설정
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    public static String bridgeInput;
    public static int bridgeLength = 0;

    public static void BridgeGameStart(){
        //게임 시작
    }

    public static void BridgeGameTurn(){
        //한 게임 안에서 반복되는 게임 순서들
        //한번 생성한 다리로 계속 진행
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

    public static void ExceptionBridgeDirection(){
        //이동할 방향 예외 처리
    }
}
