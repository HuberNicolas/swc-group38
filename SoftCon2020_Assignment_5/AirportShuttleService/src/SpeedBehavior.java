public interface SpeedBehavior {
    public void printSpeedBehavior();
}

class slowSpeed implements SpeedBehavior{
    @Override
    public void printSpeedBehavior() {
        System.out.print("slow speed; ");
    }
}

class normalSpeed implements SpeedBehavior{
    @Override
    public void printSpeedBehavior() {
        System.out.print("normal speed; ");
    }
}

class fastSpeed implements SpeedBehavior{
    @Override
    public void printSpeedBehavior() {
        System.out.print("fast speed; ");
    }
}
