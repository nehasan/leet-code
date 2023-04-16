public class HammingWeight {

    /*
    * param[long] number for which number of 1's to be measured
    * Bitwise and operation between 0001 and any number that has 1 at
    * the rightmost position always produce 1, that's how we calculate
    * number of 1's in a binary number
    * */
    public int hammingWeight(long n) {
        long m = (long) n;
        int numOnes = 0;
        do {
            if((m & 1) == 1) {
                numOnes++;
            }
            m = m >> 1;
        } while(m != 0);
        return numOnes;
    }

    public void run() {
        /*
        * System.out.println(hammingWeight(4294967293));
        * System.out.println(hammingWeight(4294967293));
        *
        */
        System.out.println(hammingWeight(234567));
    }

    public static void main(String[] args) {
        HammingWeight obj = new HammingWeight();
        obj.run();
    }
}
