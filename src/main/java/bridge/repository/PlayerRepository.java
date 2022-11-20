package bridge.repository;

import bridge.domain.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerRepository {
    private Long id;
    private Map<Long, Player> repository;

    public PlayerRepository() {
        id = 1L;
        repository = new HashMap<>();
    }

    public Long insert(Player player) {
        Long playerId = id;
        repository.put(playerId, player);
        incrementId();
        return playerId;
    }

    private void incrementId() {
        id = id + 1;
    }

}