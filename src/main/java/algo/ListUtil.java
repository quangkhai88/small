package algo;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {


    public static final String LIST_NOT_NULL_MESSAGE = "Input List must be not null";

    public static final String SIZE_POSITIVE_MESSAGE = "Size must greater than Zero";


    public static List<List<Integer>> getSubList(List<Integer> list, Integer size) {

        validateParam(list, size);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sublist = null;

        for (int i = 0; i < list.size(); i = i + size) {

            int fromIndex = i;
            int toIndex = i + size >  list.size() ? list.size() : i+ size;

            sublist = list.subList(fromIndex, toIndex);
            result.add(sublist);
        }

        return result;
    }

    private static void validateParam(List<Integer> list, Integer size) {
        if (list == null)
            throw new IllegalArgumentException(LIST_NOT_NULL_MESSAGE);

        if (size <= 0)
            throw new IllegalArgumentException(SIZE_POSITIVE_MESSAGE);
    }


}
