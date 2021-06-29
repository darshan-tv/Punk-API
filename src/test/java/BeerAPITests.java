import api_client.GetAllBeersClient;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pojo.GetAllBeersResponse;
import utils.DataFormatter;
import verify.GetAllBeersVerify;

import java.util.*;
import java.util.stream.Collectors;


public class BeerAPITests {

    @Test (groups = { "sanity" })
    public void getAllBeers_API_Is_Not_Broken() {
        GetAllBeersClient getAllBeersClient = new GetAllBeersClient();
        List<GetAllBeersResponse> newRes = Arrays.stream(getAllBeersClient.getAllBeers())
                .parallel().collect(Collectors.toList());

        Assert.assertEquals(newRes.listIterator().next().getStatusCode(), 200);
        Reporter.log("Get All Beers API end point is working", true);
    }

    @Test (groups = { "regression" })
    public void getAllBeers_Verify_Response() {
        GetAllBeersClient getAllBeersClient = new GetAllBeersClient();
        List<GetAllBeersResponse> newRes = Arrays.stream(getAllBeersClient.getAllBeers())
                .parallel().collect(Collectors.toList());

        Assert.assertEquals(newRes.listIterator().next().getStatusCode(), 200);
        for (var res: newRes) {
            Assert.assertTrue(res.getId()!=0);
            Assert.assertNotNull(res.getName());
            Assert.assertNotNull(res.getDescription());
            Assert.assertTrue(res.getAbv()!=0);
            Reporter.log("ID: "+res.getId()+"\nName: "+res.getName()+
                    "\nDescription: "+res.getDescription()+"\nAbv: "+res.getAbv()+"\n", true);
        }

    }

    @Test (groups = { "regression" })
    public void getAllBeers_Brewed_BeforeDate() {
        String beforeDate = "5/2007";
        Date date;
        GetAllBeersClient getAllBeersClient = new GetAllBeersClient();
        List<GetAllBeersResponse> newRes = Arrays.stream(getAllBeersClient.getAllBeersBrewedBeforeDate(beforeDate))
                .parallel().collect(Collectors.toList());

        for (var res: newRes) {
            date = DataFormatter.formatDate(res.getFirst_brewed());

            Assert.assertTrue(res.getId()!=0);
            Assert.assertNotNull(res.getName());
            Assert.assertNotNull(res.getDescription());
            Assert.assertTrue(res.getAbv()!=0);
            Assert.assertTrue(GetAllBeersVerify.verifyBeforeAfterDate(date, "before"));
            Reporter.log("ID: "+res.getId()+"\nBrewed Date: "+res.getFirst_brewed()+
                    "\nName: "+res.getName()+
                    "\nDescription: "+res.getDescription()+"\nAbv: "+res.getAbv()+"\n", true);
        }
        Assert.assertEquals(newRes.listIterator().next().getStatusCode(), 200);
        Assert.assertEquals(newRes.size(), 6);

    }

    @Test (groups = { "regression" })
    public void getBeers_With_AbvGrt_Limit_25() {
        int abvGrt = 6;
        GetAllBeersClient getAllBeersClient = new GetAllBeersClient();
        List<GetAllBeersResponse> newRes = Arrays.stream(getAllBeersClient.getAllBeersWithAbvGrt(abvGrt))
                .parallel().collect(Collectors.toList());

        for (var res: newRes) {
            Assert.assertTrue(res.getId()!=0);
            Assert.assertNotNull(res.getName());
            Assert.assertNotNull(res.getDescription());
            Assert.assertTrue(res.getAbv()!=0);
            Assert.assertTrue(GetAllBeersVerify.verifyBeersWithAbvGrt(6, res.getAbv()));
            Reporter.log("ID: "+res.getId()+
                    "\nName: "+res.getName()+
                    "\nDescription: "+res.getDescription()+"\nAbv: "+res.getAbv()+"\n", true);
        }
        Assert.assertEquals(newRes.listIterator().next().getStatusCode(), 200);
        Assert.assertEquals(newRes.size(), 25);

    }

    @Test (groups = { "regression" })
    public void getAllBeers_With_AbvGrt_AllPages() {
        int abvGrt = 6;

        GetAllBeersClient getAllBeersClient = new GetAllBeersClient();
        List<GetAllBeersResponse> newRes;

        newRes = getAllBeersClient.getAllBeersAllPagesWithAbvGrt(abvGrt).stream()
                .parallel().collect(Collectors.toList());

        for (var res: newRes) {
            Assert.assertTrue(res.getId()!=0);
            Assert.assertNotNull(res.getName());
            Assert.assertNotNull(res.getDescription());
            Assert.assertTrue(res.getAbv()!=0);
            Assert.assertTrue(GetAllBeersVerify.verifyBeersWithAbvGrt(6, res.getAbv()));
            Reporter.log("ID: "+res.getId()+
                    "\nName: "+res.getName()+
                    "\nDescription: "+res.getDescription()+"\nAbv: "+res.getAbv()+"\n", true);
        }
        Assert.assertEquals(newRes.listIterator().next().getStatusCode(), 200);
        Assert.assertEquals(newRes.size(), 215);

    }

    @Test (groups = { "regression" })
    public void getAllBeers_With_Pagination() {
        int pageNo = 2;
        int expectedPerPageResults = 5;
        GetAllBeersClient getAllBeersClient = new GetAllBeersClient();
        List<GetAllBeersResponse> newRes = Arrays.stream(getAllBeersClient.getAllBeersWithPagination(pageNo, expectedPerPageResults))
                .parallel().collect(Collectors.toList());
        int actualResultsPerPage = newRes.size();

        for (var res: newRes) {
            Assert.assertTrue(res.getId()!=0);
            Assert.assertNotNull(res.getName());
            Assert.assertNotNull(res.getDescription());
            Assert.assertTrue(res.getAbv()!=0);
            Assert.assertTrue(GetAllBeersVerify.verifyResultsPerPage(expectedPerPageResults, actualResultsPerPage));
            Reporter.log("ID: "+res.getId()+
                    "\nName: "+res.getName()+
                    "\nDescription: "+res.getDescription()+"\nAbv: "+res.getAbv()+"\n", true);
        }
        Assert.assertEquals(newRes.listIterator().next().getStatusCode(), 200);
        Assert.assertEquals(newRes.size(), 5);

    }
}
