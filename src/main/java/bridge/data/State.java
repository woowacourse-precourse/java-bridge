package bridge.data;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum State {
    SAFE("O", "성공", true),
    FAIL("X", "실패", false);

    private final String OX;
    private final String RESULT;
    private final Boolean ALIVE;


    private static final Map<String, State> BY_OX =
            Stream.of(values()).collect(Collectors.toMap(State::OX, Function.identity()));

    private static final Map<Boolean, State> BY_ALIVE =
            Stream.of(values()).collect(Collectors.toMap(State::ALIVE, Function.identity()));


    public String OX(){return this.OX;}
    public String RESULT(){return this.RESULT;}
    public Boolean ALIVE(){return this.ALIVE;}

    public static State stateOf(Boolean alive){ return BY_ALIVE.get(alive); }
    public static State stateOf(String ox)    { return BY_OX.get(ox);       }




    State(String ox, String result, boolean alive){
        this.OX = ox;
        this.RESULT = result;
        this.ALIVE = alive;
    }
}
