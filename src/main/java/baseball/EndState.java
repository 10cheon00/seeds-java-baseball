package baseball;

import camp.nextstep.edu.missionutils.Console;

public class EndState extends GameState {
    public EndState(Game game) {
        super(game);
    }

    public void handle() {
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            this.game.changeState(new InGameState(this.game));
        } else if (input.equals("2")) {
            this.game.end();
        }
    }
}
