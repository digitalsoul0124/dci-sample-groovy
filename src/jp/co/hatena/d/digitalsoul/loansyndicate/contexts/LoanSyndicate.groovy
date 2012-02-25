package jp.co.hatena.d.digitalsoul.loansyndicate.contexts;

import static jp.co.hatena.d.digitalsoul.loansyndicate.common.RoleUtil.*;

import jp.co.hatena.d.digitalsoul.loansyndicate.models.Company;
import jp.co.hatena.d.digitalsoul.loansyndicate.models.Facility;
import jp.co.hatena.d.digitalsoul.loansyndicate.roles.Lender;
import jp.co.hatena.d.digitalsoul.loansyndicate.roles.PercentagePie;
import jp.co.hatena.d.digitalsoul.loansyndicate.roles.AmountPie;

public class LoanSyndicate {

    Facility facility
    Lender lender
    PercentagePie percentagePie
    AmountPie amountPie
    
    LoanSyndicate buildFacility(int facilityId) {

        this.facility = new Facility(facilityId:facilityId)

        this.lender = assign(facility, Lender)
        this.percentagePie = assign(facility, PercentagePie)
        this.amountPie = assign(facility.loan, AmountPie)

        this
    }

    Facility getFacility(){
        this.facility
    }
    
    void joinFacility(Company company, BigInteger amount) {
        percentagePie.addPercentagePieMember company, amount
        amountPie.addAmountPieMember company
    }

    void facilityLimit(BigInteger limit) {
        facility.limit = limit
    }

    boolean validatePercentage() {
        percentagePie.validate()
    }

    void transferPercentage(Company from, Company to, BigInteger transferAmount) {
        percentagePie.transfer(from, to, transferAmount)
    }

    void draw(BigInteger amount) {
        lender.draw(amount, percentagePie, amountPie)
    }

    void pay(BigInteger amount) {
        lender.pay(amount, amountPie)
    }
}
