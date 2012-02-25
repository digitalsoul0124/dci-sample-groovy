package jp.co.hatena.d.digitalsoul.loansyndicate.roles;

import jp.co.hatena.d.digitalsoul.loansyndicate.models.Company;
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Share;

public class PercentagePie {

    void addPercentagePieMember(Company company, BigInteger amount) {
        shares.put company.id, new Share(owner:company, amount:amount)
    }
    
    boolean validate() {
        boolean allPositive = true
        shares.each { 
            allPositive = allPositive || 0 <= it.value.amount
        }
        allPositive && 100G == shares.totalAmount()
    }

    void transfer(Company from, Company to, BigInteger transferAmount) {
        Share fromShare = shares.get(from.id)
        Share toShare = shares.get(to.id)

        if(fromShare.amount <= transferAmount) {
            throw new IllegalStateException("not having enough amount")
        }

        fromShare.amount -= transferAmount
        toShare.amount += transferAmount
    }

    BigInteger allot(int ownerId, BigInteger whole) {
        (whole * shares[ownerId].amount / 100).toBigInteger()
    }

}
