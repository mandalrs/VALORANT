package creational_factory;

public class ControllerFactory extends AgentFactory {
    @Override
    public Agent createAgent() {
        return new Brimstone();
    }
}
