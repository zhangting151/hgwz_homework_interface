package qyweixin.beans;

import org.hamcrest.Matcher;

public class Then {
    public int statusCode;
    public Item[] body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Item[] getBody() {
        return body;
    }

    public void setBody(Item[] body) {
        this.body = body;
    }
}
