package ru.job4j.articles.service.generator;

import ru.job4j.articles.model.Article;
import ru.job4j.articles.model.Word;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomArticleGenerator implements ArticleGenerator {
    @Override
    public WeakReference<Article> generate(List<WeakReference<Word>> words) {
        var wordsCopy = new ArrayList<>(words);
        Collections.shuffle(wordsCopy);
        var content = wordsCopy.stream()
                .map(e -> {
                    StringBuilder builder = new StringBuilder();
                    if (e.enqueue()) {
                        builder.append(e.get().getValue());
                    }
                    return builder.toString();
        })
                .collect(Collectors.joining(" "));
        return new WeakReference<>(new Article(content));
    }
}
