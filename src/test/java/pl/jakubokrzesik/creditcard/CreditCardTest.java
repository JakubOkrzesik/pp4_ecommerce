package pl.jakubokrzesik.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAssignDifferentCreditLimits() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5678");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(BigDecimal.valueOf(1000),card1.getBalance());
        assertEquals(BigDecimal.valueOf(1000),card2.getBalance());
    }

    @Test
    void itCantAssignLimitBelowCertainThreshold() {
        CreditCard card = new CreditCard("1234-5678");

        try{
            card.assignCredit(BigDecimal.valueOf(10));
            fail("Should throw exception");
        } catch(CreditLimitBelowThresholdException e){
            assertTrue(true);
        }

    }
    @Test
    void checkDoublesAndFloats(){
        double x1 = 0.01;
        double x2 = 0.03;
        double result = x2 - x1;

        float y1 = 0.01f;
        float y2 = 0.03f;
        float yresult = y2 - y1;
    }

    @Test
    void reassignLimitTest(){
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows(
                CreditAssignedTwiceException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1100))
        );
    }

    @Test
    void testToWithdrawOverLimit(){
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        assertThrows(
                CantWithdrawOverLimit.class,
                () -> card.withdrawCredit(BigDecimal.valueOf(1100))
        );
    }
    @Test
    void testToWithdrawOverBalance(){
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdrawCredit(BigDecimal.valueOf(900));
        assertThrows(
                CantWithdrawOverBalance.class,
                () -> card.withdrawCredit(BigDecimal.valueOf(200))
        );
    }
    @Test
    void cantWithdrawMoreThanTenTimes(){
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));
        for(int i=0;i<10;i++){
            card.withdrawCredit(BigDecimal.valueOf(1));
        }
        assertThrows(
                WithdrawLimitReached.class, ()-> card.withdrawCredit(BigDecimal.valueOf(1))
        );
    }


}