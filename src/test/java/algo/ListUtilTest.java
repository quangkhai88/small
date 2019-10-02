package algo;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListUtilTest {


    private ListUtil listUtil;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public  void get_exeption_with_null_list_input() {

        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage(ListUtil.LIST_NOT_NULL_MESSAGE);

        List<Integer> list = null;
        Integer size = 3;
        listUtil.getSubList(list, size);

    }

    @Test
    public  void get_exeption_with_negative_size_input() {

        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage(ListUtil.SIZE_POSITIVE_MESSAGE);

        List<Integer> list = new ArrayList<>();
        Integer size = -3;
        listUtil.getSubList(list, size);

    }

    @Test
    public  void get_sublists_with_empty_list_input() {
        List<Integer> list = new ArrayList<>();
        Integer size = 5;
        List<List<Integer>> result = listUtil.getSubList(list, size);
        Assert.assertTrue(result.size() == 0);

    }

    @Test
    public  void sub_lists_with_different_size_simple_case() {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        Integer size = 2;

        List<List<Integer>> result = listUtil.getSubList(list, size);

        int expectedSize = 4;

        Assert.assertTrue(result.size() == expectedSize);

        Assert.assertEquals( Arrays.asList(1,2), result.get(0));
        Assert.assertEquals( Arrays.asList(3,4), result.get(1));
        Assert.assertEquals( Arrays.asList(5,6), result.get(2));
        Assert.assertEquals( Arrays.asList(7), result.get(3));
    }

    @Test
    public  void sublists_with_same_size_simple_case() {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Integer size = 2;

        List<List<Integer>> result = listUtil.getSubList(list, size);

        int expectedSize = 4;
        Assert.assertTrue(result.size() == expectedSize);

        Assert.assertEquals( Arrays.asList(1,2), result.get(0));
        Assert.assertEquals( Arrays.asList(3,4), result.get(1));
        Assert.assertEquals( Arrays.asList(5,6), result.get(2));
        Assert.assertEquals( Arrays.asList(7,8), result.get(3));
    }


    @Test
    public  void test_random_sublist() {

        Integer size = 2;
        Integer N = 1000;

        //init input List
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            list.add(r.nextInt());
        }

        List<List<Integer>> result = listUtil.getSubList(list, size);

        //Verify result size
        Integer expectedSublistNumber = N/size; //500
        Assert.assertTrue(result.size() == expectedSublistNumber);


        //verify a random sublist
        Integer indexSublist = r.nextInt(result.size()); // indexSublist < 500, for example: 150

        List<Integer> actualSubList     = result.get(indexSublist);
        List<Integer> expectedSublist   = Arrays.asList(list.get(indexSublist * 2),
                                                        list.get(indexSublist * 2 + 1));

        //System.out.println(indexSublist);
        //System.out.println("Expect:" + expectedSublist);
        //System.out.println("Actual:" + actualSubList);

        Assert.assertEquals(expectedSublist, actualSubList);
    }

}
