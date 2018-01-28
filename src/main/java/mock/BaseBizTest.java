package mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.springframework.test.util.ReflectionTestUtils;

/**
 * Created by yuan on 2017/6/30.
 */
@RunWith(MockitoJUnitRunner.class)
public class BaseBizTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @InjectMocks
    private BaseBiz baseBiz;
    @Mock
    private BaseDao baseDao;

    @Spy
    private BaseDao baseDaoSpy;

    @Captor
    private ArgumentCaptor<String> captor;

    @Before
    public void setUp() {
      baseDao = mock(BaseDao.class);
      MockitoAnnotations.initMocks(this);
    }

    // ���ڷ���ֵ�趨
    @Test
    public void testGetUser() {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("userName", "returnMap");
        when(baseDao.getUser("xiaoxiao")).thenReturn(returnMap);

//        Map<String, Object> user = baseBiz.getUser("xiaoxiao");
        Map<String, Object> user = baseBiz.getUser("fff");
        logger.info(user.toString());

//        verify(baseDao).getUser("xiaoxiao");
        verify(baseDao).getUser("fff");
    }

    @Test
    public void testGetUserAnswer() {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("userName", "returnMap");

        String userName = "abc";
        when(baseDao.getUser(userName)).thenAnswer(new Answer<Map<String, Object>>() {
            /**
             * invocation �з���
             * getArguments()  ���ú����Object����ķ�ʽ����mock�������õĲ�����
             * getMethod()  ����java.lang.reflect.Method ����
             * getMock()  ����mock����
             * callRealMethod()  ��ʵ�������ã����mock���ǽӿ��������׳��쳣
             */
            public Map<String, Object> answer(InvocationOnMock invocation) throws Throwable {
                Map<String, Object> returnMap = new HashMap<String, Object>();
                returnMap.put("userName", "xiaoxiao");
                Object[] argus = invocation.getArguments();
                if (!argus[0].equals("xiaoxiao")){
                    returnMap = new HashMap<String, Object>();
                    returnMap.put("userName", "returnMap");
                }
                return returnMap;
            }

        });

        Map<String, Object> user = baseBiz.getUser(userName);
        logger.info(user.toString());

        verify(baseDao).getUser(userName);
    }
    // ���÷�������ʱ�����쳣
    @Test(expected=Exception.class)
    public void testGetUserThrowThenThrow() throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("userName", "returnMap");

        when(baseDao.getUser("xiaoxiao")).thenThrow(new Exception());

        Map<String, Object> user = baseBiz.getUser("xiaoxiao");
        logger.info(user.toString());

        verify(baseDao).getUser("xiaoxiao");
    }

    @Test
    public void testGetUserThrowDoThrow() throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("userName", "returnMap");

        doThrow(new Exception()).when(baseDao).getUserThrow("xiaoxiao");
        Map<String, Object> user = baseBiz.getUser("xiaoxiao");
        logger.info(user.toString());

        verify(baseDao).getUser("xiaoxiao");
    }
    // ��Ҫ������֤
    @Test
    public void testArgumentCaptor() {
        baseBiz.getUser("xiaoxiao");
        baseBiz.getUser("mengmeng");
//       ��֤�����Ƿ񴫵���ȷ ���Ƿ񱻵�������
//      captor.capture() ���񷽷�����
//      captor.getValue() ��ȡ��������ֵ��������������˶�ε��ã������������һ������ֵ
//      captor.getAllValues() �������ж�ε��ú󣬷��ض������ֵ
        verify(baseDao, times(2)).getUser(captor.capture());

        logger.info(captor.getValue());
//      assertEquals("xiaoxiao", captor.getValue());
        assertEquals("mengmeng", captor.getValue());
    }

    // ���ڲ���ƥ�䣬������Ĳ���ֵ
    @Test
    public void testArgumentMatcher() {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("userName", "returnMap");

        when(baseDao.getUser(anyString())).thenReturn(returnMap);
        logger.info(baseBiz.getUser("hello").toString());

        verify(baseDao).getUser("hello");
        verify(baseDao).getUser(eq("hello"));
    }
    // ���ڲ����ж��Ƿ���Ϸ�����Ҫ
    // �Զ������ƥ����� �������XiaoXiao��ƥ��ʧ��
    @Test
    public void testArgumentMatcherCustom() {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("userName", "returnMap");

        class XiaoXiaoFalse extends ArgumentMatcher<String> {
            @Override
            public boolean matches(Object argument) {
                return ((String)argument).equals("XiaoXiao");
            }
        }

        // argThat(Matcher<T> matcher)��������Ӧ���Զ���Ĺ���
        when(baseDao.getUser(argThat(new XiaoXiaoFalse()))).thenReturn(returnMap);

        logger.info(baseBiz.getUser("XiaoXiao").toString());

        verify(baseDao).getUser(argThat(new XiaoXiaoFalse()));
    }

    // spy ��ʵObject��ֻstub���в��ֵķ�������������������ʵ���ܡ� ���spy����ء� ��ʵObject ʱ���á�����when ���﷨�� ������doReturn�﷨
    @Test
    public void testSpy() {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("userName", "returnMap");

        doReturn(returnMap).when(baseDaoSpy).getUser("xiaojian");
//      when(baseDaoSpy.getUser("xiaojian")).thenReturn(returnMap);
        ReflectionTestUtils.setField(baseBiz, "baseDao", baseDaoSpy);
        Map<String, Object> user = baseBiz.getUser("xiaojian");
        logger.info(user.toString());
        logger.info(baseBiz.getUserCard("xiaojian"));
        verify(baseDaoSpy).getUser("xiaojian");

    }

}
