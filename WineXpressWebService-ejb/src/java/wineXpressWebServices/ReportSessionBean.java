/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.OrderDetail;
import entity.OrderItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mac
 */
@Stateless
public class ReportSessionBean implements ReportSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;

    public ReportSessionBean() {
    }

    @Override
    public List<OrderDetail> orderOfTheDay(List<OrderDetail> myorders, int day) {
        System.out.println(")_____________++++++++++++++order of the day@@@@@@@@@@@@@@@");
        List<OrderDetail> result = new ArrayList();
        if ((myorders != null) || (!myorders.isEmpty())) {
            for (Object o : myorders) {
                OrderDetail myOrder = (OrderDetail) o;
                Date orderDate = myOrder.getOrdDate();
                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(orderDate);
                int current = cal1.get(Calendar.DAY_OF_MONTH);
                if (current == day) {
                    result.add(myOrder);
                }

            }
        }
        return result;
    }

    @Override
    public List<OrderDetail> orderOfTheMonth() {
        System.out.println(")_____________++++++++++++++order of the Month @@@@@@@@@@@@@@@");
        Date todayDate = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(todayDate);
        int current = cal1.get(Calendar.MONTH);
        List<OrderDetail> result = new ArrayList();
        Query q = em.createQuery("SELECT c FROM OrderDetail c");
        for (Object o : q.getResultList()) {
            OrderDetail myOrder = (OrderDetail) o;
            Date orderDate = myOrder.getOrdDate();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(orderDate);
            int month = cal2.get(Calendar.MONTH);
            if (current == month) {
                result.add(myOrder);
            }

        }
        return result;
    }

    @Override
    public List<OrderDetail> orderOfYear(int year) {
        System.out.println(")_____________++++++++++++++order of the year @@@@@@@@@@@@@@@");
        Date todayDate = new Date();
        List<OrderDetail> result = new ArrayList();
        Query q = em.createQuery("SELECT c FROM OrderDetail c");
        for (Object o : q.getResultList()) {
            OrderDetail myOrder = (OrderDetail) o;
            Date orderDate = myOrder.getOrdDate();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(orderDate);
            int month = cal2.get(Calendar.YEAR);
            if (year == month) {
                result.add(myOrder);
            }

        }
        return result;
    }

    @Override
    public List<OrderDetail> orderWithinDates(Date start, Date end) {
        System.out.println(")_____________++++++++++++++order of within  @@@@@@@@@@@@@@@");
        List<OrderDetail> result = new ArrayList();
        Query q = em.createQuery("SELECT c FROM OrderDetail c");
        for (Object o : q.getResultList()) {
            OrderDetail myOrder = (OrderDetail) o;
            Date orderDate = myOrder.getOrdDate();
            if ((orderDate.after(start) || orderDate.equals(start)) && (orderDate.before(end) || orderDate.equals(end))) {
                result.add(myOrder);
            }
        }
        return result;
    }

    @Override
    public double getTotalValueofDay(List<OrderDetail> orderList, int day) {
        System.out.println(")_____________++++++++++++++order of the day@@@@@@@@@@@@@@@");
        double result = 0.0;
        Date date1;
        Calendar cal = Calendar.getInstance();
        if ((orderList != null) || (!orderList.isEmpty())) {
            for (Object o : orderList) {
                OrderDetail myOrder = (OrderDetail) o;
                date1 = myOrder.getOrdDate();
                cal.setTime(date1);
                int orderDay = cal.get(Calendar.DAY_OF_MONTH);
                if (orderDay == day) {
                    result += myOrder.getTotalPrice();
                }
            }
        }
        return result;

    }

    @Override
    public int getTotalNumberOfDays(int month, int year) {
        System.out.println(")_____________++++++++++++++total nu of day@@@@@@@@@@@@@@@");
        int result = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            result = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            result = 30;
        } else if (month == 2 && year % 4 == 0) {
            result = 29;
        } else {
            result = 28;
        }
        return result;
    }

    @Override
    public long retrieveTotalDay(Date start, Date end) {
        long days = 0;
        if (start != null && end != null) {
            long diffDay = 0;
            diffDay = end.getTime() - start.getTime();
            days = diffDay / (24 * 60 * 60 * 1000);
        }
        return days;
    }

    @Override
    public int retrieveTotalMonth(Date start, Date end) {
        int diffMonth = 0;
        if (start != null && end != null) {
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(start);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(end);
            int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
            diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH) + 1;
        }
        return diffMonth;

    }

    @Override
    public double getTotalProfitOfMonth(List<OrderDetail> orderList, int month, int year) {
        double total = 0.0;
        List<OrderDetail> result = new ArrayList();
        Date date1;
        Calendar cal = Calendar.getInstance();
        if (orderList != null) {
            for (Object o : orderList) {
                OrderDetail myOrder = (OrderDetail) o;
                date1 = myOrder.getOrdDate();
                cal.setTime(date1);
                int orderMonth = cal.get(Calendar.MONTH);
                orderMonth++;
                int orderYear = cal.get(Calendar.YEAR);
                if (orderMonth == month && orderYear == year) {
                    result.add(myOrder);
                }
            }
        }
        total = this.totalProfit(result);
        return total;

    }

    @Override
    public double totalValue(List<OrderDetail> orderList) {
        double result = 0.0;
        if (orderList != null) {
            for (Object o : orderList) {
                result += ((OrderDetail) o).getTotalPrice();
            }
        }
        return result;
    }

    @Override
    public double totalProfit(List<OrderDetail> orderList) {
        double result = 0.0;
        double revenue = 0.0;
        double profit = 0.0;
        if (orderList != null) {
            for (Object o : orderList) {
                OrderDetail p = (OrderDetail) o;
                for (Object oo : p.getOrderItemCollection()) {
                    OrderItem orderItem = (OrderItem) oo;
                    result += orderItem.getProduct().getCost() * orderItem.getQuantity();
                }
            }
        }
        revenue = this.totalValue(orderList);
        profit = revenue - result;
        return profit;
    }

    private Boolean compareMonth(Date d1, Date d2) {
        Boolean result = true;
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        int cuM = cal1.get(Calendar.MONTH);
        int oM = cal2.get(Calendar.MONTH);
        if (cuM != oM) {
            result = false;
        }
        return result;
    }

    @Override
    public double getTotalValueOfMonth(List<OrderDetail> orderList, int month, int year) {
        Double result = 0.0;
        Date date1;
        Calendar cal = Calendar.getInstance();
        if (orderList != null) {
            for (Object o : orderList) {
                OrderDetail myOrder = (OrderDetail) o;
                date1 = myOrder.getOrdDate();
                cal.setTime(date1);
                int orderMonth = cal.get(Calendar.MONTH);
                orderMonth++;
                int orderYear = cal.get(Calendar.YEAR);
                if (orderMonth == month && orderYear == year) {
                    result += myOrder.getTotalPrice();
                }
            }
        }
        return result;

    }

}
