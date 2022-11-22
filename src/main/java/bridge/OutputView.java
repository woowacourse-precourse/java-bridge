package bridge;

public class OutputView {
    private static final String ENTER = "\n";
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_LENGTH_OF_BRIDGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_DIRECTION_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_RESTART_STATUS = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String OUTPUT_GAME_RESULT = "최종 게임 결과";
    private static final String OUTPUT_GAME_WIN_OR_LOSE = "게임 성공 여부: ";
    private static final String OUTPUT_GAME_TRY_COUNT = "총 시도한 횟수: ";
    private static final String OUTPUT_GAME_WIN = "성공";
    private static final String OUTPUT_GAME_LOSE = "실패";

    public static void printStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputLengthOfBridge(){
        System.out.println(ENTER + INPUT_LENGTH_OF_BRIDGE);
    }

    public static void printInputDirectionToMove(){
        System.out.println(INPUT_DIRECTION_TO_MOVE);
    }

    public static void printInputGameRestartStatus(){
        System.out.println(INPUT_GAME_RESTART_STATUS);
    }

    public static void printEnter() {
        System.out.print(ENTER);
    }

    public static void printMap(MapMaker mapMaker) {
        for(String map : mapMaker.makeMap())
            System.out.println(map);
        System.out.print(ENTER);
    }

    public static void printResult(MapMaker mapMaker, boolean gameResult, int count) {
        System.out.println(OUTPUT_GAME_RESULT);
        printMap(mapMaker);
        String result = OUTPUT_GAME_WIN;
        if(gameResult)
            result = OUTPUT_GAME_LOSE;

        System.out.println(OUTPUT_GAME_WIN_OR_LOSE + result);
        System.out.println(OUTPUT_GAME_TRY_COUNT + count);
    }
}
