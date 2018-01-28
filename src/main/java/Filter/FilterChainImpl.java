package Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChainImpl implements FilterChain{

    private List<Filter> filters = new ArrayList<Filter>();
    private final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public FilterChainImpl(){
        threadLocal.set(0);
    }

    @Override
    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public void doFilter(String val) {

        if (threadLocal.get() < filters.size()){
            Integer index = threadLocal.get();
            threadLocal.set(index+1);
            filters.get(index).doFilter(val,this);
        }

    }

    @Override
    public void begin(String val) {
        if (filters.size()>0){
            Integer index = threadLocal.get();
            threadLocal.set(index+1);
            filters.get(index).doFilter(val,this);
        }
    }
}
