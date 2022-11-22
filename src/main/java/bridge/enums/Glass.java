package bridge.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Glass {
    UP("U", 1),
    DOWN("D", 0);

    private final String MOVE;
    private final Integer DIRECTION;

    private static final Map<String, Glass> BY_MOVE =
            Stream.of(values()).collect(Collectors.toMap(Glass::MOVE, Function.identity()));

    private static final Map<Integer, Glass> BY_DIRECTION =
            Stream.of(values()).collect(Collectors.toMap(Glass::DIRECTION, Function.identity()));


    public String MOVE()      { return this.MOVE;}
    public Integer DIRECTION(){ return this.DIRECTION;}

    public static Glass glassOf(String move)      { return BY_MOVE.get(move);          }
    public static Glass glassOf(Integer direction){ return BY_DIRECTION.get(direction);}




    Glass(String move, Integer direction){
        this.MOVE = move;
        this.DIRECTION = direction;
    }
}
