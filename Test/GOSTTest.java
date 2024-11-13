//  MIT License
//
//  Copyright (c) 2024 Vyacheslav Kudryavtsev
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy
//  of this software and associated documentation files (the "Software"), to deal
//  in the Software without restriction, including without limitation the rights
//  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//  copies of the Software, and to permit persons to whom the Software is
//  furnished to do so, subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//  SOFTWARE.

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GOSTTest {
    @Test
    void kuz_S() {
        char[] s1 = "ffeeddccbbaa99881122334455667700".toCharArray();
        char[] s2 = "b66cd8887d38e8d77765aeea0c9a7efc".toCharArray();
        char[] s3 = "559d8dd7bd06cbfe7e7b262523280d39".toCharArray();
        char[] s4 = "0c3322fed531e4630d80ef5c5a81c50b".toCharArray();
        char[] s5 = "23ae65633f842d29c5df529c13f5acda".toCharArray();

        byte[] s1Int = new byte[s1.length / 2];
        byte[] s2Int = new byte[s1.length / 2];
        byte[] s3Int = new byte[s1.length / 2];
        byte[] s4Int = new byte[s1.length / 2];
        byte[] s5Int = new byte[s1.length / 2];
        for (int i = 0; i < s1.length; i+=2) {
            s1Int[i / 2] = (byte) Integer.parseInt("" + s1[i] + s1[i + 1], 16);
            s2Int[i / 2] = (byte) Integer.parseInt("" + s2[i] + s2[i + 1], 16);
            s3Int[i / 2] = (byte) Integer.parseInt("" + s3[i] + s3[i + 1], 16);
            s4Int[i / 2] = (byte) Integer.parseInt("" + s4[i] + s4[i + 1], 16);
            s5Int[i / 2] = (byte) Integer.parseInt("" + s5[i] + s5[i + 1], 16);
        }

        Assertions.assertArrayEquals(s2Int, Functions.Kuz_S(s1Int));
        Assertions.assertArrayEquals(s3Int, Functions.Kuz_S(s2Int));
        Assertions.assertArrayEquals(s4Int, Functions.Kuz_S(s3Int));
        Assertions.assertArrayEquals(s5Int, Functions.Kuz_S(s4Int));
    }

    @Test
    void kuz_reverse_S() {
        char[] s1 = "ffeeddccbbaa99881122334455667700".toCharArray();
        char[] s2 = "b66cd8887d38e8d77765aeea0c9a7efc".toCharArray();
        char[] s3 = "559d8dd7bd06cbfe7e7b262523280d39".toCharArray();
        char[] s4 = "0c3322fed531e4630d80ef5c5a81c50b".toCharArray();
        char[] s5 = "23ae65633f842d29c5df529c13f5acda".toCharArray();

        byte[] s1Int = new byte[s1.length / 2];
        byte[] s2Int = new byte[s2.length / 2];
        byte[] s3Int = new byte[s3.length / 2];
        byte[] s4Int = new byte[s4.length / 2];
        byte[] s5Int = new byte[s5.length / 2];
        for (int i = 0; i < s1.length; i+=2) {
            s1Int[i / 2] = (byte) Integer.parseInt("" + s1[i] + s1[i + 1], 16);
            s2Int[i / 2] = (byte) Integer.parseInt("" + s2[i] + s2[i + 1], 16);
            s3Int[i / 2] = (byte) Integer.parseInt("" + s3[i] + s3[i + 1], 16);
            s4Int[i / 2] = (byte) Integer.parseInt("" + s4[i] + s4[i + 1], 16);
            s5Int[i / 2] = (byte) Integer.parseInt("" + s5[i] + s5[i + 1], 16);
        }

        Assertions.assertArrayEquals(s4Int, Functions.Kuz_reverse_S(s5Int));
        Assertions.assertArrayEquals(s3Int, Functions.Kuz_reverse_S(s4Int));
        Assertions.assertArrayEquals(s2Int, Functions.Kuz_reverse_S(s3Int));
        Assertions.assertArrayEquals(s1Int, Functions.Kuz_reverse_S(s2Int));
    }

    @Test
    void kuz_gf_multiply() {
        byte a = (byte) 135;
        byte b = 19;

        Assertions.assertEquals(237, Functions.Kuz_GF_multiply(a, b) & 0xFF);
    }

    @Test
    void kuz_R() {
        char[] r1 = "00000000000000000000000000000100".toCharArray();
        char[] r2 = "94000000000000000000000000000001".toCharArray();
        char[] r3 = "a5940000000000000000000000000000".toCharArray();
        char[] r4 = "64a59400000000000000000000000000".toCharArray();
        char[] r5 = "0d64a594000000000000000000000000".toCharArray();

        byte[] r1Int = new byte[r1.length / 2];
        byte[] r2Int = new byte[r2.length / 2];
        byte[] r3Int = new byte[r3.length / 2];
        byte[] r4Int = new byte[r4.length / 2];
        byte[] r5Int = new byte[r5.length / 2];
        for (int i = 0; i < r1.length; i+=2) {
            r1Int[i / 2] = (byte) Integer.parseInt("" + r1[i] + r1[i + 1], 16);
            r2Int[i / 2] = (byte) Integer.parseInt("" + r2[i] + r2[i + 1], 16);
            r3Int[i / 2] = (byte) Integer.parseInt("" + r3[i] + r3[i + 1], 16);
            r4Int[i / 2] = (byte) Integer.parseInt("" + r4[i] + r4[i + 1], 16);
            r5Int[i / 2] = (byte) Integer.parseInt("" + r5[i] + r5[i + 1], 16);
        }

        GOSTUtils.reverseArray(r1Int);
        r1Int = Functions.Kuz_R(r1Int);
        GOSTUtils.reverseArray(r1Int);
        Assertions.assertArrayEquals(r2Int, r1Int);

        GOSTUtils.reverseArray(r2Int);
        r2Int = Functions.Kuz_R(r2Int);
        GOSTUtils.reverseArray(r2Int);
        Assertions.assertArrayEquals(r3Int, r2Int);

        GOSTUtils.reverseArray(r3Int);
        r3Int = Functions.Kuz_R(r3Int);
        GOSTUtils.reverseArray(r3Int);
        Assertions.assertArrayEquals(r4Int, r3Int);

        GOSTUtils.reverseArray(r4Int);
        r4Int = Functions.Kuz_R(r4Int);
        GOSTUtils.reverseArray(r4Int);
        Assertions.assertArrayEquals(r5Int, r4Int);
    }

    @Test
    void kuz_reverse_R() {
        char[] r1 = "00000000000000000000000000000100".toCharArray();
        char[] r2 = "94000000000000000000000000000001".toCharArray();
        char[] r3 = "a5940000000000000000000000000000".toCharArray();
        char[] r4 = "64a59400000000000000000000000000".toCharArray();
        char[] r5 = "0d64a594000000000000000000000000".toCharArray();

        byte[] r1Int = new byte[r1.length / 2];
        byte[] r2Int = new byte[r2.length / 2];
        byte[] r3Int = new byte[r3.length / 2];
        byte[] r4Int = new byte[r4.length / 2];
        byte[] r5Int = new byte[r5.length / 2];
        for (int i = 0; i < r1.length; i+=2) {
            r1Int[i / 2] = (byte) Integer.parseInt("" + r1[i] + r1[i + 1], 16);
            r2Int[i / 2] = (byte) Integer.parseInt("" + r2[i] + r2[i + 1], 16);
            r3Int[i / 2] = (byte) Integer.parseInt("" + r3[i] + r3[i + 1], 16);
            r4Int[i / 2] = (byte) Integer.parseInt("" + r4[i] + r4[i + 1], 16);
            r5Int[i / 2] = (byte) Integer.parseInt("" + r5[i] + r5[i + 1], 16);
        }

        GOSTUtils.reverseArray(r5Int);
        r5Int = Functions.Kuz_reverse_R(r5Int);
        GOSTUtils.reverseArray(r5Int);
        Assertions.assertArrayEquals(r4Int, r5Int);

        GOSTUtils.reverseArray(r4Int);
        r4Int = Functions.Kuz_reverse_R(r4Int);
        GOSTUtils.reverseArray(r4Int);
        Assertions.assertArrayEquals(r3Int, r4Int);

        GOSTUtils.reverseArray(r3Int);
        r3Int = Functions.Kuz_reverse_R(r3Int);
        GOSTUtils.reverseArray(r3Int);
        Assertions.assertArrayEquals(r2Int, r3Int);

        GOSTUtils.reverseArray(r2Int);
        r2Int = Functions.Kuz_reverse_R(r2Int);
        GOSTUtils.reverseArray(r2Int);
        Assertions.assertArrayEquals(r1Int, r2Int);
    }

    @Test
    void kuz_L() {
        char[] l1 = "64a59400000000000000000000000000".toCharArray();
        char[] l2 = "d456584dd0e3e84cc3166e4b7fa2890d".toCharArray();
        char[] l3 = "79d26221b87b584cd42fbc4ffea5de9a".toCharArray();
        char[] l4 = "0e93691a0cfc60408b7b68f66b513c13".toCharArray();
        char[] l5 = "e6a8094fee0aa204fd97bcb0b44b8580".toCharArray();

        byte[] l1Int = new byte[l1.length / 2];
        byte[] l2Int = new byte[l2.length / 2];
        byte[] l3Int = new byte[l3.length / 2];
        byte[] l4Int = new byte[l4.length / 2];
        byte[] l5Int = new byte[l5.length / 2];
        for (int i = 0; i < l1.length; i+=2) {
            l1Int[i / 2] = (byte) Integer.parseInt("" + l1[i] + l1[i + 1], 16);
            l2Int[i / 2] = (byte) Integer.parseInt("" + l2[i] + l2[i + 1], 16);
            l3Int[i / 2] = (byte) Integer.parseInt("" + l3[i] + l3[i + 1], 16);
            l4Int[i / 2] = (byte) Integer.parseInt("" + l4[i] + l4[i + 1], 16);
            l5Int[i / 2] = (byte) Integer.parseInt("" + l5[i] + l5[i + 1], 16);
        }

        GOSTUtils.reverseArray(l1Int);
        l1Int = Functions.Kuz_L(l1Int);
        Assertions.assertArrayEquals(l2Int, l1Int);

        GOSTUtils.reverseArray(l2Int);
        l2Int = Functions.Kuz_L(l2Int);
        Assertions.assertArrayEquals(l3Int, l2Int);

        GOSTUtils.reverseArray(l3Int);
        l3Int = Functions.Kuz_L(l3Int);
        Assertions.assertArrayEquals(l4Int, l3Int);

        GOSTUtils.reverseArray(l4Int);
        l4Int = Functions.Kuz_L(l4Int);
        Assertions.assertArrayEquals(l5Int, l4Int);
    }

    @Test
    void kuz_reverse_L() {
        char[] l1 = "64a59400000000000000000000000000".toCharArray();
        char[] l2 = "d456584dd0e3e84cc3166e4b7fa2890d".toCharArray();
        char[] l3 = "79d26221b87b584cd42fbc4ffea5de9a".toCharArray();
        char[] l4 = "0e93691a0cfc60408b7b68f66b513c13".toCharArray();
        char[] l5 = "e6a8094fee0aa204fd97bcb0b44b8580".toCharArray();

        byte[] l1Int = new byte[l1.length / 2];
        byte[] l2Int = new byte[l2.length / 2];
        byte[] l3Int = new byte[l3.length / 2];
        byte[] l4Int = new byte[l4.length / 2];
        byte[] l5Int = new byte[l5.length / 2];
        for (int i = 0; i < l1.length; i+=2) {
            l1Int[i / 2] = (byte) Integer.parseInt("" + l1[i] + l1[i + 1], 16);
            l2Int[i / 2] = (byte) Integer.parseInt("" + l2[i] + l2[i + 1], 16);
            l3Int[i / 2] = (byte) Integer.parseInt("" + l3[i] + l3[i + 1], 16);
            l4Int[i / 2] = (byte) Integer.parseInt("" + l4[i] + l4[i + 1], 16);
            l5Int[i / 2] = (byte) Integer.parseInt("" + l5[i] + l5[i + 1], 16);
        }

        GOSTUtils.reverseArray(l5Int);
        l5Int = Functions.Kuz_reverse_L(l5Int);
        Assertions.assertArrayEquals(l4Int, l5Int);

        GOSTUtils.reverseArray(l4Int);
        l4Int = Functions.Kuz_reverse_L(l4Int);
        Assertions.assertArrayEquals(l3Int, l4Int);

        GOSTUtils.reverseArray(l3Int);
        l3Int = Functions.Kuz_reverse_L(l3Int);
        Assertions.assertArrayEquals(l2Int, l3Int);

        GOSTUtils.reverseArray(l2Int);
        l2Int = Functions.Kuz_reverse_L(l2Int);
        Assertions.assertArrayEquals(l1Int, l2Int);
    }

    private static class Functions {

        public static byte[] Kuz_S(final byte[] in_data) {
            byte[] out_data = new byte[CONSTANTS.BLOCK_SIZE];
            for (int i = 0; i < CONSTANTS.BLOCK_SIZE; i++) {
                int data = in_data[i] & 0xff;
                out_data[i] = CONSTANTS.Pi[data];
            }
            return out_data;
        }
        public static byte[] Kuz_reverse_S(final byte[] in_data) {
            byte[] out_data = new byte[CONSTANTS.BLOCK_SIZE];
            for (int i = 0; i < CONSTANTS.BLOCK_SIZE; i++) {
                int data = in_data[i] & 0xff;
                out_data[i] = CONSTANTS.reverse_Pi[data];
            }
            return out_data;
        }

        public static byte Kuz_GF_multiply(byte a, byte b) {
            byte c = 0;
            byte hi_bit;
            for (int i = 0; i < 8; i++) {
                if ((b & 1) == 1)
                    c ^= a;
                hi_bit = (byte) (a & 0x80);
                a &= 0x7F;
                a <<= 1;
                if (hi_bit < 0)
                    a ^= (byte) 0xC3;
                b >>= 1;
            }
            return c;
        }

        public static byte[] Kuz_R(byte[] state) {
            byte a_15 = 0;
            byte[] internal = new byte[CONSTANTS.BLOCK_SIZE];
            for (int i = 15; i >= 0; i--) {
                if (i == 0)
                    internal[15] = state[i];
                else
                    internal[i - 1] = state[i];
                a_15 ^= Kuz_GF_multiply(state[i], CONSTANTS.l_vec[i]); // + in GF
            }
            internal[15] = a_15;
            return internal;
        }
        public static byte[] Kuz_reverse_R(byte[] state) {
            byte a_0 = state[15];
            byte[] internal = new byte[CONSTANTS.BLOCK_SIZE];
            for (int i = 1; i < 16; i++) {
                internal[i] = state[i - 1];
                a_0 ^= Kuz_GF_multiply(internal[i], CONSTANTS.l_vec[i]); // + in GF
            }
            internal[0] = a_0;
            return internal;
        }

        public static byte[] Kuz_L(final byte[] in_data) {
            byte[] internal = in_data;
            for (int i = 0; i < 16; i++) {
                internal = Kuz_R(internal);
            }
            GOSTUtils.reverseArray(internal);
            return internal;
        }
        public static byte[] Kuz_reverse_L(final byte[] in_data) {
            byte[] internal = in_data;
            for (int i = 0; i < 16; i++) {
                internal = Kuz_reverse_R(internal);
            }
            GOSTUtils.reverseArray(internal);
            return internal;
        }
    }
}
