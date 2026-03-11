package sit707_week5;

import java.time.Clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class WeatherController {

    public static final int HOURS_PER_DAY = 3;

    private static WeatherController instance;

    // Clock for testing (default to system clock)
    private Clock clock = Clock.systemDefaultZone();

    // Initialise hourly temperatures
    private static double[] todaysHourlyTemperature = new double[HOURS_PER_DAY];

    // Private constructor
    private WeatherController() {
        System.out.println("Creating new weather controller.");

        // sleep a while to simulate a delay
        sleep(2 + new Random().nextInt(5));

        // Insert random temperatures
        Random random = new Random();
        for (int i = 0; i < HOURS_PER_DAY; i++) {
            todaysHourlyTemperature[i] = 1 + random.nextInt(30);
        }
        System.out.println(Arrays.toString(todaysHourlyTemperature));
    }

    // Singleton factory
    public static WeatherController getInstance() {
        if (instance == null) {
            instance = new WeatherController();
        }
        return instance;
    }

    // -----------------------------
    // Clock setter for testing
    // -----------------------------
    public void setClock(Clock clock) {
        this.clock = clock;
    }

    // -----------------------------
    // Temperature calculations
    // -----------------------------
    public double getTemperatureMinFromCache() {
        double minVal = 1000;
        for (double t : todaysHourlyTemperature) {
            if (minVal > t) minVal = t;
        }
        return minVal;
    }

    public double getTemperatureMaxFromCache() {
        double maxVal = -1;
        for (double t : todaysHourlyTemperature) {
            if (maxVal < t) maxVal = t;
        }
        return maxVal;
    }

    public double getTemperatureAverageFromCache() {
        double sum = 0;
        for (double t : todaysHourlyTemperature) sum += t;
        return sum / todaysHourlyTemperature.length;
    }

    public double getTemperatureForHour(int hour) {
        sleep(1 + new Random().nextInt(5));
        if (hour > todaysHourlyTemperature.length) {
            hour = 1 + new Random().nextInt(todaysHourlyTemperature.length);
        }
        return todaysHourlyTemperature[hour - 1];
    }

    // -----------------------------
    // Persist temperature with injected clock
    // -----------------------------
    public String persistTemperature(int hour, double temperature) {
        String savedTime = LocalTime.now(clock).format(DateTimeFormatter.ofPattern("H:m:s"));
        System.out.println("Temperature: " + temperature + " of hour: " + hour + ", saved at " + savedTime);

        sleep(1 + new Random().nextInt(2));
        return savedTime;
    }

    // -----------------------------
    // Other methods
    // -----------------------------
    public int getTotalHours() {
        return todaysHourlyTemperature.length;
    }

    public void close() {
        System.out.println("Closing weather controller.");
        instance = null;
        sleep(2 + new Random().nextInt(5));
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
