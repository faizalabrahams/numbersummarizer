package numberrangesummarizer.helper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Helper {

    private List<Integer> getNumbersUsingIntStreamRange(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    public static StringBuilder appendRange(StringBuilder sb, int start, int end) {
        sb.append(start);

        if(start++==end) {
            System.out.println("RANGE FOUND = "+ Integer.toString(end - start));
            sb.append(end - start > 1 ? " - " : ", ").append(end);
        }else{
            sb.append(end - start > 1 ? " - " : ", ").append(end);
        }

        return sb;
    }

    static boolean follows(String a, String b) {
        if (a.length() != b.length() && a.length() == 0) {
            return false;
        }
        // AAA -> BBB
        if (allSame(a) && allSame(b) && (b.charAt(0) - a.charAt(0) == 1)) {
            return true;
        }
        // ABC1 -> ABC2
        // finding common prefix
        int p = 0;
        while (p < a.length() && a.charAt(p) == b.charAt(p)) {
            ++p;
        }
        return (p == a.length() - 1) && (b.charAt(p) - a.charAt(p) == 1);
    }

    static boolean allSame(String chars) {
        char s = chars.charAt(0);
        return chars.chars().allMatch(c -> s == c);
    }

}
