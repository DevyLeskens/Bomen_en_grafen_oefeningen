import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if (getal <= 0) {
            throw new IllegalArgumentException();
        }
        if (getal <= 2) {
            return 1;
        }
        return fibonacci(getal - 1) + fibonacci(getal - 2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        getal = Math.abs(getal);
        int sum = getal % 10;

        if (getal < 10) {
            return sum;
        } else {
            return sum + somVanCijfers(getal / 10);
        }
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.isBlank()) return "";

        String nieuw = "";
        return nieuw += s.substring(s.length() - 1) + keerOm(s.substring(0, s.length() - 1));
    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 0) {
            return 0;
        }
        return (s.charAt(0) == 'x' ? 1 : 0) + countX(s.substring(1));

        /* if (s.charAt(0) != 'x') {
            return countX(s.substring(1));
        } else {
            return 1 + countX(s.substring(1));
        } */
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 1) {
            return 0;
        }
        return (s.substring(0, 2).equals("hi") ? 1 : 0) + countHi(s.substring(1));

       /* if (s.substring(0, 2).equals("hi")) {
            return 1 + countHi(s.substring(1));
        } else {
            return countHi(s.substring(1));
        } */
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s == null) throw new IllegalArgumentException();
        return null;
    }

    // oefening 7

    public static String changePi(String s) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 8:
    public static int tweelog(int getal) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}