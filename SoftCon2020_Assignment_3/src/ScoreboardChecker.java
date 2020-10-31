import java.util.ArrayList;
import java.util.Iterator;

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

    public void checkShipsAlive(Player p) {
        this.ShipsAlive = 0;
        Iterator<Ship> iterator = p.shipList.listIterator();
        while (iterator.hasNext()) {
            Ship s = iterator.next();
            if (s.lifepoints > 0) {
                ShipsAlive++;
            }
        }
        notifyObserver();
    }

    public void checkShipsDestroyed(Player p) {
        this.ShipsDestroyed = 0;
        Iterator<Ship> iterator = p.shipList.listIterator();
        while (iterator.hasNext()) {
            Ship s = iterator.next();
            if (s.lifepoints > 0) {
                ShipsDestroyed++;
            }
        }
        notifyObserver();

    }

    public void printScoreboard(){
        System.out.println("Your scoreboard:"  + "\n");
        System.out.println("\t - Player remaining boats: " + ShipsAlive);
        System.out.println("\t - Enemy boats destroyed: " + ShipsDestroyed);
    }
}