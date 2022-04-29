package numberrangesummarizer;

import numberrangesummarizer.provider.NumberRangeSummarizerImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        NumberRangeSummarizerImpl numberRangeSummarizer = new NumberRangeSummarizerImpl();

        String input = "14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,37, 38, 39,0, 1, 2, 4, 6, 7, 8, 11, 12";

        try {

            if(input == null || input.isEmpty() || input.trim().isEmpty()){
                throw new NullPointerException("input is Required!");
            }

            String range = numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(input.replaceAll("\\s", "")));
            System.out.println(range);

        } catch (NumberFormatException exc) {
            System.out.println("invalid character - only numbers allowed!");
        }

    }

}

