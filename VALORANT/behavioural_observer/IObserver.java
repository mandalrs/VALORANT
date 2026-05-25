package behavioural_observer;

public interface IObserver {
    void update(String subjectName, String message);
    String getName(); 
}
