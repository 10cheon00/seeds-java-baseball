package baseball;

public abstract class GameState {
    protected final Game game;

    public GameState(Game game) {
        this.game = game;
    }

    abstract void handle();
}
