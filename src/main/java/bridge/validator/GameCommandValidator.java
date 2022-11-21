package bridge.validator;

public class GameCommandValidator {
    private static final String QUIT = "Q";
    private static final String RETRY = "R";

    public static void validate(String input){
        if (!input.equals(QUIT) && !input.equals(RETRY)){
            System.out.println("[ERROR] 재시도는 R, 종료는 Q로 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
}
