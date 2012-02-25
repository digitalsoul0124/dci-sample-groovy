package jp.co.hatena.d.digitalsoul.loansyndicate.roles;

import jp.co.hatena.d.digitalsoul.loansyndicate.models.Company;
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Share;

public class AmountPie {

    void addAmountPieMember(Company company) {
        shares.put company.id, new Share(owner:company, amount:0G)
    }

    void increase(int ownerId, BigInteger amount) {
        shares.get(ownerId).amount += amount
    }

    void decrease(BigInteger amount) {
        BigInteger totalAmount = shares.totalAmount()
        shares.each {
            Share eachShare = it.value
            eachShare.amount -= amount * ( eachShare.amount / totalAmount)
        }
    }
}