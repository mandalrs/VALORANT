package structural_decorator;

import java.util.Map;

public class Silencer extends AttachmentDecorator {
    public Silencer(IWeapon weapon) {
        super(weapon);
    }

    @Override
    public Map<String, Double> getStats() {
        Map<String, Double> stats = super.getStats();
        stats.put("Noise", 30.0);
        stats.put("Damage", stats.get("Damage") - 2.0);
        return stats;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Silencer";
    }
}
