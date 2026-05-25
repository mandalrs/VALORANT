package creational_factory;

import behavioural_observer.IObserver;
import java.util.List;

public abstract class Agent implements IObserver {

    protected String name;
    protected String role;
    protected List<String> abilities;

    public Agent(String name, String role, List<String> abilities) {
        this.name = name;
        this.role = role;
        this.abilities = abilities;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public abstract void display();

    @Override
    public abstract void update(String subjectName, String message);
}
