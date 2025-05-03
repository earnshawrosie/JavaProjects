package com.modernjava.latestfeatures.patternmatching.recordmatch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.modernjava.latestfeatures.patternmatching.recordmatch.Animal;
import com.modernjava.latestfeatures.patternmatching.recordmatch.AnimalService;
import com.modernjava.latestfeatures.patternmatching.recordmatch.Cat;
import com.modernjava.latestfeatures.patternmatching.recordmatch.Dog;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalServiceTest {

    AnimalService animalService = new AnimalService();

    @ParameterizedTest()
    @MethodSource("input")
    void retrieveName(Animal animal, String expectedResult) {
        var name = animalService.retrieveName(animal);
        assertEquals(expectedResult, name);
    }
    
    @ParameterizedTest()
    @MethodSource("input")
    void retrieveNameV2(Animal animal, String expectedResult) {
        var name = animalService.retrieveName(animal);
        assertEquals(expectedResult, name);
    }
    
    @Test
    void retrieveNameGuarded() {
        var name = animalService.retrieveNameUsingGuarded(new Cat(null, "Black"));
        assertEquals("", name);
    }

    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(new Cat("Kitty", "Black"), "Kitty"),
                Arguments.of(new Dog("Scooby", "Black"), "Scooby"),
                Arguments.of(null, "")
        );
    }
}