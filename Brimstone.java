package creational_factory;

import java.util.List;

public class Brimstone extends Agent {
    public Brimstone() {
        super("Brimstone", "Controller", List.of("Stim Beacon", "Incendiary", "Sky Smoke"));
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
            case "SPIKE_PLANTED" -> "> Brimstone: 'Spike is down. Smoking heaven and main.'";
            case "SPIKE_DEFUSED" -> "> Brimstone: 'Area clear. Good job.'";
            case "SPIKE_TICK_5S" -> "> Brimstone: 'No time! Dropping the ult!'";
            default -> null;
        };
        if (output != null) System.out.println(output);
    }
}
