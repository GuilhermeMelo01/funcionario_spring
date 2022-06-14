package br.com.whiz.service.validation.utils;

// Fonte: https://gist.github.com/adrianoluis/5043397d378ae506d87366abb0ab4e30
public class BR {

    private static final int[] weightSsn = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calculate(final String str, final int[] weight){
        int sum = 0;
        for (int i = str.length() - 1, digit; i >= 0; i--) {
            digit = Integer.parseInt(str.substring(i, i + 1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    public static boolean isValidCPF(final String ssn){
        if ((ssn == null) || (ssn.length() != 11) || ssn.matches(ssn.charAt(0) + "{11}")) return false;

        final int digit1 = calculate(ssn.substring(0,9), weightSsn);
        final int digit2 = calculate(ssn.substring(0,9) + digit1, weightSsn);
        return ssn.equals(ssn.substring(0,9) + Integer.toString(digit1) + Integer.toString(digit2));
    }
}
