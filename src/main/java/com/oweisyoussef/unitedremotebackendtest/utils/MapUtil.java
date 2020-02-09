package com.oweisyoussef.unitedremotebackendtest.utils;

import java.util.ArrayList;
import java.util.Map;


public class MapUtil {
    public static void addToList(Map<String, ArrayList<String>> items, String key, String value) {
        ArrayList<String> itemsList = items.get(key);

        // if list does not exist create it
        if (itemsList == null) {
            itemsList = new ArrayList<>();
            itemsList.add(value);
            items.put(key, itemsList);
        } else {
            // add if item is not already in list
            if (!itemsList.contains(value)) {
                itemsList.add(value);
            }
        }
    }
}
