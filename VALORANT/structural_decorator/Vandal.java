package structural_decorator;

import java.util.HashMap;
import java.util.Map;

public class Vandal implements IWeapon {
    @Override
    public Map<String, Double> getStats() {
        Map<String, Double> stats = new HashMap<>();
        stats.put("Damage", 40.0);
        stats.put("Accuracy", 8.5);
        stats.put("Noise", 100.0);
        stats.put("MagazineSize", 25.0);
        return stats;
    }

    @Override
    public String getDescription() {
        return "Vandal";
    }
}
