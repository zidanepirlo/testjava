package mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by yuan on 2017/6/29.
 */

@RunWith(MockitoJUnitRunner.class)
public class ReportMediaDayMapperTest {

    @Mock
    private ReportMediaDayMapper reportMediaDayMapper; // 定义了mybatis与数据库交互时，用到的接口

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAdvertiserAndMediaStatList() throws Exception {

        MediaSearchModel searchModel = new MediaSearchModel();
        List<AdvertiserAndMediaStatViewModel> list = new ArrayList<AdvertiserAndMediaStatViewModel>();

        AdvertiserAndMediaStatViewModel aas1=new AdvertiserAndMediaStatViewModel("1","yuan");
        AdvertiserAndMediaStatViewModel aas2=new AdvertiserAndMediaStatViewModel("2","qing");

        // mock一个场景，就是当请求getAdvertiserAndMediaStatList方法时，返回值为指定的 list；
        when(reportMediaDayMapper.getAdvertiserAndMediaStatList(searchModel)).thenReturn(list);
        List<AdvertiserAndMediaStatViewModel> list2 = reportMediaDayMapper.getAdvertiserAndMediaStatList(searchModel);
        assertTrue(list2.isEmpty()); // 断言list2为空，因为上面就是一个实例化并没有赋值，所以也是为空了
        System.out.println(list2.size());

    }
}
