public abstract class MurmurHash3_32_Long {

    private static int C1 = 0xcc9e2d51;
    private static int C2 = 0x1b873593;

    static int hash(long key, int seed) {
        int low = (int) key;
        int high = (int) (key >>> 32);

        int k1 = low * C1;
        k1 = Integer.rotateLeft(k1, 15);
        k1 *= C2;

        int h1 = seed ^ k1;
        h1 = Integer.rotateLeft(h1, 13);
        h1 = (h1 * 5) + 0xe6546b64;

        k1 = high * C1;
        k1 = Integer.rotateLeft(k1, 15);
        k1 *= C2;

        h1 ^= k1;
        h1 = Integer.rotateLeft(h1, 13);
        h1 = (h1 * 5) + 0xe6546b64;

        //For long type (8 byte)
        h1 ^= 8;

        h1 ^= h1 >>> 16;
        h1 *= 0x85ebca6b;
        h1 ^= h1 >>> 13;
        h1 *= 0xc2b2ae35;
        h1 ^= h1 >>> 16;

        return h1;
    }

}
