
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.xml.registry.infomodel.User;
import service.Order1;

public class demo {
    public static void main(String[] args) {
String text = "2011-10-02 18:48:05.123";
Timestamp  ts = Timestamp.valueOf(text);
System.out.println(ts);
    }

    private static void editUser(services.User1 user) {
        services.UserWebService_Service service = new services.UserWebService_Service();
        services.UserWebService port = service.getUserWebServicePort();
        port.editUser(user);
    }

    private static void create(service.Order1 order1) {
        service.OrderWebService_Service service = new service.OrderWebService_Service();
        service.OrderWebService port = service.getOrderWebServicePort();
        port.create(order1);
    }

    private static java.util.List<service.Order1> getListOrderbyUser(int codeUser, String start, String end) {
        service.OrderWebService_Service service = new service.OrderWebService_Service();
        service.OrderWebService port = service.getOrderWebServicePort();
        return port.getListOrderbyUser(codeUser, start, end);
    }
}
