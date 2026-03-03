package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
	    String studentId = "s22443702"; // <- student ID
	    Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
	    String studentName = "Michael Morks"; // <- name
	    Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	
	// ---------------- Decision Table Tests ----------------

    // R1 – Empty username, empty password
    @Test
    public void testR1_EmptyUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    // R2 – Empty username, wrong password
    @Test
    public void testR2_EmptyUsernameWrongPassword() {
        LoginStatus status = LoginForm.login(null, "xyz");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // R3 – Empty username, correct password
    @Test
    public void testR3_EmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // R4 – Wrong username, empty password
    @Test
    public void testR4_WrongUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("abc", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    // R5 – Wrong username, wrong password
    @Test
    public void testR5_WrongUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // R6 – Wrong username, correct password
    @Test
    public void testR6_WrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // R7 – Correct username, empty password
    @Test
    public void testR7_CorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
    }

    // R8 – Correct username, wrong password
    @Test
    public void testR8_CorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
    }

    // R9 – Correct login, empty validation code
    @Test
    public void testR9_CorrectLoginEmptyCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean codeValid = LoginForm.validateCode(null);
        Assert.assertFalse(codeValid);
    }

    // R10 – Correct login, wrong validation code
    @Test
    public void testR10_CorrectLoginWrongCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean codeValid = LoginForm.validateCode("abcd");
        Assert.assertFalse(codeValid);
    }

    // R11 – Correct login, correct validation code
    @Test
    public void testR11_CorrectLoginCorrectCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        // From Main.java, correct code is "123456"
        boolean codeValid = LoginForm.validateCode("123456");
        Assert.assertTrue(codeValid);
    }
}
