package bridge;

import java.util.List;

public class Game {
    private InputView inputview;
    private OutputView ouputview;
    private int BridgSize;
    private int TryNum;

    private BridgeRandomNumberGenerator BoardGenerator;
    private BridgeMaker BoardMaker;
    public List<String> GameBoard;
    private BridgeGame bridgegame;

    private boolean ExitNum = true;
    private String RetryVal = "S";

    public Game() {
        TryNum = 1;
        inputview = new InputView();
        ouputview = new OutputView();
        BoardGenerator = new BridgeRandomNumberGenerator();
        BoardMaker = new BridgeMaker(BoardGenerator);
        bridgegame = new BridgeGame();
    }
    private void Set_BridgeSize(int value) {
        BridgSize = value;
    }
    public int MakeBoard() {
        ouputview.PrintText("다리 건너기 게임을 시작합니다.");
        ouputview.PrintText("다리의 길이를 입력해주세요.");
        Set_BridgeSize(inputview.readBridgeSize());
        GameBoard = BoardMaker.makeBridge(BridgSize);
        return BridgSize;
    }
    public String InsertMove() {
        ouputview.PrintText("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String Moving = inputview.readMoving();
        return Moving;
    }
    public boolean GameEnd(String Result,int ReturnValue) {
        ouputview.PrintText("최종 게임 결과");
        ouputview.printMap(bridgegame.NowBorad,ReturnValue);
        ouputview.printResult(Result, TryNum);
        return false;
    }
    public int MovingBorad(String NowMoving) {
        int ReturnValue = bridgegame.move(NowMoving,GameBoard);
        ouputview.printMap(bridgegame.NowBorad,ReturnValue);
        return ReturnValue;
    }
    public void MoveResult(int ReturnValue) {
        if (ReturnValue == 2)
            ExitNum = GameEnd("성공",ReturnValue);

        if (ReturnValue == 0) {
            ouputview.PrintText("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            RetryVal = inputview.readGameCommand();
        }
    }
    public void GameOver(int ReturnValue) {
        if (RetryVal.contains("Q")) {
            ExitNum = GameEnd("실패",ReturnValue);;
        }
        if (RetryVal.contains("R")) {
            RetryVal = "S";
            bridgegame.retry();
            TryNum += 1;
        }
    }
    public void GameStart() {
        while (ExitNum) { // 0은 게임 오버,1은 성공, 2는 클리어
            String NowMoving = InsertMove();
            if (NowMoving.contains("EXIT"))  break;
            int ReturnValue = MovingBorad(NowMoving);
            MoveResult(ReturnValue);
            if (RetryVal.contains("EXIT")) break; // 강제종료
            GameOver(ReturnValue);
        }
    }
}
