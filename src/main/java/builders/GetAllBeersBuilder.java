package builders;

import api_client.GetAllBeersClient;
import org.testng.Reporter;
import pojo.GetAllBeersResponse;

import java.util.*;
import java.util.stream.Collectors;

public class GetAllBeersBuilder {
    private GetAllBeersResponse response;

    GetAllBeersClient getAllBeersClient = new GetAllBeersClient();
    List<GetAllBeersResponse> newRes = Arrays.stream(getAllBeersClient.getAllBeers()).parallel()
            .collect(Collectors.toList());

    public GetAllBeersBuilder() {
        response = new GetAllBeersResponse();
    }

    public boolean filteredAttr(List<GetAllBeersResponse> filteredList) {
        filteredList = Arrays.stream(getAllBeersClient.getAllBeers()).parallel()
                .filter(newl -> newRes.stream()
                        .anyMatch(res ->
                                res.getId() != 0 &&
                                        res.getName() != null &&
                                        res.getDescription() != null &&
                                        res.getAbv() != 0))
                .collect(Collectors.toList());

        Map<Object, Object> filteredMap = new HashMap<>();

        for (var fl : filteredList) {
            filteredMap.put("ID", fl.getId());
            filteredMap.put("Name",fl.getName());
            filteredMap.put("Description",fl.getDescription());
            filteredMap.put("Abv",fl.getAbv());
            Reporter.log("ID: "+filteredMap.get("ID")+"\n"+
                    "Name: "+filteredMap.get("Name")+"\n"+
                    "Description: "+filteredMap.get("Description")+"\n"+
                    "Abv: "+filteredMap.get("Abv")+"\n", true);
        }
        return true;
    }
}
