package bridge.repository;

import bridge.domain.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerRepository {
    private static PlayerRepository playerRepository = new PlayerRepository();
    private Long id;
    private Map<Long, Player> repository;

    private PlayerRepository() {
        id = 1L;
        repository = new HashMap<>();
    }

    public static PlayerRepository getInstance() {
        return playerRepository;
    }

    public Long insert(Player player) {
        Long playerId = id;
        repository.put(playerId, player);
        incrementId();
        return playerId;
    }

    public Player findById(Long id) {
        return repository.get(id);
    }

    public void update(Long playerId, Player player) {
        repository.put(playerId, player);
    }

    private void incrementId() {
        id = id + 1;
    }

}