package bridge;

public class messages {
    public interface words{
        int max = 20;
        int min = 3;
        String up = "U";
        String down = "D";
        String quit = "Q";
        String right = "O";
        String wrong = "X";
        String partition = "| ";
        String closing = " ]";
        String success = "성공";
        String losing = "실패";
    }

    public interface game{
        String startGame = "다리 건너기 게임을 시작합니다.\n";
        String bridgeSize = "다리의 길이를 입력해주세요.";
        String movingBridge = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
        String restartGame = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
        String resultGame = "최종 게임 결과";
        String SorF = "게임 성공 여부: ";
        String gameCounting = "총 시도한 횟수: ";
    }
    public interface error{
        String rangeE = "[ERROR] 입력범위가 잘못됨.";
        String inputE = "[ERROR] 입력값이 잘못됨.";
    }
}
