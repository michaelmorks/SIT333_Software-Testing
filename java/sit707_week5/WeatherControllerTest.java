package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    // Shared variables for tests
    static WeatherController controller;
    static double minTemperature;
    static double maxTemperature;
    static double averageTemperature;

    /**
     * Student identity test
     */
    @Test
    public void testStudentIdentity() {
        String studentId = "s224437209";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    /**
     * Student name test
     */
    @Test
    public void testStudentName() {
        String studentName = "Michael Morks";
        Assert.assertNotNull("Student name is null", studentName);
    }

    /**
     * Arrange step – executed once before all tests
     */
    @BeforeClass
    public static void setup() {

        System.out.println("+++ Setup WeatherController +++");

        // Arrange
        controller = WeatherController.getInstance();

        int nHours = controller.getTotalHours();

        minTemperature = 1000;
        maxTemperature = -1;
        double sumTemp = 0;

        for (int i = 0; i < nHours; i++) {

            double temperatureVal = controller.getTemperatureForHour(i + 1);

            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }

            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }

            sumTemp += temperatureVal;
        }

        averageTemperature = sumTemp / nHours;
    }

    /**
     * Test minimum temperature
     */
    @Test
    public void testTemperatureMin() {

        System.out.println("+++ testTemperatureMin +++");

        // Act
        double controllerMin = controller.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals(minTemperature, controllerMin, 0.001);
    }

    /**
     * Test maximum temperature
     */
    @Test
    public void testTemperatureMax() {

        System.out.println("+++ testTemperatureMax +++");

        // Act
        double controllerMax = controller.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals(maxTemperature, controllerMax, 0.001);
    }

    /**
     * Test average temperature
     */
    @Test
    public void testTemperatureAverage() {

        System.out.println("+++ testTemperatureAverage +++");

        // Act
        double controllerAvg = controller.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals(averageTemperature, controllerAvg, 0.001);
    }

    /**
     * Cleanup – executed once after all tests
     */
    @AfterClass
    public static void cleanup() {

        System.out.println("+++ Closing WeatherController +++");

        controller.close();
    }

    /**
     * Persist test (for future task 5.3C)
     */
    @Test
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
//      System.out.println("+++ testTemperaturePersist +++");
//      
//      WeatherController wController = WeatherController.getInstance();
//      
//      String persistTime = wController.persistTemperature(10, 19.5);
//      String now = new SimpleDateFormat("H:m:s").format(new Date());
//      
//      Assert.assertTrue(persistTime.equals(now));
//      
//      wController.close();
    }
}
