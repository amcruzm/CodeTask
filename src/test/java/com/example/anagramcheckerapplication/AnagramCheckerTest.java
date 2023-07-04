package com.example.anagramcheckerapplication;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

public class AnagramCheckerTest {

    @Test
    public void testAreAnagrams() {
        try (MockedStatic<StringUtils> mockedStringUtils = Mockito.mockStatic(StringUtils.class)) {
            mockedStringUtils.when(() -> StringUtils.stripAccents(anyString())).thenAnswer(invocation -> invocation.getArgument(0));

            // Test case 1: Anagrams
            assertTrue(AnagramChecker.areAnagrams("listen", "silent"));

            // Test case 2: Not anagrams
            assertFalse(AnagramChecker.areAnagrams("hello", "world"));

            // Test case 3: Anagrams with different case and accents
            assertTrue(AnagramChecker.areAnagrams("épater", "Repetá"));

            // Test case 4: Anagrams with different case and accents
            assertTrue(AnagramChecker.areAnagrams("Öpáter", "rÖpetá"));
        }
    }
}
