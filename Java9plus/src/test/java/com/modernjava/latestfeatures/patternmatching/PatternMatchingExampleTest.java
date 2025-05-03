package com.modernjava.latestfeatures.patternmatching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.modernjava.latestfeatures.patternmatching.PatternMatchingExample;

class PatternMatchingExampleTest {

     PatternMatchingExample patternMatchingExample
             = new PatternMatchingExample();

    @ParameterizedTest
    @MethodSource("input")
    void pattern(Object value, String expectedResult) {

        var output =  patternMatchingExample.pattern(value);
        assertEquals(expectedResult, output);
    }
    
    @ParameterizedTest
    @MethodSource("input")
    void patternUsingInstanceOf(Object value, String expectedResult) {

        var output =  patternMatchingExample.patternUsingInstanceOf(value);
        assertEquals(expectedResult, output);
    }
    
    @ParameterizedTest
    @MethodSource("input")
    void patternUsingSwitch(Object value, String expectedResult) {

        var output =  patternMatchingExample.patternUsingSwitch(value);
        assertEquals(expectedResult, output);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of("Dilip", "String of length:5"),
                Arguments.of(1, "Integer:1"),
                Arguments.of(null, "Not a String or Integer")
        );
    }

}