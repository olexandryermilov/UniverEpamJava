package taxes;

public class AuthorTax extends PercentTax {
    private final static int AUTHOR_PERCENT = 7;
    public AuthorTax(){
        super(AUTHOR_PERCENT);
    }
}
