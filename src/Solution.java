import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete a seguite funcao para que a mesma devolva todos os numeros
     * de 4 digitos, onde cada um sera menor ou igual a <maxDigit>,
     * e a soma de como resultado 21
     * Exemplos com maxDigit=6: 3666, 4566...
     *
     * Caso nao encontrar nenhum devolver null.
     */
    public static List<Integer> calculation(int maxDigit) {
        int maxValue = maxDigit + (maxDigit * 10) + (maxDigit * 100) + (maxDigit * 1000);

        return checkTwentyOne(maxValue, maxDigit);
    }


    private static List<Integer> checkTwentyOne(int maxValue, int maxDigit){
        int minValue = 1000;
        List<Integer> listSumTwentyOne = new ArrayList<>();
        for (int i=minValue ; i<= maxValue; i++){
            Integer value = splitTextSum(i, maxDigit);
            if (value != null) {
                listSumTwentyOne.add(value);
            }
        }
        if(listSumTwentyOne.isEmpty()) {
            return null;
        }
        return listSumTwentyOne;
    }

    private static Integer splitTextSum(int value, int maxDigit){
        String[] valueString = Integer.toString(value).split("");

        if (Integer.parseInt(valueString[0]) <= maxDigit && Integer.parseInt(valueString[1]) <= maxDigit &&
                Integer.parseInt(valueString[2]) <= maxDigit && Integer.parseInt(valueString[3]) <=maxDigit) {

            int sum = Integer.parseInt(valueString[0]) + Integer.parseInt(valueString[1]) +
                    Integer.parseInt(valueString[2]) + Integer.parseInt(valueString[3]);

            if (sum == 21) {
                return value;
            }
        }
        return null;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int maxDigit = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.calculation(maxDigit);

        System.out.println(result);

        bufferedReader.close();
    }
}
