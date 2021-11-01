package by.grsu.сourse.task2;

import by.grsu.сourse.task2.entity.impl.PunctuationMarkEnum;
import by.grsu.сourse.task2.entity.impl.Sentence;
import by.grsu.сourse.task2.entity.impl.Text;
import by.grsu.сourse.task2.entity.impl.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.BreakIterator;
import java.util.*;

public class Main {

    public static final String filePath1 = ".\\src\\main\\resources\\text.txt";
    public static final String filePath2 = ".\\src\\main\\resources\\text2.txt";

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Text text = parseText(filePath1);

        LOGGER.info("full text {}", text.print());

        text.task2();

    }

    public static Text parseText(String path) {

        String text = getText(path);

        List<String> sentenceList = getSentence(text);

        List<Sentence> sentences = parseSentenceToWordAndPunctuationMark(sentenceList);

        Text fullText = new Text(sentences);

        return fullText;
    }


    private static String getText(String path) {
        File file = new File(path);
        String text = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            LOGGER.info("start read file");
            String st;

            while ((st = br.readLine()) != null) {
                text = text + st;
            }

            LOGGER.info("end of reading");
        } catch (IOException e) {
            LOGGER.warn("read error");
            e.printStackTrace();
        }

        return text;
    }

    private static List<String> getSentence(String text) {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(text);

        List<String> sentenceList = new ArrayList<>();
        int start = iterator.first();
        LOGGER.info("start parse text to sentence");

        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {

            String sentence = text.substring(start, end);

            sentenceList.add(sentence);
        }

        LOGGER.info("end of parse");
        return sentenceList;
    }

    private static List<Sentence> parseSentenceToWordAndPunctuationMark(List<String> sentenceList) {
        List<Sentence> sentences = new ArrayList<>();

        LOGGER.info("start parse sentence to word and punctuation mark");
        for (String sent : sentenceList) {
            StringTokenizer str = new StringTokenizer(sent, ", !?.", true);
            Sentence sentence = new Sentence();

            while (str.hasMoreElements()) {
                String component = String.valueOf(str.nextElement());

                if (component.equals(" ")) {
                    continue;
                }

                for (PunctuationMarkEnum punctuation : PunctuationMarkEnum.values()) {
                    if (component.equals(punctuation.getValue())) {

                        sentence.addComponent(punctuation);
                        break;
                    }

                    if (PunctuationMarkEnum.EXCLAMATORY.equals(punctuation)) {
                        Word word = new Word(component);
                        sentence.addComponent(word);
                    }
                }

            }

            sentences.add(sentence);
        }
        LOGGER.info("end of parse");

        return sentences;
    }


}
