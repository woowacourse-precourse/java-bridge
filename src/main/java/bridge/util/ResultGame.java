package bridge.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/18
 */
public enum ResultGame {
    SUCCESS_BRIDGE_GAME("성공")
    ,FAILURE_BRIDGE_GAME("실패")
    ;

    private String result;

    ResultGame(String result) {
        this.result = result;
    }

    public static String getResultMessage(boolean result) {
        if(result) {
            return SUCCESS_BRIDGE_GAME.getResult();
        }
        return FAILURE_BRIDGE_GAME.getResult();
    }

    public String getResult() {
        return result;
    }
}
