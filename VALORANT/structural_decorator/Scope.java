package structural_decorator;

import java.util.Map;

// A 'Concrete Decorator'
public class Scope extends AttachmentDecorator {
    public Scope(IWeapon weapon) {
        super(weapon);
    }

    @Override
    public Map<String, Double> getStats() {
        Map<String, Double> stats = super.getStats();
        stats.put("Accuracy", stats.get("Accuracy") + 1.0);
        return stats;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Scope";
    }
}
