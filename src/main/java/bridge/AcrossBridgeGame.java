package bridge;

import java.util.List;

public class AcrossBridgeGame {
    private InputView inputView;
    private OutputView outputView;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private int BridgeSize;
    private int cnt;
    public List<String> Board;
    private boolean Exited = true;
    private String Retry = "S";

    public AcrossBridgeGame() {
        cnt = 1;
        inputView = new InputView();
        outputView = new OutputView();
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame();
    }

    private void SetBridgeSize(int value) {
        BridgeSize = value;
    }

    public int MakeBoard() {
        inputView.GameStart();
        SetBridgeSize(inputView.readBridgeSize());
        Board = bridgeMaker.makeBridge(BridgeSize);
        return BridgeSize;
    }

    public String InsertMove(){
        String Moving = inputView.readMoving();
        return Moving;
    }

    public boolean EndGame(String Result, int ReturnValue) {
        outputView.print_Result();
        outputView.printMap(bridgeGame, bridgeGame.GameBoard, ReturnValue);
        outputView.printResult(Result, cnt);
        return false;
    }

    public int MovingBoard(String Moving){
        int ReturnValue = bridgeGame.move(Moving, Board);
        outputView.printMap(bridgeGame, bridgeGame.GameBoard, ReturnValue);
        return ReturnValue;
    }

    public void MoveResult(int ReturnValue){
        if (ReturnValue == 2){
            Exited = EndGame("성공", ReturnValue);
        }
        if (ReturnValue == 0){
            Retry = inputView.readGameCommand();
        }
    }
    public void GameOver(int ReturnValue) {
        if (Retry.contains("Q")) {
            Exited = EndGame("실패",ReturnValue);;
        }
        if (Retry.contains("R")) {
            Retry = "S";
            bridgeGame.retry();
            cnt += 1;
        }
    }
    public void GameStart() {
        while (Exited) { // 0은 게임 오버,1은 성공, 2는 클리어
            String NowMoving = InsertMove();
            if (NowMoving.contains("EXIT"))  {
                break;
            }
            int ReturnValue = MovingBoard(NowMoving);
            MoveResult(ReturnValue);
            if (Retry.contains("EXIT")) {
                break; // 강제종료
            }
            GameOver(ReturnValue);
        }
    }
}
