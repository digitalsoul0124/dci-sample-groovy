package jp.co.hatena.d.digitalsoul.loansyndicate.roles;

import jp.co.hatena.d.digitalsoul.loansyndicate.models.Company;
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Facility;


public class Lender {

    void draw(BigInteger amount, PercentagePie percentagePie, AmountPie amountPie) {
        drawFromPieHolders(amount, percentagePie, amountPie)
        decreaseLimit(amount)
    }

    void pay(BigInteger amount, AmountPie amountPie) {
        amountPie.decrease(amount)
        increaseLimit(amount)
    }

    private void drawFromPieHolders(BigInteger amount, PercentagePie percentagePie, AmountPie amountPie) {
        percentagePie.shares.each {
            int ownerId = it.value.owner.id
            BigInteger allot = percentagePie.allot(ownerId, amount)
            amountPie.increase(ownerId, allot)
        }        
    }

    private void decreaseLimit(BigInteger amount) {
        setLimit(getLimit() - amount)
    }

    private void increaseLimit(BigInteger amount) {
        setLimit(getLimit() + amount)
    }

}
