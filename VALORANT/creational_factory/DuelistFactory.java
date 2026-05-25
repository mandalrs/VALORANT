package creational_factory;

public class DuelistFactory extends AgentFactory {
    @Override
    public Agent createAgent() {
        return new Jett();
    }
}
