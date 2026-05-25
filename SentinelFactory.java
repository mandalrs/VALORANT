package creational_factory;

public class SentinelFactory extends AgentFactory {
    @Override
    public Agent createAgent() {
        return new Sage();
    }
}
