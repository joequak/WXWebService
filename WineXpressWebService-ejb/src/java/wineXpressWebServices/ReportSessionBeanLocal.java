/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.OrderDetail;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mac
 */
@Local
public interface ReportSessionBeanLocal {

    public List<OrderDetail> orderWithinDates(Date start, Date end);

    public double getTotalValueofDay(List<OrderDetail> orderList, int day);

    public double totalValue(List<OrderDetail> orderList);

    public int getTotalNumberOfDays(int month, int year);

    public long retrieveTotalDay(Date start, Date end);

    public int retrieveTotalMonth(Date start, Date end);

    public double totalProfit(List<OrderDetail> orderList);

    public List<OrderDetail> orderOfTheMonth();

    public List<OrderDetail> orderOfTheDay(List<OrderDetail> myorders, int day);

    public List<OrderDetail> orderOfYear(int year);

    public double getTotalProfitOfMonth(List<OrderDetail> orderList, int month, int year);

    public double getTotalValueOfMonth(List<OrderDetail> orderList, int month, int year);

}
