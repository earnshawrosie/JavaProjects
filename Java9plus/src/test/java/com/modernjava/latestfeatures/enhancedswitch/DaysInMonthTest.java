package com.modernjava.latestfeatures.enhancedswitch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Month;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.modernjava.latestfeatures.enhancedswitch.DaysInMonth;

class DaysInMonthTest {

    @ParameterizedTest
    @MethodSource("input")
    void getDays(Month month, int expectedNoOfDays) {
        int days = DaysInMonth.getDays(month, 2023);
        assertEquals(expectedNoOfDays, days);
    }
    
    @ParameterizedTest
    @MethodSource("input")
    void getDaysV2(Month month, int expectedNoOfDays) {
        int days = DaysInMonth.getDaysV2(month, 2023);
        assertEquals(expectedNoOfDays, days);
    }
    
    @ParameterizedTest
    @MethodSource("input")
    void getDaysV3(Month month, int expectedNoOfDays) {
        int days = DaysInMonth.getDaysV3(month, 2023);
        assertEquals(expectedNoOfDays, days);
    }
    
    @ParameterizedTest
    @MethodSource("input")
    void getDaysV4(Month month, int expectedNoOfDays) {
        int days = DaysInMonth.getDaysV4(month, 2023);
        assertEquals(expectedNoOfDays, days);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(Month.FEBRUARY, 28),
                Arguments.of(Month.SEPTEMBER, 30),
                Arguments.of(Month.JANUARY, 31)
        );
    }
}