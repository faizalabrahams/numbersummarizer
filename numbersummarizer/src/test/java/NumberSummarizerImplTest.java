package com.numberRangeSummarizer;

import numberrangesummarizer.provider.NumberRangeSummarizerImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberSummarizerImplTest {

    @Test
    public void testCollect(){
        NumberRangeSummarizerImpl test = new NumberRangeSummarizerImpl();
        String nums = "21,2,18,4,7,10,14,3,17,19,1";
        Collection<Integer> result =test.collect(nums);
        assertEquals(Arrays.asList(1-4,7,10,14,17-19,21),result);
    }

    @Test
    public void testSummarizedCollection(){
        NumberRangeSummarizerImpl test = new NumberRangeSummarizerImpl();
        Collection<Integer> listCollected =  Arrays.asList(10,30,40,1,2,3,4,5,7,8,9,200);
        String summarizedstr = test.summarizeCollection(listCollected);
        assertEquals("1-5,7-10,30,40,200",summarizedstr);
    }

}
