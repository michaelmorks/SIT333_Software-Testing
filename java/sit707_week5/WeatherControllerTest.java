package sit707_week5;

import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WeatherControllerTest {

    // -----------------------------
    // Student tests (5.1P)
    // -----------------------------
    @Test
    public void testStudentIdentity() {
        String studentId = "s224437209";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Michael Morks";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // -----------------------------
    // Temperature tests (5.1P)
    // -----------------------------
    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");
        WeatherController wController = WeatherController.getInstance();

        int nHours = wController.getTotalHours();
        double minTemperature = 1000;

        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
        }

        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
        wController.close();
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        WeatherController wController = WeatherController.getInstance();

        int nHours = wController.getTotalHours();
        double maxTemperature = -1;

        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
        }

        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
        wController.close();
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        WeatherController wController = WeatherController.getInstance();

        int nHours = wController.getTotalHours();
        double sumTemp = 0;

        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            sumTemp += temperatureVal;
        }

        double averageTemp = sumTemp / nHours;
        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
        wController.close();
    }

    // -----------------------------
    // Updated 5.2P/5.2C test
    // -----------------------------
    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        WeatherController wController = WeatherController.getInstance();

        // Inject a fixed clock for repeatable testing
        Clock fixedClock = Clock.fixed(
                Instant.parse("2026-03-11T12:00:00Z"), ZoneId.of("UTC")
        );
        wController.setClock(fixedClock);

        // Persist temperature
        String persistTime = wController.persistTemperature(10, 19.5);

        // Expected time using same fixed clock
        String expectedTime = LocalTime.now(fixedClock)
                .format(DateTimeFormatter.ofPattern("H:m:s"));

        Assert.assertEquals(expectedTime, persistTime);
        wController.close();
    }
}
