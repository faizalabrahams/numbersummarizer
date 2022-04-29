package numberrangesummarizer.provider;

import java.util.*;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer{

    @Override
    public Collection<Integer> collect(String input) {
        // clean string
        input.replaceAll("\\s+", "");

        /// convert String to array of String
        String[] elements = input.split(",");

        /// list of sequential integers from String array
        List<Integer> intList = Arrays.stream(elements)
                .map(Integer::valueOf) // stream of Integer
                .sorted() // sort stream of string
                .collect(Collectors.toList());

        return intList;
    }


    @Override
    public String summarizeCollection(Collection<Integer> input) {

        // build responds
        StringBuilder sb = new StringBuilder();

        /// sequential list
        int[] arr = input.stream().sorted().mapToInt(i->i).toArray();

        int len = arr.length;
        int idx = 0, idx2 = 0;

        while (idx < len) {
            /// check if range
            /// if next position - 1 - current position = 1, then in range,
            /// increment idx2 to determine end of range
            while (++idx2 < len && arr[idx2] - arr[idx2 - 1] == 1);
               /// check if in range
                if (idx2 - idx > 2) {
                    /// build range set
                    sb.append( arr[idx] + "-" + arr[idx2 - 1]+",");
                    idx = idx2;
                } else {
                    /// if not in range append element
                    for (; idx < idx2; idx++)
                        sb.append(arr[idx]+",");
                }
        }

        /// check if last char is "," then trim
        StringBuffer sbs= new StringBuffer(sb.toString());
        if(sb.substring(sb.length() - 1).equals(","))
            sbs.deleteCharAt(sbs.length()-1);

        return sbs.toString();
    }
}
