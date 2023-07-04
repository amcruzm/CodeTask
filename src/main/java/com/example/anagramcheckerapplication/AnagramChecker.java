package com.example.anagramcheckerapplication;

import org.apache.commons.lang3.StringUtils;

import java.text.Collator;
import java.text.Normalizer;
import java.util.Locale;

public class AnagramChecker {

    public static boolean areAnagrams(String text1, String text2) {
        String sortedText1 = normalizeAndSort(text1.toLowerCase());
        String sortedText2 = normalizeAndSort(text2.toLowerCase());

        return sortedText1.equals(sortedText2);
    }

    private static String normalizeAndSort(String text) {
        Collator collator = Collator.getInstance(Locale.US);
        collator.setDecomposition(Collator.CANONICAL_DECOMPOSITION);
        collator.setStrength(Collator.PRIMARY);

        return collator
                .compare(StringUtils.stripAccents(text), StringUtils.EMPTY) == 0
                ? text
                : Normalizer
                .normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}