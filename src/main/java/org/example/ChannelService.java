package org.example;

import org.example.subject.Channel;
import org.example.subject.Subject;
import org.example.observer.Observer;
import java.util.*;

public class ChannelService {
    private final Map<String, Channel> channels = new HashMap<>();

    public boolean createChannel(String name) {
        // TODO: implement
        if (name == null || channels.containsKey(name)) {
            return false;
        }

        Channel channel = new Channel(name);
        channels.put(name, channel);
        return true;
    }

    public boolean deleteChannel(String name) {
        if (!channels.containsKey(name)) {
            return false;
        }
        channels.remove(name);
        return true;
    }

    public Optional<Channel> getChannel(String name) {
        return Optional.ofNullable(channels.get(name));
    }

    public boolean subscribe(String channelName, Observer user) {
        if (channelName.isBlank() || !this.channels.containsKey(channelName) || user == null) {
            return false;
        }
        Channel channel = channels.get(channelName);
        channel.subscribe(user);
        return true;
    }

    public boolean unsubscribe(String channelName, Observer user) {
        if (channels.get(channelName).getSubscribers().contains(user)) {
            channels.get(channelName).unsubscribe(user);
            return true;
        }
        return false;

    }

    public boolean upload(String channelName, String videoTitle) {
        channels.get(channelName).uploadVideo(videoTitle);
        return true;
    }
}
