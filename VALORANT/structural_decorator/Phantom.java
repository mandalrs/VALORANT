package structural_decorator;

import java.util.HashMap;
import java.util.Map;

public class Phantom implements IWeapon {
    @Override
    public Map<String, Double> getStats() {
        Map<String, Double> stats = new HashMap<>();
        stats.put("Damage", 35.0);
        stats.put("Accuracy", 8.8);
        stats.put("Noise", 30.0);
        stats.put("MagazineSize", 30.0);
        return stats;
    }

    @Override
    public String getDescription() {
        return "Phantom";
    }
}
