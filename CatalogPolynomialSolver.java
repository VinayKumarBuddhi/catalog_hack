import java.io.*;
import java.util.*;
import java.math.BigInteger;
import org.json.simple.*;
import org.json.simple.parser.*;

public class CatalogPolynomialSolver {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java CatalogPolynomialSolver <json_file_path>");
            System.out.println("Example: java CatalogPolynomialSolver testcase1.json");
            return;
        }
        
        String filename = args[0];
        
        try {
            // Read the JSON input file
            JSONParser parser = new JSONParser();
            JSONObject input = (JSONObject) parser.parse(new FileReader(filename));

            JSONObject keys = (JSONObject) input.get("keys");
            int n = Integer.parseInt(keys.get("n").toString());
            int k = Integer.parseInt(keys.get("k").toString()); // m + 1

            List<BigInteger> xList = new ArrayList<>();
            List<BigInteger> yList = new ArrayList<>();

            int count = 0;
            for (int i = 1; count < k && i <= 100; i++) {
                String key = String.valueOf(i);
                if (!input.containsKey(key)) continue;

                JSONObject point = (JSONObject) input.get(key);
                int base = Integer.parseInt(point.get("base").toString());
                String value = point.get("value").toString();

                BigInteger x = BigInteger.valueOf(i);
                BigInteger y = new BigInteger(value, base);

                xList.add(x);
                yList.add(y);
                count++;
            }

            // Use Lagrange Interpolation to calculate f(0)
            System.out.println("File: " + filename);
            System.out.println("n = " + n + ", k = " + k + " (degree = " + (k-1) + ")");
            System.out.println("Points used: " + xList.size());
            
            BigInteger result = lagrangeInterpolationAtZero(xList, yList);
            System.out.println("Constant term (C) = " + result);
            
        } catch (Exception e) {
            System.err.println("Error processing " + filename + ": " + e.getMessage());
        }
    }

    static BigInteger lagrangeInterpolationAtZero(List<BigInteger> x, List<BigInteger> y) {
        java.math.BigDecimal result = java.math.BigDecimal.ZERO;
        int k = x.size();

        for (int i = 0; i < k; i++) {
            java.math.BigDecimal numerator = java.math.BigDecimal.ONE;
            java.math.BigDecimal denominator = java.math.BigDecimal.ONE;

            for (int j = 0; j < k; j++) {
                if (i == j) continue;
                numerator = numerator.multiply(new java.math.BigDecimal(x.get(j)).negate()); // (0 - xj)
                denominator = denominator.multiply(new java.math.BigDecimal(x.get(i).subtract(x.get(j)))); // (xi - xj)
            }

            java.math.BigDecimal yVal = new java.math.BigDecimal(y.get(i));
            // Use higher precision division with more decimal places
            java.math.BigDecimal term = yVal.multiply(numerator).divide(denominator, 100, java.math.RoundingMode.HALF_UP);
            result = result.add(term);
        }

        // Round to nearest integer for final result
        return result.setScale(0, java.math.RoundingMode.HALF_UP).toBigInteger();
    }
}
