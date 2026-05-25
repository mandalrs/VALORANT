# 🎯 Valorant Agent System — Java Design Patterns

A Java-based project that models the **Valorant** agent system using classic **Gang of Four design patterns**. This project demonstrates real-world application of the **Factory** and **Observer** patterns through agents, roles, and abilities from the popular tactical shooter.

---

## 📐 Design Patterns Used

### 🏭 Factory Pattern (`creational_factory`)
Agent creation is abstracted through role-specific factories, keeping instantiation logic separate from business logic.

| Factory             | Agents Created  |
|---------------------|-----------------|
| `DuelistFactory`    | Jett            |
| `SentinelFactory`   | Sage            |
| `ControllerFactory` | Brimstone        |

- `AgentFactory` — Abstract factory interface
- `DuelistFactory`, `SentinelFactory`, `ControllerFactory` — Concrete factories per role

### 👁️ Observer Pattern (`behavioural_observer`)
Agents implement the `IObserver` interface, allowing them to receive and react to in-game event notifications (e.g., round updates, ability triggers).

---

## 🗂️ Project Structure

```
Valorant/
├── Agent.java               # Abstract base class for all agents
├── AgentFactory.java        # Abstract factory interface
├── Jett.java                # Duelist agent
├── Sage.java                # Sentinel agent
├── Brimstone.java           # Controller agent
├── DuelistFactory.java      # Factory for Duelist agents
├── SentinelFactory.java     # Factory for Sentinel agents
├── ControllerFactory.java   # Factory for Controller agents
├── src/                     # Additional source files
└── VALORANT/                # Supporting resources
```

---

## 🧬 Class Overview

### `Agent` (Abstract)
```java
public abstract class Agent implements IObserver {
    protected String name;
    protected String role;
    protected List<String> abilities;

    public abstract void display();
    public abstract void update(String subjectName, String message);
}
```
Each agent has a **name**, **role**, and a list of **abilities**. The `update()` method is the observer callback triggered when a subject broadcasts an event.

### Agents
| Agent      | Role       | Abilities                            |
|------------|------------|--------------------------------------|
| `Jett`     | Duelist    | Cloudburst, Updraft, Tailwind, Blade Storm |
| `Sage`     | Sentinel   | Barrier Orb, Slow Orb, Heal Orb, Resurrection |
| `Brimstone`| Controller | Stim Beacon, Incendiary, Sky Smoke, Orbital Strike |

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or the JDK CLI

### Clone the Repository
```bash
git clone https://github.com/vedant273ed/Valorant.git
cd Valorant
```

### Compile
```bash
javac *.java
```

### Run
```bash
java Main
```
> Make sure a `Main.java` entry point exists, or invoke the factory/observer classes directly from your own driver class.

---

## 💡 Key Concepts Demonstrated

- **Abstraction** — `Agent` is abstract; concrete agents implement their own `display()` and `update()` logic.
- **Polymorphism** — All agents are handled via the `Agent` type, regardless of their specific class.
- **Encapsulation** — Agent construction is encapsulated within role-specific factories.
- **Open/Closed Principle** — New agents or roles can be added by creating new classes without modifying existing ones.

---

## 🔧 Extending the Project

Want to add a new agent? Here's how:

1. Create a new class extending `Agent` (e.g., `Reyna.java`)
2. Implement `display()` and `update()` methods
3. Add or reuse the appropriate role factory
4. Register the agent with any subjects using the observer pattern

---

## 📚 Learning Outcomes

This project is a great reference for understanding:
- How the **Factory Method** pattern decouples object creation from usage
- How the **Observer** pattern enables event-driven communication between objects
- How to model a real-world domain (a game's agent system) using OOP principles in Java

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

> *Inspired by Riot Games' Valorant. This is an educational project and is not affiliated with or endorsed by Riot Games.*
