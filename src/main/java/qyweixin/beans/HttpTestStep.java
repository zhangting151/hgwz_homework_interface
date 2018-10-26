package qyweixin.beans;

public class HttpTestStep {

    public String description;
    public Given given = new Given();
    public Then then = new Then();
    public When when = new When();

    public Given getGiven() {
        return given;
    }

    public void setGiven(Given given) {
        this.given = given;
    }

    public Then getThen() {
        return then;
    }

    public void setThen(Then then) {
        this.then = then;
    }

    public When getWhen() {
        return when;
    }

    public void setWhen(When when) {
        this.when = when;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
