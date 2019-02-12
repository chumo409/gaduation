import com.yhl.domain.Route;
import com.yhl.service.RouteService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RouteTest {
RouteService routeService=null;
    @Before
    public void init(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("appicationContext.xml");
        routeService=ac.getBean("routeService", RouteService.class);
    }

    @Test
    public void testGetIndexRoute(){
        List<Route> indexRoute =
                routeService.getIndexRoute();
        System.out.println(indexRoute);
    }
    @Test
    public  void  getOneDayRoute(){
       // List<Route> SpecialRoute = routeService.getSpecialRoute(3,1,8);
        //System.out.println(SpecialRoute);

    }
}
