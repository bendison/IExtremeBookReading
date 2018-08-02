package me.ben;

import java.util.Set;

public class Book {
    private int readTime;
    private Set<String> topics;

    public Book(int readTime, Set<String> topics) {
        this.readTime = readTime;
        this.topics = topics;
    }

    public int getReadTime() {
        return readTime;
    }

    public Set<String> getTopics() {
        return topics;
    }
}
