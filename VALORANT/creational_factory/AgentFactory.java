package creational_factory;

public abstract class AgentFactory {

    public abstract Agent createAgent();

    public Agent spawnAgent() {
        System.out.printf("\n[FactoryMethod] Using %s...%n", this.getClass().getSimpleName());
        Agent agent = createAgent();
        return agent;
    }
}
