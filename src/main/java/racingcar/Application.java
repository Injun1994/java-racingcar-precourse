package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Winner> winners;

    public static void main(String[] args) {
        Application application = new Application();
        Input input = new Input(new ArrayList<>());
        Attempt attempt = new Attempt();
        application.winners = new ArrayList<>();
        Info info = new Info();

        while(input.getRacerList().size() == 0) {
            info.outputErrorMsg();
            input = new Input(new ArrayList<>());
        }

        int attempts = attempt.getNumberOfAttempts();

        System.out.print("\n");
        info.outputRacingResult();


        for (int i = 0; i < attempts; i++) {
            application.playOneSet(input.getRacerList());
            System.out.println();
        }

        info.outputFinalWinner();
        System.out.println(info.lineList(application.winners));
    }

    private void playOneSet(List<Car> racerList) {
        int maxPosition = 0;

        for (Car car : racerList) {
            int pos = car.moveForward();
            String racer = car.getName();

            if (maxPosition == pos) {
                winners.add(Winner.valueOf(racer));
            } else if (maxPosition < pos) {
                maxPosition = pos;

                if(winners != null) {
                    winners.clear();
                }

                winners.add(Winner.valueOf(racer));
            }
        }
    }
}
