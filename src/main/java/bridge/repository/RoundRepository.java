package bridge.repository;

import bridge.domain.Round;
import java.util.ArrayList;
import java.util.List;

public class RoundRepository {

    private List<Round> rounds;

    public RoundRepository() {
        rounds = new ArrayList<>();
    }

    public void add(Round round) {
        rounds.add(round);
    }

}
