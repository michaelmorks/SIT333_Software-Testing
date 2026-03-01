package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s22443702";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Michael Morks";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1,1, 2024);
		System.out.println("January Min increment > " + date);
		date.increment();
		System.out.println(date);
		
		Assert.assertEquals(2,  date.getDay());
		Assert.assertEquals(1, date.getMonth());

	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
	    DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("January min decrement > " + date);
	    date.decrement();
	    System.out.println(date);

	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	@Test
	public void testMinJune1ShouldDecrementToMay31() {
	    DateUtil date = new DateUtil(1, 6, 2024);
	    date.decrement();

	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}
	
	@Test
	public void testMaxJune30ShouldIncrementToJuly1() {
	    DateUtil date = new DateUtil(30, 6, 2024);
	    date.increment();

	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	}
	
	//Nprmal Month class
	
	@Test
	public void testNormalDayIncrement() {
	    DateUtil date = new DateUtil(15, 3, 2024); // March
	    date.increment();

	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}
	
	// leap Year class
	
	@Test
	public void testFeb29LeapYearShouldGoToMarch1() {
	    DateUtil date = new DateUtil(29, 2, 2024); // 2024 is leap year
	    date.increment();

	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}
	

	
}
