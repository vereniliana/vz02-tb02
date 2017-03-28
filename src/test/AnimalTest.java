package test;

import static org.junit.Assert.*;

import org.junit.Test;

import animal.*;

public class AnimalTest {

	@Test
	public void test_getSpecies() {
		System.out.println("Test if Species is true ...");
		Animal A = new Animal(Species.ELEPHANT, "elephant1", 2000, Sex.MALE, 4, 'h', 0.02, 0.02, 'E', 2, 2, 'l', 'l', false);
		assertTrue(A.getSpecies()==Species.ELEPHANT);
	}

}
