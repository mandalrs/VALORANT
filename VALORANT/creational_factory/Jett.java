package creational_factory;

import java.util.List;

public class Jett extends Agent {
    public Jett() {
        super("Jett", "Duelist", List.of("Cloudburst", "Updraft", "Tailwind"));
    }

    @Override
    public void display() {
        System.out.printf("> Agent '%s' has spawned!%n", this.name);
        System.out.printf("  Role: %s%n", this.role);
        System.out.printf("  Abilities: %s%n", String.join(", ", this.abilities));
    }

    @Override
    public void update(String subjectName, String message) {
        String output = switch (message) {
            case "SPIKE_PLANTED" -> "> Jett: 'Spike planted? I'm dashing in!'";
            case "SPIKE_DEFUSED" -> "> Jett: 'Nice work, team.'";
            case "SPIKE_TICK_5S" -> "> Jett: 'Only 5s left! Hurry!'";
            default -> null;
        };
        if (output != null) System.out.println(output);
    }
}
