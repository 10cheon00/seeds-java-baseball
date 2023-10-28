package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InGameState extends GameState {
    private final int SIZE = 3;
    private final Answer answer = new Answer(SIZE);
    private int input;
    private int strikeCount;
    private int ballCount;

    public InGameState(Game game) {
        super(game);
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void handle() {
        this.getInput();

        this.strikeCount = this.answer.getStrikeCountFromInput(input);
        this.ballCount = this.answer.getBallCountFromInput(input);

        this.printResult();
        this.changeStateToEndIf3Strikes();
    }

    private void getInput() throws IllegalArgumentException {
        String input = Console.readLine();

        if (input.length() != SIZE) {
            throw new IllegalArgumentException();
        }

        try {
            this.input = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private void printResult() {
        String result = "";

        if (strikeCount + ballCount == 0) {
            result = "낫싱";
        }
        if (ballCount > 0) {
            result = String.format("%d볼", ballCount);
        }
        if (strikeCount > 0) {
            result += (ballCount > 0 ? " " : "") + String.format("%d스트라이크", strikeCount);
        }
        System.out.println(result);
    }

    public void changeStateToEndIf3Strikes() {
        if (strikeCount == SIZE) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", SIZE);
            this.game.changeState(new EndState(this.game));
        }
    }
}
