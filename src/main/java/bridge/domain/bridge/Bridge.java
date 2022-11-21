package bridge.domain.bridge;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<Square> bridge;

    private Bridge(List<Square> bridge) {
        this.bridge = bridge;
    }

    public static Bridge valueOf(List<String> bridge) {
        List<Square> squares = bridge.stream()
                .map(Square::of)
                .collect(Collectors.toList());

        return new Bridge(squares);
    }

    public boolean canMoveForward(Square other, int position) {
         return bridge.get(position).equals(other);
    }
}
