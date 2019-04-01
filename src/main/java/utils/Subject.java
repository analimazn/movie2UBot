package utils;

import java.util.Observer;

public interface Subject {
	public void registerObserver(Observer observer);
	public void notifyObservers(long chatId, String movieDatas);

}
