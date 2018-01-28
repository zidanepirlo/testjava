package Filter;

public class FilterMain {

    public static void main(String[] args) {

        Filter filter1 = new FilterImpl("1");
        Filter filter2 = new FilterImpl("2");

        FilterChain filterChain = new FilterChainImpl();
        filterChain.addFilter(filter1);
        filterChain.addFilter(filter2);

//        filter1.doFilter(" say hello!",filterChain);
        filterChain.begin(" say hello!");
    }
}
