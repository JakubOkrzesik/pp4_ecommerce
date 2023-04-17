package pl.jakubokrzesik.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;
    private Integer withdrawCounter=0;
    private boolean isOnCredit = false;
    private int billingCount = 0;

    public CreditCard(String cardNumber) {
    }

    public void assignCredit(BigDecimal creditAmount) {
        if (isBelowThreshold(creditAmount)){
            throw new CreditLimitBelowThresholdException();
        }

        if (credit != null){
            throw new CreditAssignedTwiceException();
        }
        this.balance = creditAmount;
        this.credit = creditAmount;
        isOnCredit = true;
    }

    public void withdrawCredit(BigDecimal withdrawAmount){
        if (withdrawAmount.compareTo(this.credit)<=0){
            if(withdrawAmount.compareTo(this.balance)<=0){
                if(this.withdrawCounter<10){
                    this.withdrawCounter+=1;
                    this.balance = this.balance.subtract(withdrawAmount);
                }else{
                    throw new WithdrawLimitReached();
                }
            }else{
                throw new CantWithdrawOverBalance();
            }
        }else{
            throw new CantWithdrawOverLimit();
        }
    }

    public void repayCredit(BigDecimal repayAmount){
        if(this.credit.compareTo(repayAmount)<=0){
            increaseBalance(repayAmount.subtract(this.credit));
            this.credit = BigDecimal.valueOf(0);
            this.billingCount = 0;
            this.isOnCredit = false;
        }else{
            this.credit = this.credit.subtract(repayAmount);
            if(repayAmount.compareTo(BigDecimal.valueOf(0))!=0){
                this.billingCount = 0;
            }
        }
    }

    private static boolean isBelowThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public void payIn(BigDecimal amount){increaseBalance(amount);}
    public BigDecimal getBalance() {
        return balance;
    }
    public void increaseBalance(BigDecimal amount){this.balance = this.balance.add(amount);}
    public void decreaseBalance(BigDecimal amount){this.balance = this.balance.subtract(amount);}
}