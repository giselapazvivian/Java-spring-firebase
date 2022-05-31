package com.example.ATS.validation;

public class Rut {
    public static boolean isValid(String rut) {
        // Para que @NotBlank se encargue de esto
        if (rut == null || "".equals(rut)) {
            return true;
        }

        rut = rut.toUpperCase().replaceAll("[.-]", "");

        try {
            char dv = rut.charAt(rut.length() - 1);
            rut = rut.substring(0, rut.length() - 1);

            int intRut = Integer.parseInt(rut);
            return isValidRut(intRut, dv);
        } catch (NumberFormatException e) {
            return false;
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static boolean isValidRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
}