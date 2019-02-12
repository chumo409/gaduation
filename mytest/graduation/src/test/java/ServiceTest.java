import com.yhl.domain.Travels;
import com.yhl.service.TravelsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {

    private TravelsService travelsService=null;
    @Before
    public void init(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("appicationContext.xml");
        travelsService = ac.getBean("travelsService", TravelsService.class);

    }

    @Test
    public  void testGetTravels(){
        /*List<Travels> travelsByPage = travelsService.getTravelsByPage(1, 5);
        System.out.println(travelsByPage);*/
    }
}
