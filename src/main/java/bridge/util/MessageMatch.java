package bridge.util;

import java.util.Arrays;

public enum MessageMatch {
    TRUE_MATCH(true, "\n\n게임 성공 여부: 성공\n"),
    FALSE_MATCH(false, "\n\n게임 성공 여부: 실패\n");

    boolean flag;
    String message;

    MessageMatch(boolean flag, String message){
        this.flag = flag;
        this.message = message;
    }

    public static String of(boolean flag){
        return Arrays.stream(MessageMatch.values()).
                filter(x -> x.flag == flag).findFirst().orElse(null).getMessage();
    }

    public String getMessage(){
        return this.message;
    }
}
