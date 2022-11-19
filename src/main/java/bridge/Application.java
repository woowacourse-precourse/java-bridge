package bridge;

import java.util.List;
public class Application {
    InputView inputview = new InputView();


    public static void Game(List<String > GameBoard) {
        BridgeGame BG = new BridgeGame();
        InputView inputview = new InputView();
        OutputView ouputview = new OutputView();
        boolean ExitNum = true;
        String RetryVal = "S";
        int TryNum = 1;

        while (ExitNum) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String Moving = inputview.readMoving();
            System.out.println(BG.NowBorad);
            // 0은 게임 오버
            // 1은 문제 없음
            // 2는 클리어
            int ReturnValue = BG.move(Moving,GameBoard);
            ouputview.printMap(BG.NowBorad,ReturnValue);

            if (ReturnValue == 2) {
                ExitNum = false;
                System.out.println("최종 게임 결과");
                ouputview.printMap(BG.NowBorad,ReturnValue);
                ouputview.printResult("성공", TryNum);
            }
            if (ReturnValue == 0) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                RetryVal = inputview.readGameCommand();
            }

            if (RetryVal.contains("Q")) {
                ExitNum = false;
                System.out.println("최종 게임 결과");
                ouputview.printMap(BG.NowBorad,ReturnValue);
                ouputview.printResult("실패", TryNum);
            }
            if (RetryVal.contains("R")) {
                RetryVal = "S";
                BG.retry();
                TryNum += 1;
            }
        }


    }
    public static void main(String[] args) {

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        InputView inputview = new InputView();
        int BridgSize = inputview.readBridgeSize();

        BridgeRandomNumberGenerator BoardGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker BoardMaker = new BridgeMaker(BoardGenerator);
        List<String> GameBoard = BoardMaker.makeBridge(BridgSize);
        Game(GameBoard);

    }
}
