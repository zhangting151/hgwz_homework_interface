package qyweixin.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import qyweixin.beans.HttpTestStep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadFile {


    public static List<HttpTestStep> readYamls(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<HttpTestStep> data = mapper.readValue(
                new File(filepath),
                new TypeReference<List<HttpTestStep>>(){}
        );

        return data;
    }

    public static HttpTestStep readYaml(String filePath){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        HttpTestStep steps = new HttpTestStep();
        try {
            steps = mapper.readValue(new File(filePath), HttpTestStep.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return steps;
    }

}
