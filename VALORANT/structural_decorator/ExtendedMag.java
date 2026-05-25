package structural_decorator;

import java.util.Map;

public class ExtendedMag extends AttachmentDecorator {
    public ExtendedMag(IWeapon weapon) {
        super(weapon);
    }

    @Override
    public Map<String, Double> getStats() {
        Map<String, Double> stats = super.getStats();
        stats.put("MagazineSize", stats.get("MagazineSize") + 10.0);
        return stats;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Extended Mag";
    }
}
