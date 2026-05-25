package creational_factory;

import java.util.List;

public class Sage extends Agent {
    public Sage() {
        super("Sage", "Sentinel", List.of("Barrier Orb", "Slow Orb", "Healing Orb"));
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
            case "SPIKE_PLANTED" -> "> Sage: 'Spike is planted. I will wall off the defuser.'";
            case "SPIKE_DEFUSED" -> "> Sage: 'You are all safe now.'";
            case "SPIKE_TICK_5S" -> "> Sage: 'Healing up before the defuse.'";
            default -> null;
        };
        if (output != null) System.out.println(output);
    }
}
