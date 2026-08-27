import com.automation.utilities.ExcelUtility;
import org.testng.annotations.Test;

public class ExcelTest {

    @Test
    public void readExcelData() throws Exception {

        String filePath =
                "src/test/resources/testdata/TestData.xlsx";

        ExcelUtility excel =
                new ExcelUtility(
                        filePath,
                        "Sheet 1"
                );


        String username =
                excel.getData(
                        "TC001",
                        "Username"
                );

        String password =
                excel.getData(
                        "TC001",
                        "Password"
                );

        String firstName =
                excel.getData(
                        "TC001",
                        "FirstName"
                );

        String lastName =
                excel.getData(
                        "TC001",
                        "LastName"
                );

        String postalCode =
                excel.getData(
                        "TC001",
                        "PostalCode"
                );


        System.out.println(
                "Username: " + username
        );

        System.out.println(
                "Password: " + password
        );

        System.out.println(
                "First Name: " + firstName
        );

        System.out.println(
                "Last Name: " + lastName
        );

        System.out.println(
                "Postal Code: " + postalCode
        );


        excel.closeWorkbook();
    }
}