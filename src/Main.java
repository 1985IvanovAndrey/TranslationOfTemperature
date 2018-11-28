import netscape.javascript.JSObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        int temp = 10;
        double tempNew1 = 0;
        double tempNew2 = 0;

        String json;

        String shkala = "F";

        switch (shkala) {

            case "K":
                tempNew1 = temp - 273.15;
                double newDouble1 = new BigDecimal(tempNew1).setScale(2, RoundingMode.UP).doubleValue();
                tempNew2 = (temp - 273.15) * 9 / 5 + 32;
                double newDouble2 = new BigDecimal(tempNew2).setScale(2, RoundingMode.UP).doubleValue();
                json = "{\"C\":\"" + newDouble1 + "\"," + "\"F\":\"" + newDouble2 + "\"}";
                System.out.println(json);
                break;
            case "C":
                tempNew1 = (temp * 9 / 5) + 32;
                double newDouble3 = new BigDecimal(tempNew1).setScale(2, RoundingMode.UP).doubleValue();
                tempNew2 = temp + 273.15;
                double newDouble4 = new BigDecimal(tempNew2).setScale(2, RoundingMode.UP).doubleValue();
                json = "{\"F\":\"" + newDouble3 + "\"," + "\"K\":\"" + newDouble4 + "\"}";
                System.out.println(json);
                break;
            case "F":
                tempNew1 = (temp - 32) * 5 / 9;
                double newDouble5 = new BigDecimal(tempNew1).setScale(2, RoundingMode.UP).doubleValue();
                tempNew2 = (temp - 32) * 5 / 9 + 273.15;
                double newDouble6 = new BigDecimal(tempNew2).setScale(2, RoundingMode.UP).doubleValue();
                json = "{\"C\":\"" + newDouble5 + "\"," + "\"K\":\"" + newDouble6 + "\"}";
                System.out.println(json);
                break;
            default:
                System.out.println("Неверно введена шкала!");

        }
    }
}