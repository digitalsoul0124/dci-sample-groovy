package jp.co.hatena.d.digitalsoul.loansyndicate.models.v1;

public class Facility {
    int facilityId
    BigInteger limit = 0
    Loan loan = new Loan()
    SharePie shares = new SharePie()

    // PercentagePieRole
    boolean validate() {
        boolean allPositive = true
        shares.each { 
            allPositive = allPositive || 0 <= it.value.amount
        }
        allPositive && 100G == shares.totalAmount()
    }

    // PercentagePieRole
    void transfer(Company from, Company to, BigInteger transferAmount) {
        Share fromShare = shares.get(from.id)
        Share toShare = shares.get(to.id)

        if(fromShare.amount <= transferAmount) {
            throw new IllegalStateException("not having enough amount")
        }

        fromShare.amount -= transferAmount
        toShare.amount += transferAmount
    }

    // PercentagePieRole
    BigInteger allot(int ownerId, BigInteger whole) {
        (whole * shares[ownerId].amount / 100).toBigInteger()
    }

    // LenderRole
    void addMember(Company company, BigInteger amount) {
        shares.put company.id, new Share(owner:company, amount:amount)
        loan.addMember company
    }

    // LenderRole
    void draw(BigInteger amount) {
        shares.each {
            int ownerId = it.value.owner.id
            loan.increase(ownerId, allot(ownerId, amount))
        }
        limit -= amount
    }

    // LenderRole
    void pay(BigInteger amount) {
        loan.decrease(amount)
        limit += amount
    }
}
