package TableTennisScoring;

public class Main implements Runnable {

    public static void main(String[] args) {
        Interface i = new Interface();
        i.start();
    }

    @Override
    public void run(){}
}
