package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final boolean MOVE_POSSIBLE = true;
    private static final boolean MOVE_IMPOSSIBLE = false;
    private static final boolean GAME_RETRY = true;
    private static final boolean GAME_QUIT = false;
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, List<String> path) {

        int pathLastIndex = path.size() - 1;
        if (bridge.get(pathLastIndex).equals(path.get(pathLastIndex)))
            if (path.size() != bridge.size())
                return MOVE_POSSIBLE;

        return MOVE_IMPOSSIBLE;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameRetryCommand) {
        if (gameRetryCommand.equals(RETRY))
            return GAME_RETRY;
        if (gameRetryCommand.equals(QUIT))
            return GAME_QUIT;

        throw new IllegalArgumentException();
    }

    public String judgeSuccessFailure(List<String> bridge, List<String> path){
        if(bridge.size() != path.size())
            return FAILURE;

        for( int i = 0 ; i < bridge.size() ;i++)
            if( !bridge.get(i).equals( path.get(i) ) )
                return FAILURE;

        return SUCCESS;
    }
}
