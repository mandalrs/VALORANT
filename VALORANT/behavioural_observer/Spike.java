package behavioural_observer;

import java.util.ArrayList;
import java.util.List;

public class Spike implements ISubject {

    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
        System.out.printf("\n[Subject] '%s' is now observing the spike.%n", observer.getName());
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        System.out.printf("[Subject] Notifying all %d observers...%n", observers.size());
        for (IObserver observer : observers) {
            observer.update("Spike", message);
        }
    }

    private void drawSpikeAscii() {
        System.out.println("     /\\");
        System.out.println("    |  |");
        System.out.println("    |  |");
        System.out.println("    |__|");
        System.out.println("   /____\\");
        System.out.println(" /________\\");
    }

    public void plant() {
        System.out.printf("\n!!! SPIKE HAS BEEN PLANTED !!!%n");
        drawSpikeAscii();
        notifyObservers("SPIKE_PLANTED");

        System.out.println("\nDefuse Timer:");
        try {
            Thread.sleep(3000); 
            System.out.println("[Subject] Spike timer: 10 seconds left...");
            notifyObservers("SPIKE_TICK_10S");

            Thread.sleep(5000);
            System.out.println("[Subject] Spike timer: 5 seconds left...");
            notifyObservers("SPIKE_TICK_5S");

            Thread.sleep(5000); 

            System.out.println(); 
            System.out.printf("BOOM! Spike exploded!%n");
            notifyObservers("SPIKE_EXPLODED");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void defuse() {
        System.out.printf("\n!!! SPIKE HAS BEEN DEFUSED !!!%n");
        notifyObservers("SPIKE_DEFUSED");
    }
}
