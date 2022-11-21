package bridge.constant;

public class MatchConst {
    public class Size{
        public static final int BRIDGE_MAX_SIZE = 20;
        public static final int BRIDGE_MIN_SIZE = 3;
    }

    public class Button{
        public static final String UP_BOTTON = "U";
        public static final String DOWN_BOTTON = "D";
        public static final String RETRY_BOTTON = "R";
        public static final String END_BOTTON = "Q";
        public static final String NONE_BOTTON = "NONE";
    }

    public class InputMessage{
        public static final String CHOOSE_UPDOWN = "이동할 칸을 선택해주세요. (위: "+Button.UP_BOTTON+", 아래: "+Button.DOWN_BOTTON+")";
        public static final String CHOOSE_RETRY =  "게임을 다시 시도할지 여부를 입력해주세요. (재시도: "+Button.RETRY_BOTTON+", 종료: "+Button.END_BOTTON+")";
    }

}
