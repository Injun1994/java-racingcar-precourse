package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Info {
    private final static String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private final static String RACING_RESULT = "실행 결과";
    private final static String FINAL_WINNER = "최종 우승자 : ";
    private final static String ERROR_MSG = "[ERROR]";
    private final static String ERROR_MSG_FOR_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public void outputCarNameInput() {
        System.out.println(CAR_NAME_INPUT);
    }

    public void outputNumberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS);
    }

    public void outputRacingResult() {
        System.out.println(RACING_RESULT);
    }

    public void outputFinalWinner() {
        System.out.print(FINAL_WINNER);
    }

    public void outputErrorMsg() {
        System.out.println(ERROR_MSG);
    }

    public void outputErrorMsgForNumber() {
        System.out.println(ERROR_MSG_FOR_NUMBER);
    }

    protected String lineList(List<Winner> winners) {
        return winners.stream().map(w -> w.valueOf("")).collect(Collectors.joining(", "));
    }

    protected int getNumber() {
        return pickNumberInRange(0, 9);
    }
}