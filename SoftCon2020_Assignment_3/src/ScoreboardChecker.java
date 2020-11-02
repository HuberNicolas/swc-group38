import java.util.ArrayList;
import java.util.Iterator;
/**
 * CLASS ScoreboardChecker
 * Class for using the implemented observer ScoreboardObserver
 * Observes the game ending status (all ships destroyed)
 */

public class ScoreboardChecker implements Subject {
    private ArrayList<Observer> observers;
    private int ShipsAlive;
    private int ShipsDestroyed;

    public ScoreboardChecker(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        observers.remove(observerIndex);

    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(ShipsAlive, ShipsDestroyed);
        }
    }

    public void checkStatus(Player human, Player computer) {
        this.ShipsAlive = 0;
        Iterator<Ship> iterator_1 = human.shipList.listIterator();
        while (iterator_1.hasNext()) {
            Ship s = iterator_1.next();
            if (s.lifepoints > 0) {
                ShipsAlive++;
            }
        }
        this.ShipsDestroyed = 0;
        Iterator<Ship> iterator_2 = computer.shipList.listIterator();
        while (iterator_2.hasNext()) {
            Ship s = iterator_2.next();
            if (s.lifepoints > 0) {
                ShipsDestroyed++;
            }
        }
        notifyObserver();
    }

    public void printScoreboard(){
        System.out.println("\nYour scoreboard:");
        System.out.println("\t - Player remaining boats: " + ShipsAlive);
        System.out.println("\t - Enemy boats destroyed: " + (10-ShipsDestroyed) + "\n");
    }
}