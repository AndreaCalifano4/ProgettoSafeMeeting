package safemeeting.observer;

public interface Subject {

  public void registerObserver(Observer observer);

  public void removeObserver(Observer observer);

  public void notifyObserver();

  public Object getUpdate(Observer observer);
}
