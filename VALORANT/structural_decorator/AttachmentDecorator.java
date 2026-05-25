package structural_decorator;

import java.util.Map;

public abstract class AttachmentDecorator implements IWeapon {

    protected IWeapon wrappedWeapon;

    public AttachmentDecorator(IWeapon weapon) {
        this.wrappedWeapon = weapon;
    }
    
    @Override
    public Map<String, Double> getStats() {
        return wrappedWeapon.getStats();
    }

    @Override
    public String getDescription() {
        return wrappedWeapon.getDescription();
    }
}
