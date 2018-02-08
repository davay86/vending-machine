import java.math.BigDecimal;

public class CashHandler {


    BigDecimal cashFloat;
    BigDecimal customerCash;

    private static CashHandler instance = null;

    private CashHandler() {
        cashFloat = new BigDecimal(10.00);
        customerCash = new BigDecimal(0);
    }

    public static CashHandler getInstance() {
        if (instance == null) {
            instance = new CashHandler();
        }
        return instance;
    }

    public void acceptCash(ValidCash cash) {
        switch (cash) {
            case FIVE_PENCE:
                System.out.println("5p");
                customerCash = customerCash.add(new BigDecimal(0.05));
                return;
            case TEN_PENCE:
                System.out.println("10p");
                customerCash = customerCash.add(new BigDecimal(0.10));
                return;
            case TWENTY_PENCE:
                System.out.println("20p");
                customerCash = customerCash.add(new BigDecimal(0.20));
                return;
            case FIFTY_PENCE:
                System.out.println("50p");
                customerCash = customerCash.add(new BigDecimal(0.50));
                return;
            case ONE_POUND:
                System.out.println("£1");
                customerCash = customerCash.add(new BigDecimal(1.00));
                return;
            case TWO_POUND:
                System.out.println("£2");
                customerCash = customerCash.add(new BigDecimal(2.00));
                return;
            default:
                return;
        }

    }

    public void refundCash(){
        System.out.println("Refund requested.....");
        dispenseCash(customerCash);
        customerCash = new BigDecimal(0);
    }
    public void dispenseChange(BigDecimal usersExpenditure){
        BigDecimal change = customerCash.subtract(usersExpenditure);
        if(change.compareTo(BigDecimal.ZERO) > 0){
            dispenseCash(change);
            customerCash = new BigDecimal(0);
        }

    }

    public Boolean checkUserHasFunds(BigDecimal userExpenditure){
        return userExpenditure.compareTo(customerCash )< 0;
    }

    private void dispenseCash(BigDecimal cash){
        System.out.println("Cash dispensed : " + cash.setScale(2,BigDecimal.ROUND_HALF_UP));
    }
}