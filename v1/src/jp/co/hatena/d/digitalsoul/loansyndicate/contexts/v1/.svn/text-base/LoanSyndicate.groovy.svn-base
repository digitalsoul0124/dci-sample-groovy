package jp.co.hatena.d.digitalsoul.loansyndicate.contexts.v1;

import jp.co.hatena.d.digitalsoul.loansyndicate.models.v1.Company;
import jp.co.hatena.d.digitalsoul.loansyndicate.models.v1.Facility;


public class LoanSyndicate {

    Facility facility
    
    LoanSyndicate buildFacility(int facilityId) {
        this.facility = new Facility(facilityId:facilityId)
        this
    }
    
    void joinFacility(Company company, BigInteger amount) {
        facility.addMember(company, amount);
    }

    void facilityLimit(BigInteger limit) {
        facility.limit = limit
    }

    boolean validateFacility() {
        facility.validate()
    }

    void transferFacilityPercentage(Company from, Company to, BigInteger transferAmount) {
        facility.transfer(from, to, transferAmount)
    }

    void draw(BigInteger amount) {
        facility.draw(amount)
    }

    void pay(BigInteger amount) {
        facility.pay(amount)
    }
}
