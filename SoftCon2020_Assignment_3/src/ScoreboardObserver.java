public class ScoreboardObserver implements Observer{
    private int ShipsAlive;
    private int ShipsDestroyed;

    private Subject ScoreboardChecker;

    public ScoreboardObserver(Subject ScoreboardChecker){

        this.ScoreboardChecker = ScoreboardChecker;
        ScoreboardChecker.register(this);

    }

    @Override
    public void update(int ShipsAlive, int ShipsDestroyed) {
        this.ShipsAlive = ShipsAlive;
        this.ShipsDestroyed = ShipsDestroyed;
        checkStatus();
    }

    public int checkStatus(){
        if (ShipsAlive == 0){
            System.out.println(" Sorry, you lost!");
            return 0;
        }
        if (ShipsDestroyed == 0){
            System.out.println("Congratulations, you won!");
            return 0;
        }
        return 1;
    }
}
