

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;

public class ConversionDegrees {

    public static Integer fahrenheit_to_celsius(int temperatureF) {

        int temperatureC = (int) ((temperatureF - 32) / 1.8);
        return temperatureC;
    }

    public static Integer celsius_to_fahrenheit(int temperatureC) {

        int temperatureF = (int) ((temperatureC * 1.8) + 32);
        return temperatureF;
    }

    public static Integer celsius_to_kelvin(int temperatureC) {

        int temperatureK = (int) (temperatureC + 273.15);
        return temperatureK;
    }


    public static String temperature_to_Json(Temperature temperature) {

        String json = null;
        String json1 = null;
        String json2 = null;
        switch (temperature.getName()) {
            case "F":
                Temperature temperature1 = new Temperature("C", fahrenheit_to_celsius(temperature.getTemperature()));
                Temperature temperature2 = new Temperature("K", celsius_to_fahrenheit(temperature.getTemperature()));
                json = GSON.toJson(temperature1).replace("\"name\": \"C\",","\"C\":").replace(" \"temperature\": ","");
                json1 = GSON.toJson(temperature2).replace("\"name\": \"K\",","\"K\":").replace(" \"temperature\": ","");
                json+=json1;
                json2=json.replace("}{",",");
                //System.out.println(GSON.toJson(temperature2));
        }
        return json2;
    }

//        if(name == "C" & temperature == 26){
//            String json = "C26";
//            return json;
//        }else if(name == "K" & temperature == 299){
//            String json = "K299";
//            return json;
//        }else if(name == "F" & temperature == 79){
//            String json = "F79";
//            return json;
//        }else{
//            Temperature temperature1 = new Temperature(name, temperature);
//            String json = GSON.toJson(temperature1);
//            return json;
//        }
    //  }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

//        String json = temperature_to_Json("F",79);
//        System.out.println(json);
        Temperature temp = new Temperature("F", 15);
        String json = temperature_to_Json(temp);
        System.out.println(json);
        System.out.println(json.length());
//        GsonBuilder gsonBuilder=new GsonBuilder();
//        gsonBuilder.create().toJson(temp);
//        System.out.println(gsonBuilder);


        // Temperature temperature1 = GSON.fromJson(json,Temperature.class);
        //System.out.println(temperature1.getName());
        // System.out.println(temperature1.getTemperature());


//        Integer resC = fahrenheit_to_celsius(temperature1.getTemperature());
//        System.out.println(resC);//5
//        Integer resF = celsius_to_fahrenheit(resC);
//        System.out.println(resF);//41
//        Integer resK = celsius_to_kelvin(resC);
//        System.out.println(resK);//278

    }
}