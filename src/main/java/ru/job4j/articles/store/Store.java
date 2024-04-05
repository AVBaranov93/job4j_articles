package ru.job4j.articles.store;

import java.lang.ref.WeakReference;
import java.util.List;

public interface Store<T> {
    T save(T model);
    List<WeakReference<T>> findAll();
}
