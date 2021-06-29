package api_client;

import io.restassured.response.Response;
import pojo.GetAllBeersResponse;
import utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class GetAllBeersClient {
    private List<GetAllBeersResponse> responseBeer;

    public GetAllBeersResponse[] getAllBeers(){
        Response response =
                given()
                        .get(Constants.baseUrl+Constants.getAllBeersPath);
        GetAllBeersResponse[] responseBody = response.as(GetAllBeersResponse[].class);
        responseBeer =  Arrays.stream(responseBody)
                .parallel().filter(Objects::nonNull).collect(Collectors.toList());

        responseBeer.listIterator().next().setStatusCode(response.statusCode());
        return responseBody;
    }

    public GetAllBeersResponse[] getAllBeersBrewedBeforeDate(String date){
        Response response =
                given()
                        .pathParam("beforeDate",date)
                        .get(Constants.baseUrl+Constants.getBrewedBeforeDatePath+"{beforeDate}");
        GetAllBeersResponse[] responseBody = response.as(GetAllBeersResponse[].class);
        responseBeer =  Arrays.stream(responseBody)
                .parallel().filter(Objects::nonNull).collect(Collectors.toList());

        responseBeer.listIterator().next().setStatusCode(response.statusCode());
        return responseBody;
    }

    public GetAllBeersResponse[] getAllBeersWithAbvGrt(int abv){
        Response response =
                given()
                        .pathParam("abvGrt",abv)
                        .get(Constants.baseUrl+Constants.getBeerAbvGrt+"{abvGrt}");
        GetAllBeersResponse[] responseBody = response.as(GetAllBeersResponse[].class);
        responseBeer =  Arrays.stream(responseBody)
                .parallel().filter(Objects::nonNull).collect(Collectors.toList());

        responseBeer.listIterator().next().setStatusCode(response.statusCode());
        return responseBody;
    }

    public List<GetAllBeersResponse> getAllBeersAllPagesWithAbvGrt(int abv){
        int resultSize;
        int pageNo = 0;
        int resultsPerPage = 80;
        GetAllBeersResponse[] responseBody;
        Response response;
        List<GetAllBeersResponse[]> tempList = new ArrayList<>();

        do{
            pageNo++;
            response =
                    given()
                            .pathParam("abvGrt", abv)
                            .pathParam("page", pageNo)
                            .pathParam("perPage", resultsPerPage)
                            .get(Constants.baseUrl + Constants.getBeerAbvGrt + "{abvGrt}&page={page}&per_page={perPage}");
            responseBody = response.as(GetAllBeersResponse[].class);

            responseBeer = Arrays.stream(responseBody)
                    .parallel().filter(Objects::nonNull).collect(Collectors.toList());

            tempList.add(responseBody);
            resultSize = responseBody.length;
            responseBeer.listIterator().next().setStatusCode(response.statusCode());
        }while (resultSize>=80);

        responseBeer = new ArrayList<>() ;

        for (var r : tempList){
            responseBeer.addAll(Arrays.stream(r).collect(Collectors.toList()));
        }
        return responseBeer;
    }

    public GetAllBeersResponse[] getAllBeersWithPagination(int pageNo, int resPerPage){
        Response response =
                given()
                        .pathParam("page",pageNo)
                        .pathParam("perPage",resPerPage)
                        .get(Constants.baseUrl+Constants.getBeerPagination+"{page}&per_page={perPage}");
        GetAllBeersResponse[] responseBody = response.as(GetAllBeersResponse[].class);
        List<GetAllBeersResponse> responseBeer =  Arrays.stream(responseBody)
                .parallel().filter(Objects::nonNull).collect(Collectors.toList());

        responseBeer.listIterator().next().setStatusCode(response.statusCode());
        return responseBody;
    }
}
