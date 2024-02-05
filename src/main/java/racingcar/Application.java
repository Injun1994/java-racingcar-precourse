package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public List<Winner> winners;


    public static void main(String[] args) {

        Application application = new Application();
        ReadyForRacing racing = new ReadyForRacing(true);
        Attempt attempt = new Attempt();
        application.winners = new ArrayList<>();

        while(racing.getRacerList().size() == 0) {
            System.out.println(Info.ERROR_MSG);
            racing = new ReadyForRacing(true);
        }

        int attempts = attempt.getNumberOfAttempts();

        System.out.println("\n" + Info.RACING_RESULT);


        for (int i = 0; i < attempts; i++) {
            application.playOneSet(racing.getRacerList());
            System.out.println();
        }

        System.out.println(Info.FINAL_WINNER + racing.lineList(application.winners));
    }

    private void playOneSet(List<Car> racerList) {
        int maxPosition = 0;

        for (Car car : racerList) {
            int pos = car.moveForward();
            String racer = car.getName();

            if (maxPosition == pos) {
                Winner winner = new Winner();
                winner.valueOf(racer);
                winners.add(winner);
            } else if (maxPosition < pos) {
                maxPosition = pos;

                if(winners != null) {
                    winners.clear();
                }

                Winner winner = new Winner();
                winner.valueOf(racer);
                winners.add(winner);
            }
        }
    }
}
