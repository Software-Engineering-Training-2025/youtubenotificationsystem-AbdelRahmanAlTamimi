package org.example.subject;

import org.example.observer.Observer;
import java.util.*;

public class Channel implements Subject{
    private final String name;
    private final HashSet<Observer> subscribers = new HashSet<>();

    public Channel(String name) {
        this.name = name;
    }

    public void uploadVideo(String title) {
        // TODO: Notify all subscribers about new video
       String message = this.getName() + " uploaded a new video: " + title;
       this.notifyObservers(message);
    }

    @Override
    public void subscribe(Observer observer) {
        if (observer != null && !this.subscribers.contains(observer)) {
            this.subscribers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (subscribers.contains(observer)) {
            this.subscribers.remove(observer);
        }

    }

    @Override
    public void notifyObservers(String message) {
        // TODO: Notify subscribers
        for (Observer subcriber: this.subscribers){
            subcriber.update(message);
        }
    }

    public String getName() {
        return name;
    }

    public HashSet<Observer> getSubscribers() {
        return this.subscribers;
    }
}
