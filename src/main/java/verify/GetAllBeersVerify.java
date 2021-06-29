package verify;

import java.util.Date;

public class GetAllBeersVerify {

    public static Boolean verifyBeforeAfterDate(Date date, String beforeAfter) {
        Date currentDate = new Date();
        if(beforeAfter.equalsIgnoreCase("before") && date.before(currentDate)){
            return true;
        }else if(beforeAfter.equalsIgnoreCase("after") && date.after(currentDate)){
            return true;
        }else
            return false;
    }

    public static Boolean verifyBeersWithAbvGrt(int abvGrtParam, double abvFromRes) {
        return abvFromRes > abvGrtParam;
    }

    public static Boolean verifyResultsPerPage(int expectedResultsPerPage, int actualResultsPerPage) {
        return expectedResultsPerPage == actualResultsPerPage;
    }

}
