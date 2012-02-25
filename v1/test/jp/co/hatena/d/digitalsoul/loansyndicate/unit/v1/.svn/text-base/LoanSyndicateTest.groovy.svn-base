package jp.co.hatena.d.digitalsoul.loansyndicate.unit.v1;

import static org.junit.Assert.*;

import jp.co.hatena.d.digitalsoul.loansyndicate.contexts.v1.LoanSyndicate;
import jp.co.hatena.d.digitalsoul.loansyndicate.models.v1.Company;

import org.junit.Test;

public class LoanSyndicateTest {

    @Test
    public void shouldBuildFacility() throws Exception {

        Company a = new Company(id:10, name:"A")
        Company b = new Company(id:20, name:"B")
        Company c = new Company(id:30, name:"C")
        
        LoanSyndicate syndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility a, 50G
        syndicate.joinFacility b, 30G
        syndicate.joinFacility c, 20G

        assertEquals 50G, syndicate.facility.shares[10].amount
        assertEquals 30G, syndicate.facility.shares[20].amount
        assertEquals 20G, syndicate.facility.shares[30].amount
        
        assertTrue syndicate.validateFacility()
    }

    @Test
    public void shouldTransferAmountInFacility() throws Exception {

        Company a = new Company(id:10, name:"A")
        Company b = new Company(id:20, name:"B")
        Company c = new Company(id:30, name:"C")
        
        LoanSyndicate syndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility a, 50G
        syndicate.joinFacility b, 30G
        syndicate.joinFacility c, 20G

        syndicate.transferFacilityPercentage a, b, 10G

        assertEquals 40G, syndicate.facility.shares[10].amount
        assertEquals 40G, syndicate.facility.shares[20].amount
        assertEquals 20G, syndicate.facility.shares[30].amount
    }

    @Test
    public void shouldDrawFromFacility() throws Exception {

        Company a = new Company(id:10, name:"A")
        Company b = new Company(id:20, name:"B")
        Company c = new Company(id:30, name:"C")
        
        LoanSyndicate syndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility a, 50G
        syndicate.joinFacility b, 30G
        syndicate.joinFacility c, 20G
        syndicate.facilityLimit 100000G

        syndicate.draw 10000G

        assertEquals 5000G, syndicate.facility.loan.shares[10].amount
        assertEquals 3000G, syndicate.facility.loan.shares[20].amount
        assertEquals 2000G, syndicate.facility.loan.shares[30].amount

        assertEquals 90000G, syndicate.facility.limit
    }

    @Test
    public void shouldPayToFacility() throws Exception {

        Company a = new Company(id:10, name:"A")
        Company b = new Company(id:20, name:"B")
        Company c = new Company(id:30, name:"C")
        
        LoanSyndicate syndicate = new LoanSyndicate().buildFacility(1)
        syndicate.joinFacility a, 50G
        syndicate.joinFacility b, 30G
        syndicate.joinFacility c, 20G
        syndicate.facilityLimit 100000G

        syndicate.draw 10000G
        syndicate.pay 5000G

        assertEquals 2500G, syndicate.facility.loan.shares[10].amount
        assertEquals 1500G, syndicate.facility.loan.shares[20].amount
        assertEquals 1000G, syndicate.facility.loan.shares[30].amount

        assertEquals 95000G, syndicate.facility.limit
    }
}
