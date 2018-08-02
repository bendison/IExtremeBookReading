package me.ben;

import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Book> books = new HashSet<>();
        Scanner in = new Scanner(System.in);
        String s;

        while (in.hasNextLine()) {
            s = in.nextLine();
            if (s.isEmpty()) {
                break;
            }
            String[] a = s.split(" ");
            Book book = new Book(Integer.parseInt(a[0]), new HashSet<>(Arrays.asList(a).subList(1, a.length)));
            books.add(book);
        }

        Set<Set<Book>> combinationsOfBooks = Sets.powerSet(books);

        Set<String> allTheTopics = getTopicsFromCollection(books);

        Set<Book> shortestCombination = combinationsOfBooks.stream()
                .filter(c -> getTopicsFromCollection(c).size() == allTheTopics.size())
                .min(Comparator.comparingInt(o -> o.stream().mapToInt(Book::getReadTime).sum()))
                .orElse(new HashSet<>());

        System.out.println(shortestCombination.stream().mapToInt(Book::getReadTime).sum());
    }

    private static Set<String> getTopicsFromCollection(Set<Book> books) {
        return books.stream().flatMap(book -> book.getTopics().stream()).collect(Collectors.toSet());
    }
}
