package com.example.ATS.validators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.ATS.validation.Rut;

import org.junit.jupiter.api.Test;

public class RutTests {

	@Test
	public void testValidRut() {
		String rut = "11.111.111-1";
		boolean result = Rut.isValid(rut);

		assertTrue(result);
	}

	@Test
	public void testValidRutShort() {
		String rut = "1-9";
		boolean result = Rut.isValid(rut);

		assertTrue(result);
	}

	@Test
	public void testInvalidRut() {
		String rut = "22.222.222-5";
		boolean result = Rut.isValid(rut);

		assertFalse(result);
	}

	@Test
	public void testInvalidRutLetter() {
		String rut = "a-5";
		boolean result = Rut.isValid(rut);

		assertFalse(result);
	}

	@Test
	public void testValidRutWithK() {
		String rut = "555.554-k";
		boolean result = Rut.isValid(rut);

		assertTrue(result);

	}
}
