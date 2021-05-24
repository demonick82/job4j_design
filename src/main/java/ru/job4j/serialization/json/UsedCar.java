package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.Arrays;

public class UsedCar {
    private final boolean carMove;
    private final int yearOfRelease;
    private final String brand;
    private final Engine engine;
    private final String[] replacementParts;

    public boolean isCarMove() {
        return carMove;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public String[] getReplacementParts() {
        return replacementParts;
    }

    public UsedCar(boolean carMove, int yearOfRelease, String brand, Engine engine, String... replacementParts) {
        this.carMove = carMove;
        this.yearOfRelease = yearOfRelease;
        this.brand = brand;
        this.engine = engine;
        this.replacementParts = replacementParts;
    }

    @Override
    public String toString() {
        return "UsedCar{"
                + "CarMove=" + carMove
                + ", yearOfRelease=" + yearOfRelease
                + ", brand='" + brand + '\''
                + ", engine=" + engine
                + ", replacementParts=" + Arrays.toString(replacementParts)
                + '}';
    }

    public static void main(String[] args) {
        final UsedCar usedCar = new UsedCar(true, 2002, "Opel", new Engine("GH34564", 2.0),
                "Oil", "brake pads");
        // serGson(usedCar);
        serJson(usedCar);
    }

    private static void serGson(UsedCar usedCar) {
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(usedCar));
        final String carJson =
                "{"
                        + "\"CarMove\":true,"
                        + "\"yearOfRelease\":2002,"
                        + "\"brand\":\"Opel\","
                        + "\"engine\":"
                        + "{"
                        + "\"SerialNumber\":\"GH34564\","
                        + "\"volume\":3.0"
                        + "},"
                        + "\"replacementParts\":"
                        + "[\"Engine\",\"headlights\"]"
                        + "}";
        final UsedCar modCar = gson.fromJson(carJson, UsedCar.class);
        System.out.println(modCar);
    }

    private static void serJson(UsedCar usedCar) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("car move", usedCar.isCarMove());
        jsonObject.put("year of release", usedCar.getYearOfRelease());
        jsonObject.put("brand ", usedCar.getBrand());
        jsonObject.put("engine  ", usedCar.getEngine());
        jsonObject.put("replacement parts", usedCar.getReplacementParts());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(usedCar).toString());
    }
}
