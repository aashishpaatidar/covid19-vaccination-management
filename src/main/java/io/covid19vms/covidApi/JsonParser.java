package io.covid19vms.covidApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

@Component
public class JsonParser implements CovidDataMapper {
    private static HashMap<String, StateData> jsonData;

    @Override
    public HashMap<String, StateData> jsonDataMapperApi() {
        return jsonData;
    }

    @PostConstruct
    public void jsonParser() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, StateData.class);
        jsonData = mapper.readValue(new URL("https://api.covid19india.org/state_district_wise.json"), mapType);
    }
}
