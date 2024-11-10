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

import java.util.Arrays;

public class GOST {
    private final byte[][] iter_key = new byte[10][16];

    GOST(byte[] key) {
        Kuz_Expand_Key(key);
    }

    /*
    // генерация итерационных констант (заменено на константные значения)
    private byte[][] iter_C = new byte[32][CONSTANTS.BLOCK_SIZE];
    public static void Kuz_C() {
        byte[][] iter_num = new byte[32][CONSTANTS.BLOCK_SIZE];
        for (int i = 0; i < 32; i++) {
            iter_num[i][0] = (byte) (i + 1);
        }
        for (int i = 0; i < 32; i++) {
            iter_C[i] = Kuz_L(iter_num[i]);
        }
    }
    */

    private byte[] Kuz_S(final byte[] in_data) {
        byte[] out_data = new byte[CONSTANTS.BLOCK_SIZE];
        for (int i = 0; i < CONSTANTS.BLOCK_SIZE; i++) {
            int data = in_data[i] & 0xff;
            out_data[i] = CONSTANTS.Pi[data];
        }
        return out_data;
    }
    private byte[] Kuz_reverse_S(final byte[] in_data) {
        byte[] out_data = new byte[CONSTANTS.BLOCK_SIZE];
        for (int i = 0; i < CONSTANTS.BLOCK_SIZE; i++) {
            int data = in_data[i] & 0xff;
            out_data[i] = CONSTANTS.reverse_Pi[data];
        }
        return out_data;
    }

    private byte[] Kuz_X(final byte[] a, final byte[] b) {
        return GOSTUtils.XOR(a, b);
    }

    private byte Kuz_GF_multiply(byte a, byte b) {
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

    private byte[] Kuz_R(byte[] state) {
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
    private byte[] Kuz_reverse_R(byte[] state) {
        byte a_0 = state[15];
        byte[] internal = new byte[CONSTANTS.BLOCK_SIZE];
        for (int i = 1; i < 16; i++) {
            internal[i] = state[i - 1];
            a_0 ^= Kuz_GF_multiply(internal[i], CONSTANTS.l_vec[i]); // + in GF
        }
        internal[0] = a_0;
        return internal;
    }

    private byte[] Kuz_L(final byte[] in_data) {
        byte[] internal = in_data;
        for (int i = 0; i < 16; i++) {
            internal = Kuz_R(internal);
        }
        GOSTUtils.reverseArray(internal);
        return internal;
    }
    private byte[] Kuz_reverse_L(final byte[] in_data) {
        byte[] internal = in_data;
        for (int i = 0; i < 16; i++) {
            internal = Kuz_reverse_R(internal);
        }
        GOSTUtils.reverseArray(internal);
        return internal;
    }

    // преобразование ячейки Фейстеля
    private byte[][] Kuz_F(byte[] in_key_1, byte[] in_key_2, byte[] iter_const) {
        byte[] internal = Kuz_X(in_key_1, iter_const);
        GOSTUtils.reverseArray(internal);
        internal = Kuz_S(internal);
        internal = Kuz_L(internal);
        byte[] out_key_1 = Kuz_X(internal, in_key_2);
        byte[][] key = new byte[2][];
        key[0] = out_key_1;
        key[1] = in_key_1;
        return key;
    }

    // генерация раундовых ключей
    private void Kuz_Expand_Key(byte[] key) {
        byte[] key_1 = Arrays.copyOfRange(key, 0, 16);
        byte[] key_2 = Arrays.copyOfRange(key, 16, 32);
        byte[][] iter12 = new byte[2][];
        byte[][] iter34;
        iter_key[0] = key_1;
        iter_key[1] = key_2;
        iter12[0] = key_1;
        iter12[1] = key_2;
        for (int i = 0; i < 4; i++)
        {
            iter34 = Kuz_F(iter12[0], iter12[1], CONSTANTS.C[8 * i]);
            iter12 = Kuz_F(iter34[0], iter34[1], CONSTANTS.C[1 + 8 * i]);
            iter34 = Kuz_F(iter12[0], iter12[1], CONSTANTS.C[2 + 8 * i]);
            iter12 = Kuz_F(iter34[0], iter34[1], CONSTANTS.C[3 + 8 * i]);
            iter34 = Kuz_F(iter12[0], iter12[1], CONSTANTS.C[4 + 8 * i]);
            iter12 = Kuz_F(iter34[0], iter34[1], CONSTANTS.C[5 + 8 * i]);
            iter34 = Kuz_F(iter12[0], iter12[1], CONSTANTS.C[6 + 8 * i]);
            iter12 = Kuz_F(iter34[0], iter34[1], CONSTANTS.C[7 + 8 * i]);

            iter_key[2 * i + 2] = iter12[0];
            iter_key[2 * i + 3] = iter12[1];
        }
    }

    // функция шифрования блока
    public byte[] Kuz_Encript(byte[] blk) {
        int i;
        byte[] out_blk = blk;
        for(i = 0; i < 9; i++)
        {
            out_blk = Kuz_X(iter_key[i], out_blk);
            GOSTUtils.reverseArray(out_blk);
            out_blk = Kuz_S(out_blk);
            out_blk = Kuz_L(out_blk);
        }
        out_blk = Kuz_X(out_blk, iter_key[9]);
        return out_blk;
    }
    // функция расшифрования блока
    public byte[] Kuz_Decript(byte[] blk) {
        int i;
        byte[] out_blk = blk;

        out_blk = Kuz_X(out_blk, iter_key[9]);
        for(i = 8; i >= 0; i--)
        {
            GOSTUtils.reverseArray(out_blk);
            out_blk = Kuz_reverse_L(out_blk);
            out_blk = Kuz_reverse_S(out_blk);
            out_blk = Kuz_X(iter_key[i], out_blk);
        }
        return out_blk;
    }
}
