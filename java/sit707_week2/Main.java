package sit707_week2;

public class Main {
    public static void main(String[] args) {

        // Officeworks registration test
        SeleniumOperations.officeworks_registration_page(
            "https://www.officeworks.com.au/app/identity/create-account"
        );

        // Selenium Practice Form test
        SeleniumOperations.selenium_practice_form(
            "https://www.techlistic.com/p/selenium-practice-form.html"
        );
    }
}