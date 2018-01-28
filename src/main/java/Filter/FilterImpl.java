package Filter;

public class FilterImpl implements Filter{

    private String name;

    public FilterImpl(String name){
        this.name = name;
    }

    @Override
    public void doFilter(String val, FilterChain filterChain) {
        this.pre(val);
        filterChain.doFilter(val);
        this.after(val);
    }

    private void pre(final String val){
        System.out.println("pre : "+name+val);
    }

    private void after(final String val){
        System.out.println("after : "+name+val);
    }
}
