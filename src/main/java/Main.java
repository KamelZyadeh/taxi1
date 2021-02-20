import com.java.tutorial.dao.impl.AccountDAO;
import com.java.tutorial.entities.*;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.AccountService;
import com.java.tutorial.service.impl.ClientOrderService;
import com.java.tutorial.service.impl.LocationService;
import com.java.tutorial.service.impl.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ServiceException {


        OrderService orderService = new OrderService();
        LocationService locationService = new LocationService();
        ClientOrderService clientOrderService = new ClientOrderService();

        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order = orderService.readById(15);
        Location location = new Location();
        location = locationService.readById(51);
        order.setSource(location);
        location = locationService.readById(52);
        order.setDestination(location);

        orderList.add(order);

        order = orderService.readById(13);
        location = locationService.readById(43);
        order.setSource(location);
        location = locationService.readById(44);
        order.setDestination(location);

        orderList.add(order);

        double clientLoc = 119.14708;
        Order[] orderArray = new Order[orderList.size()];
        orderList.toArray(orderArray);
        System.out.println(orderArray.length);

        Order order2 = new Order();

            for (int i = 0; i < orderArray.length; i++){
                Order order1 = orderArray[i];
                Location location1 = new Location();
                if (i == 0) {
                    location1 = locationService.readById(44);
                } else {
                    location1 = locationService.readById(52);
                }

                double taxiLoc = location1.getLat() + location1.getLng();

                double total = clientLoc - taxiLoc;
                double[] subArr = new double[orderArray.length];
                subArr[i] = total;

            }


//            orderList = Arrays.asList(orderArray);
    }
    public Order[] sortForNearest() {

        return null;
    }
}
