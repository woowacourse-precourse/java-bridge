package bridge.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Round {

    public static final int ROUND_LOWER_BOUND = 1;
    public static final int ROUND_UPPER_BOUND = 20;
    private static final List<Round> NATURAL_ORDER = generateNaturalOrder();
    private static final String INVALID_ROUND_RANGE_MESSAGE = "허용된 라운드 범위를 벗어났습니다.";

    private Integer round;

    public Round(Integer round) {
        validate(round);
        this.round = round;
    }

    public void nextRound() {
        validate(++round);
    }

    public static List<Round> naturalOrder() {
        return NATURAL_ORDER;
    }

    private static void validate(Integer round) {
        if (round < ROUND_LOWER_BOUND || ROUND_UPPER_BOUND < round) {
            throw new IllegalArgumentException(INVALID_ROUND_RANGE_MESSAGE);
        }
    }

    private static List<Round> generateNaturalOrder() {
        return IntStream.rangeClosed(ROUND_LOWER_BOUND, ROUND_UPPER_BOUND)
                .mapToObj(Round::new)
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Round round = (Round) o;
        return Objects.equals(this.round, round.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
