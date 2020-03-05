package us.vicentini.hackerrank.java.ooprogramming;

import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/calculating-volume
 * https://www.hackerrank.com/challenges/calculating-volume/submissions/code/19211080
 * @author Shulander
 */
public class CalculatingVolume {

    public static void main(String[] args) {
        Do_Not_Terminate.forbidExit();
        try {
            Calculate cal = new Calculate();
            int T = cal.getINTVal();
            while (T-- > 0) {
                double volume = 0.0d;
                int ch = cal.getINTVal();
                if (ch == 1) {

                    int a = cal.getINTVal();
                    volume = Calculate.get_Vol().main(a);

                } else if (ch == 2) {

                    int l = cal.getINTVal();
                    int b = cal.getINTVal();
                    int h = cal.getINTVal();
                    volume = Calculate.get_Vol().main(l, b, h);

                } else if (ch == 3) {

                    double r = cal.getDoubleVal();
                    volume = Calculate.get_Vol().main(r);

                } else if (ch == 4) {

                    double r = cal.getDoubleVal();
                    double h = cal.getDoubleVal();
                    volume = Calculate.get_Vol().main(r, h);

                }
                cal.output.display(volume);
            }

        } catch (NumberFormatException e) {
            System.out.print(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }

    }
}

class Calculate {
    private static VolumeCalcualtor calculator;

    public Display output;
    private final Scanner in;

    public Calculate() {

        in = new Scanner(System.in);
        calculator = new VolumeCalcualtor();
        output = new Display();
    }

    public int getINTVal() throws IOException {
        int returnValue = in.nextInt();
        if (returnValue < 0) {
            throw new NumberFormatException("All the values must be positive");
        }
        return returnValue;
    }

    public double getDoubleVal() throws IOException {
        double returnValue = in.nextDouble();
        if (returnValue < 0) {
            throw new NumberFormatException("All the values must be positive");
        }
        return returnValue;
    }

    public static VolumeCalcualtor get_Vol() {
        return calculator;
    }
}

class Display {

    public Display() {
    }

    public void display(double volume) {
        System.out.println(String.format("%.3f", volume));
    }
}

class VolumeCalcualtor {

    public VolumeCalcualtor() {
    }

    public double main(int a) {
        return a * a * a;
    }

    public double main(double r) {
        return (Math.PI * r * r * r * 2) / 3;
    }

    public double main(double r, double h) {
        return Math.PI * r * r * h;
    }

    public double main(int l, int b, int h) {
        return l * b * h;
    }
}

/**
 * This class prevents the user from using System.exit(0) from terminating the
 * program abnormally.
 */
class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}//end of Do_Not_Terminate	

