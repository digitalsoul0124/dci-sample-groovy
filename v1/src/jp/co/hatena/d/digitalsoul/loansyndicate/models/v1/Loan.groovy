package jp.co.hatena.d.digitalsoul.loansyndicate.models.v1;

public class Loan {
    int loanId
    SharePie shares = new SharePie()

    // AmountPieRole
    void addMember(Company company) {
        shares.put company.id, new Share(owner:company, amount:0G)
    }

    // AmountPieRole
    void increase(int ownerId, BigInteger amount) {
        Share loanShare = shares.get(ownerId)
        loanShare.amount += amount
    }

    // AmountPieRole
    void decrease(BigInteger amount) {
        BigInteger totalAmount = shares.totalAmount()
        shares.each {
            it.value.amount -= amount * ( it.value.amount / totalAmount)
      }
    }
}
