/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import entity.OrderDetail;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import wineXpressWebServices.ReportSessionBeanLocal;

/**
 *
 * @author ¿.¿.¿
 */
@WebService(serviceName = "ReportWS")
public class ReportWS {
    @EJB
    private ReportSessionBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getTotalValueofDay")
    public double getTotalValueofDay(@WebParam(name = "orderList") List<OrderDetail> orderList, @WebParam(name = "day") int day) {
        return ejbRef.getTotalValueofDay(orderList, day);
    }

    @WebMethod(operationName = "totalValue")
    public double totalValue(@WebParam(name = "orderList") List<OrderDetail> orderList) {
        return ejbRef.totalValue(orderList);
    }

    @WebMethod(operationName = "getTotalNumberOfDays")
    public int getTotalNumberOfDays(@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
        return ejbRef.getTotalNumberOfDays(month, year);
    }

    @WebMethod(operationName = "retrieveTotalDay")
    public long retrieveTotalDay(@WebParam(name = "start") Date start, @WebParam(name = "end") Date end) {
        return ejbRef.retrieveTotalDay(start, end);
    }

    @WebMethod(operationName = "totalProfit")
    public double totalProfit(@WebParam(name = "orderList") List<OrderDetail> orderList) {
        return ejbRef.totalProfit(orderList);
    }

    @WebMethod(operationName = "orderOfTheMonth")
    public List<OrderDetail> orderOfTheMonth() {
        return ejbRef.orderOfTheMonth();
    }

    @WebMethod(operationName = "orderOfTheDay")
    public List<OrderDetail> orderOfTheDay(@WebParam(name = "myorders") List<OrderDetail> myorders, @WebParam(name = "day") int day) {
        return ejbRef.orderOfTheDay(myorders, day);
    }

    @WebMethod(operationName = "orderOfYear")
    public List<OrderDetail> orderOfYear(@WebParam(name = "year") int year) {
        return ejbRef.orderOfYear(year);
    }

    @WebMethod(operationName = "getTotalProfitOfMonth")
    public double getTotalProfitOfMonth(@WebParam(name = "orderList") List<OrderDetail> orderList, @WebParam(name = "month") int month, @WebParam(name = "year") int year) {
        return ejbRef.getTotalProfitOfMonth(orderList, month, year);
    }

    @WebMethod(operationName = "getTotalValueOfMonth")
    public double getTotalValueOfMonth(@WebParam(name = "orderList") List<OrderDetail> orderList, @WebParam(name = "month") int month, @WebParam(name = "year") int year) {
        return ejbRef.getTotalValueOfMonth(orderList, month, year);
    }

    @WebMethod(operationName = "orderWithinDates")
    public List<OrderDetail> orderWithinDates(@WebParam(name = "sday") int sday, @WebParam(name = "smonth") int smonth, @WebParam(name = "syear") int syear, @WebParam(name = "eday") int eday, @WebParam(name = "emonth") int emonth, @WebParam(name = "eyear") int eyear) {
        return ejbRef.orderWithinDates(sday, smonth, syear, eday, emonth, eyear);
    }

    @WebMethod(operationName = "retrieveTotalMonth")
    public int retrieveTotalMonth(@WebParam(name = "sday") int sday, @WebParam(name = "smonth") int smonth, @WebParam(name = "syear") int syear, @WebParam(name = "eday") int eday, @WebParam(name = "emonth") int emonth, @WebParam(name = "eyear") int eyear) {
        return ejbRef.retrieveTotalMonth(sday, smonth, syear, eday, emonth, eyear);
    }
    
}
