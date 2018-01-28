package mock;

import java.util.List;

/**
 * Created by yuan on 2017/6/29.
 */
public interface ReportMediaDayMapper {

    List<AdvertiserAndMediaStatViewModel> getAdvertiserAndMediaStatList(MediaSearchModel mediaSearchModel);
}
