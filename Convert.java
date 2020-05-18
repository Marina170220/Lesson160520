package kompjuterIya.lesson160520;

import java.util.Scanner;

public class Convert implements Converter {

    @Override
    public void convertFromCToF(double c) {
        double f = 1.8 * (c + 32);
        System.out.println("Temperature is " + f + " Fahrenheit");
    }

    @Override
    public double convertFromFToC(double f) {
        double c = 0.8 * (f - 32);
        System.out.println("Temperature is " + c + " Celsius");
        return c;
    }

    @Override
    public void convertFromCToK(double c) {
        double k = c + 273.15;
        System.out.println("Temperature is " + k + " Kelvin");
    }

    @Override
    public double convertFromKToC(double k) {
        double c = k - 273.15;
        System.out.println("Temperature is " + c + " Celsius");
        return c;
    }

    public static void main(String[] args) {
        Convert convert = new Convert();

        String inputScale;
        String outputScale;
        double enteredTemperature;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имеющуюся шкалу температуры");
        inputScale = scanner.next();
        inputScale = inputScale.trim().toLowerCase();
        char firstLetterInInputScale = inputScale.charAt(0);

        System.out.println("Введите значение температуры");
        enteredTemperature = scanner.nextDouble();

        System.out.println("В какую шкалу необходимо перевести значение температуры?");
        outputScale = scanner.next();
        outputScale = outputScale.trim().toLowerCase();
        char firstLetterInOutputScale = outputScale.charAt(0);

        boolean inputC = firstLetterInInputScale == 'ц' || firstLetterInInputScale == 'c';
        boolean inputF = firstLetterInInputScale == 'ф' || firstLetterInInputScale == 'f';
        boolean inputK = firstLetterInInputScale == 'к' || firstLetterInInputScale == 'k';

        if (inputC) {
            switch (firstLetterInOutputScale) {
                case 'ф':
                case 'f':
                    convert.convertFromCToF(enteredTemperature);
                    break;
                case 'к':
                case 'k':
                    convert.convertFromCToK(enteredTemperature);
                    break;
                default:
                    System.out.println(enteredTemperature);
            }
        } else if (inputF) {
            switch (firstLetterInOutputScale) {
                case 'ц':
                case 'c':
                    convert.convertFromFToC(enteredTemperature);
                    break;
                case 'к':
                case 'k':
                    convert.convertFromCToK(convert.convertFromFToC(enteredTemperature));
                    break;
                default:
                    System.out.println(enteredTemperature);
            }
        } else if (inputK) {
            switch (firstLetterInOutputScale) {
                case 'ц':
                case 'c':
                    convert.convertFromKToC(enteredTemperature);
                    break;
                case 'ф':
                case 'f':
                    convert.convertFromCToF(convert.convertFromKToC(enteredTemperature));
                    break;
                default:
                    System.out.println(enteredTemperature);
            }
        }
    }
}

