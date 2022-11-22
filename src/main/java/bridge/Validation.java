package bridge;

public class Validation {

    /**
     * 입력받은 길이의 범위, 길이, 정보를 확인하는 메서드
     * @param input : 1자리 or 2자리 숫자로 구성된 문자열
     */
    String readBridgeSizeCheck(String input) {
        throwExceps(input.length() >= 1 && input.length() <= 2, ErrorCodes.ANSWER_ILLEGAL_RANGE.getMessage());
        for(int i = 0; i < input.length(); ++i) {
            throwExceps(input.charAt(i) >= '0' && input.charAt(i) <= '9', ErrorCodes.ANSWER_ILLEGAL_INPUT.getMessage());
        }
        return input;
    }

    /**
     * 받은 문자열이 "U" 혹은 "D"인지 확인
     * @param input : "U" 혹은 "D"여야만 함
     * @return 받은 문자열 그대로 반환
     */
    String readMovingCheck(String input) {
        throwExceps(input.equals("U") || input.equals("R"), ErrorCodes.USER_ILLEGAL_INPUT.getMessage());
        return input;
    }

    /**
     * 받은 문자열이 "Q" 혹은 "R"인지 확인
     * @param input : "Q" 혹은 "R"이여야 함
     * @return 받은 문자열 그대로 반환
     */
    String readCommandCheck(String input) {
        throwExceps(input.equals("R") || input.equals("Q"), ErrorCodes.RETRY_ILLEGAL_INPUT.getMessage());
        return input;
    }

    /**
     * 각 확인 함수에서 조건에 맞지 않을 시 Exception 발생
     * @param condition : Exception을 발생시키기 위한 조건( false일 시 Exception 발생 )
     * @param message : 조건에 담을 메세지
     */
    void throwExceps(boolean condition, String message) {
        if(condition == true) {
            return;
        }
        throw new IllegalArgumentException(message);
    }
}
