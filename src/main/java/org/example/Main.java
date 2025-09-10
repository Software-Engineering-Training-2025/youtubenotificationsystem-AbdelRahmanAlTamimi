package org.example;


import org.example.observer.User;


public class Main {
    public static void main(String[] args) {


        ChannelService svc = new ChannelService();
        svc.createNewChannel("TechWorld");
        svc.createNewChannel("FoodiesUnite");

        User alice = new User("Alice");
        User bob   = new User("Bob");
        User charlie = new User("Charlie");

        svc.subscribeToChannel("TechWorld", alice);
        svc.subscribeToChannel("TechWorld", bob);

        svc.subscribeToChannel("FoodiesUnite", alice);
        svc.subscribeToChannel("FoodiesUnite", charlie);

        svc.upload("TechWorld", "Observer Pattern Explained");
        svc.upload("FoodiesUnite", "Best Pasta Recipe");
    }
}