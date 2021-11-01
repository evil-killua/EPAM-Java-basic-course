package by.grsu.сourse.task2.entity.impl;

import by.grsu.сourse.task2.entity.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Text implements Component {

    private static final Logger LOGGER = LoggerFactory.getLogger(Text.class);
    private List<Sentence> sentences;

    {
        sentences = new ArrayList<>();
    }

    public Text() {
    }

    public Text(List<Sentence> sentence) {
        this.sentences = sentence;
    }

    public Text(Sentence... sentence) {
        sentences.addAll(Arrays.asList(sentence));
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void setSentences(Sentence... sentence) {
        sentences.addAll(Arrays.asList(sentence));
    }

    public void addSentences(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public String print() {
        String result = "";
        for (Component sentence :
                sentences) {
            result += sentence.print() + " ";

        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences);
    }

    /*
    2.	Вывести все предложения заданного текста в порядке возрастания
    количества слов в каждом из них.
    */

    public Map<Sentence, Integer> task2() {
        Map<Sentence, Integer> map = new LinkedHashMap<>();
        LOGGER.info("map creation started");
        for (Sentence sentence :
                sentences) {
            map.put(sentence, sentence.getNumberOfWord());
        }
        LOGGER.info("created map {}", map);

        LOGGER.info("sort map");
        Map<Sentence, Integer> sorted =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Sentence sent :
                sorted.keySet()) {
            LOGGER.info("{}   |||   words: {}", sent.print(), sent.getNumberOfWord());
        }

        return sorted;
    }

}
