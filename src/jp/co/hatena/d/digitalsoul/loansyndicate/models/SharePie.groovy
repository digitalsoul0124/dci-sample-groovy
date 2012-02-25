package jp.co.hatena.d.digitalsoul.loansyndicate.models;

public class SharePie extends LinkedHashMap<Integer, Share> {

    BigInteger totalAmount() {
        BigInteger sum = 0G
        this.each { sum += it.value.amount }
        sum
    }

}
