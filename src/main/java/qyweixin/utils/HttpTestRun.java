package qyweixin.utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import qyweixin.beans.HttpTestStep;
import qyweixin.beans.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static qyweixin.qyapi.QiYeWeiXin.logger;

public class HttpTestRun {

    public static void runWithToken(List<HttpTestStep> testcase, String token) {

        //构造RequestSpecification
        for (HttpTestStep step : testcase) {
            System.out.println(step.when.getUrl());
            RequestSpecification requestSpecification = given();

            Item[] params = step.given.getParams();
            if (params.length > 0){
                Map<String, Object> paramsMap = new HashMap<String, Object>();
                for (int i = 0; i < params.length; i++) {
                    paramsMap.put(params[i].getKey(), params[i].getValue());
                }requestSpecification.params(paramsMap);
            }


            Item[] headers = step.given.getHeaders();
            if (headers.length > 0){
                Map<String, Object> headersMap = new HashMap<String, Object>();
                for (int i = 0; i < headers.length; i++) {
                    headersMap.put(headers[i].getKey(), headers[i].getValue());
                }
                requestSpecification.headers(headersMap);
            }

            //构造ResponseSpecBuilder
            ResponseSpecBuilder builder = new ResponseSpecBuilder();
            builder.expectStatusCode(step.then.getStatusCode());

            //这里处理的下body 支持hasItems、equalTo等验证
            Item[] bodys = step.then.getBody();
            if (bodys.length > 0){
                Map<String, Object> bodysMap = new HashMap<String, Object>();
                for (int i = 0; i < bodys.length; i++) {
                    String expect = bodys[i].getValue().toString();
                    System.out.println(expect);
                    String value = expect.split(" ")[1];

                    if (expect.startsWith("equalTo")){
                        builder.expectBody(bodys[i].getKey(), equalTo(Integer.parseInt(value)));
                    }else if(expect.startsWith("hasItems")){
                        builder.expectBody(bodys[i].getKey(), hasItems(value));
                    }else if (expect.startsWith("notHasItems")){
                        builder.expectBody(bodys[i].getKey(), not(hasItems(value)));
                    }
                }
            }

            //实际发送请求
            if ("get" == step.when.getRequest()) {
                given().spec(requestSpecification).log().all()
                        .when().get(step.when.getUrl() + token)
                        .then().log().all().spec(builder.build());
            } else {
                given().spec(requestSpecification).log().all()
                        .when().post(step.when.getUrl() + token)
                        .then().log().all().spec(builder.build());
            }


        }
    }

    public static void runWithToken(HttpTestStep testcase, String token) {

        //构造RequestSpecification
            //System.out.println(testcase.when.getUrl());
            logger.info(testcase.description);
            RequestSpecification requestSpecification = given();

            Item[] params = testcase.given.getParams();
            if (params.length > 0){
                Map<String, Object> paramsMap = new HashMap<String, Object>();
                for (int i = 0; i < params.length; i++) {
                    paramsMap.put(params[i].getKey(), params[i].getValue());
                }requestSpecification.params(paramsMap);
            }


            Item[] headers = testcase.given.getHeaders();
            if (headers.length > 0){
                Map<String, Object> headersMap = new HashMap<String, Object>();
                for (int i = 0; i < headers.length; i++) {
                    headersMap.put(headers[i].getKey(), headers[i].getValue());
                }
                requestSpecification.headers(headersMap);
            }

            //构造ResponseSpecBuilder
            ResponseSpecBuilder builder = new ResponseSpecBuilder();
            builder.expectStatusCode(testcase.then.getStatusCode());

            //这里处理的下body 支持hasItems、equalTo等验证
            Item[] bodys = testcase.then.getBody();
            if (bodys.length > 0){
                Map<String, Object> bodysMap = new HashMap<String, Object>();
                for (int i = 0; i < bodys.length; i++) {
                    String expect = bodys[i].getValue().toString();
                    String value = expect.split(" ")[1];

                    if (expect.startsWith("equalTo")){
                        builder.expectBody(bodys[i].getKey(), equalTo(Integer.parseInt(value)));
                    }else if(expect.startsWith("hasItems")){
                        builder.expectBody(bodys[i].getKey(), hasItems(value));
                    }else if (expect.startsWith("notHasItems")){
                        builder.expectBody(bodys[i].getKey(), not(hasItems(value)));
                    }
                }
            }

            //实际发送请求
            if ("get" == testcase.when.getRequest()) {
                given().filter(new RequestLoggingFilter())//.log().all()
                        .filter(new ResponseLoggingFilter())
                        .spec(requestSpecification)
                        .when().get(testcase.when.getUrl() + token)
                        .then().spec(builder.build());
            } else {
                given().filter(new RequestLoggingFilter())//.log().all()
                        .filter(new ResponseLoggingFilter())
                        .spec(requestSpecification)
                        .when().post(testcase.when.getUrl() + token)
                        .then().spec(builder.build());
            }


        }

}
