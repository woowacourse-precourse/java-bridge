package bridge.constant;

public class MatchConst {
    public class Size{
        public static final int BRIDGE_MAX_SIZE = 20;
        public static final int BRIDGE_MIN_SIZE = 3;
    }

    public class Button{
        public static final String UP_BUTTON = "U";
        public static final String DOWN_BUTTON = "D";
        public static final String RETRY_BUTTON = "R";
        public static final String END_BUTTON = "Q";
        public static final String NONE_BUTTON = "NONE";
    }

    public class InputMessage{
        public static final String CHOOSE_UPDOWN = "이동할 칸을 선택해주세요. (위: "+Button.UP_BUTTON +", 아래: "+Button.DOWN_BUTTON +")";
        public static final String CHOOSE_RETRY =  "게임을 다시 시도할지 여부를 입력해주세요. (재시도: "+Button.RETRY_BUTTON +", 종료: "+Button.END_BUTTON +")";
    }

}
