package by.grsu.сourse.task2;

import by.grsu.сourse.task2.entity.impl.PunctuationMarkEnum;
import by.grsu.сourse.task2.entity.impl.Sentence;
import by.grsu.сourse.task2.entity.impl.Text;
import by.grsu.сourse.task2.entity.impl.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class TextTest {

    private static Text text = Main.parseText(Main.filePath1);
    private static Text text2 = Main.parseText(Main.filePath2);

    private static Map<Sentence, Integer> getSortedMap() {
        Map<Sentence, Integer> map = new LinkedHashMap<>();

        Sentence sentence1 = new Sentence(new Word("Table"), new Word("nay"),
                new Word("him"), new Word("jokes"), new Word("quick"), PunctuationMarkEnum.QUESTION);

        Sentence sentence2 = new Sentence(new Word("Abode"), new Word("never"),
                new Word("think"), new Word("to"), new Word("at"), PunctuationMarkEnum.POINT);

        Sentence sentence3 = new Sentence(new Word("Over"), new Word("fact"),
                new Word("all"), PunctuationMarkEnum.COMMA, new Word("son"),
                new Word("tell"), new Word("this"), new Word("any"),
                new Word("his"), PunctuationMarkEnum.POINT);

        Sentence sentence4 = new Sentence(new Word("Keeps"), new Word("order"),
                new Word("fully"), new Word("so"),
                new Word("do"), new Word("party"), new Word("means"),
                new Word("young"), PunctuationMarkEnum.POINT);

        Sentence sentence5 = new Sentence(new Word("In"), new Word("felicity"),
                new Word("up"), new Word("to"),
                new Word("graceful"), new Word("mistaken"), new Word("horrible"),
                new Word("consider"), PunctuationMarkEnum.POINT);

        Sentence sentence6 = new Sentence(new Word("On"), new Word("in"),
                new Word("green"), new Word("taken"),
                new Word("do"), new Word("offer"), new Word("witty"),
                new Word("of"), PunctuationMarkEnum.QUESTION);

        Sentence sentence7 = new Sentence(new Word("No"), new Word("insisted"), PunctuationMarkEnum.COMMA,
                new Word("confined"), new Word("of"), new Word("weddings"),
                new Word("to"), new Word("returned"), new Word("to"),
                new Word("debating"), new Word("rendered"), PunctuationMarkEnum.EXCLAMATORY);

        Sentence sentence8 = new Sentence(new Word("So"), new Word("additions"),
                new Word("necessary"), PunctuationMarkEnum.COMMA, new Word("concluded"),
                new Word("it"), new Word("happiness"), new Word("do"), new Word("on"),
                new Word("certainly"), new Word("propriety"), PunctuationMarkEnum.POINT);

        map.put(sentence1, 5);
        map.put(sentence2, 5);
        map.put(sentence3, 8);
        map.put(sentence4, 8);
        map.put(sentence5, 8);
        map.put(sentence6, 8);
        map.put(sentence7, 10);
        map.put(sentence8, 10);

        return map;
    }

    private static Map<Sentence, Integer> getSortedMap2() {
        Map<Sentence, Integer> map = new LinkedHashMap<>();

        Sentence sentence1 = new Sentence(new Word("Table"), new Word("nay"),
                new Word("him"), new Word("jokes"), new Word("quick"), PunctuationMarkEnum.QUESTION);

        Sentence sentence2 = new Sentence(new Word("Over"), new Word("fact"),
                new Word("all"), PunctuationMarkEnum.COMMA, new Word("son"),
                new Word("tell"), new Word("this"), new Word("any"),
                new Word("his"), PunctuationMarkEnum.POINT);

        Sentence sentence3 = new Sentence(new Word("So"), new Word("additions"),
                new Word("necessary"), PunctuationMarkEnum.COMMA, new Word("concluded"),
                new Word("it"), new Word("happiness"), new Word("do"), new Word("on"),
                new Word("certainly"), new Word("propriety"), PunctuationMarkEnum.POINT);

        map.put(sentence1, 5);
        map.put(sentence2, 8);
        map.put(sentence3, 10);

        return map;
    }


    @Test
    void task2Test() {
        Text textMock = spy(new Text());

        Map<Sentence, Integer> sortedMap = getSortedMap();

        when(textMock.task2()).thenReturn(sortedMap);

        Assertions.assertTrue(text.task2().equals(textMock.task2()));

    }

    @Test
    void task2BySortedMapTest() {
        Text textMock2 = spy(new Text());

        Map<Sentence, Integer> sortedMap2 = getSortedMap2();

        when(textMock2.task2()).thenReturn(sortedMap2);
        Assertions.assertTrue(text2.task2().equals(textMock2.task2()));

    }


}