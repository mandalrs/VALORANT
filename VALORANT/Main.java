import behavioural_observer.Spike;
import creational_factory.*;
import structural_decorator.*;

import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static Agent demoAgent1 = new DuelistFactory().createAgent();
    private static Agent demoAgent2 = new SentinelFactory().createAgent();

    public static void main(String[] args) {
        System.out.println("--- Welcome to the Valorant Design Pattern Simulator ---");

        System.out.println("Spawning default agents for Observer demo...");
        demoAgent1.display();
        demoAgent2.display();

        pauseForEnter();

        while (true) {
            printHeader("MAIN MENU");
            System.out.println("Select the pattern you want to demonstrate:");
            System.out.println("  1. Factory Method (Spawn a new agent)");
            System.out.println("  2. Decorator (Build a weapon)");
            System.out.println("  3. Observer (Simulate a spike plant)");
            System.out.println("  4. Exit");
            System.out.print("> Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    demoFactory();
                    break;
                case "2":
                    demoDecorator();
                    break;
                case "3":
                    demoObserver(demoAgent1, demoAgent2);
                    break;
                case "4":
                    System.out.println("Exiting simulator.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    sleep(1);
            }
        }
    }

    private static void demoFactory() {
        printHeader("DEMO 1: FACTORY METHOD (Creational)");

        Map<String, AgentFactory> factories = Map.of(
            "1", new DuelistFactory(),
            "2", new ControllerFactory(),
            "3", new SentinelFactory()
        );

        System.out.println("Select Agent Type to Spawn:");
        System.out.println("  1. Duelist (Jett)");
        System.out.println("  2. Controller (Brimstone)");
        System.out.println("  3. Sentinel (Sage)");
        System.out.print("> Enter choice: ");

        String choice = scanner.nextLine();
        AgentFactory factory = factories.getOrDefault(choice, new DuelistFactory());

        Agent agent = factory.spawnAgent();
        agent.display();

        pauseForEnter();
    }

    private static void demoDecorator() {
        printHeader("DEMO 2: DECORATOR (Structural)");

        System.out.println("Select Base Weapon:");
        System.out.println("  1. Vandal");
        System.out.println("  2. Phantom");
        System.out.print("> Enter choice: ");
        String choice = scanner.nextLine();

        IWeapon myWeapon = (choice.equals("2")) ? new Phantom() : new Vandal();

        System.out.printf("\n[Decorator] Base Weapon: %s%n", myWeapon.getDescription());
        System.out.printf("[Decorator] Base Stats: %s%n", myWeapon.getStats());

        while (true) {
            System.out.println("\nAdd attachment (or 'done'):");
            System.out.println("  1. Silencer");
            System.out.println("  2. Scope");
            System.out.println("  3. Extended Mag");
            System.out.print("> Enter choice: ");
            String attachChoice = scanner.nextLine();

            if (attachChoice.equals("1")) {
                myWeapon = new Silencer(myWeapon);
                System.out.println("[Decorator] Added Silencer...");
            } else if (attachChoice.equals("2")) {
                myWeapon = new Scope(myWeapon);
                System.out.println("[Decorator] Added Scope...");
            } else if (attachChoice.equals("3")) {
                myWeapon = new ExtendedMag(myWeapon);
                System.out.println("[Decorator] Added Extended Mag...");
            } else if (attachChoice.equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }

            System.out.printf("[Decorator] Current Weapon: %s%n", myWeapon.getDescription());
            System.out.printf("[Decorator] Current Stats: %s%n", myWeapon.getStats());
        }

        pauseForEnter();
    }

    private static void demoObserver(Agent agent1, Agent agent2) {
        printHeader("DEMO 3: OBSERVER (Behavioural)");

        Spike spike = new Spike();

        System.out.println("[Observer] Scenario: Two agents are on the map.");
        spike.attach(agent1);
        spike.attach(agent2);

        spike.plant();

        pauseForEnter();
    }

    // --- Helper Methods ---

    private static void printHeader(String title) {
        // Simple "clear screen" by printing newlines
        for(int i = 0; i < 20; i++) System.out.println();

        String border = "============================================================";
        System.out.println(border);
        // Center title
        int padding = (border.length() - title.length()) / 2;
        System.out.print(" ".repeat(padding));
        System.out.println(title);
        System.out.println(border);
        sleep(0.5); // Small pause for effect
    }

    private static void pauseForEnter() {
        System.out.printf("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
