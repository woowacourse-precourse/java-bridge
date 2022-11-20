package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {
    private static final BridgeMap successMap = new BridgeMap(
            List.of("O", " ", " "),
            List.of(" ", "O", "O")
    );

    private static final BridgeMap failureMap = new BridgeMap(
            List.of(" ", "X", "X"),
            List.of("X", " ", " ")
    );

    @Test
    void getRouteTest() {
        RouteMap expected = new RouteMap(
                List.of("O", " "),
                List.of(" ", "O")
        );
        assertThat(successMap.getRouteAt(2))
                .isEqualTo(expected);

    }

    @Test
    void getStatusTest() {
        RouteMap expected = new RouteMap(List.of("O"), List.of(" "));
        assertThat(successMap.getStatusAt(1))
                .isEqualTo(expected);
    }
}
