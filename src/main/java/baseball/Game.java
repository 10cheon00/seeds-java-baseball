package baseball;

public class Game {
    private GameState state;

    public Game() {
        this.state = new InGameState(this);
    }

    public void run() {
        while (!this.isEnd()) {
            this.state.handle();
        }
    }

    public void changeState(GameState state) {
        this.state = state;
    }

    public void end() {
        this.state = null;
    }

    public boolean isEnd() {
        return this.state == null;
    }
}
