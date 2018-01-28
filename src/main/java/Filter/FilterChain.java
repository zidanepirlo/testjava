package Filter;

public interface FilterChain {
    void addFilter(Filter filter);
    void doFilter(String val);
    void begin(String val);
}
