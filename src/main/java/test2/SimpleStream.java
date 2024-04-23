package test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStream<T> {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        SimpleStream.of(list)
                .filter(x -> (x & 1) == 1)
                .map(x->x * x)
                .forEach(System.out::println);


    }

    public static <T> SimpleStream<T> of(Collection<T> collection) {
        return new SimpleStream<>(collection);
    }

//    private Collection<T> collection;
//
//    public SimpleStream(Collection<T> collection) {
//        this.collection = collection;
//    }
    private Collection<T> collection;

    private SimpleStream(Collection<T> collection) {
        this.collection = collection;
    }

    public  SimpleStream<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : collection) {
            if(predicate.test(t)){
                result.add(t);
            }
        }
        return new SimpleStream<>(result);
    }

    public <U> SimpleStream<U> map(Function<T,U> function) {
        ArrayList<U> result = new ArrayList<>();
        for (T t : collection) {
            U u = function.apply(t);
            result.add(u);
        }

        return new SimpleStream<>(result);
    }

    public void forEach(Consumer<T> consumer) {
        for (T t : collection) {
            consumer.accept(t);
        }
    }
}