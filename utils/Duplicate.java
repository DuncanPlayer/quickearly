package net.messi.early.utils;

import net.messi.early.pojo.NideshopCategory;

import java.util.HashSet;
import java.util.List;

public class Duplicate {

    /**
     * 类别去重
     *
     * @param list
     */
    public static void removeDuplicate(List<NideshopCategory> list) {
        HashSet<NideshopCategory> set = new HashSet<NideshopCategory>(list.size());
        set.addAll(list);
        list.clear();
        list.addAll(set);
    }
}
