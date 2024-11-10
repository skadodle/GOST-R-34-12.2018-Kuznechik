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

public class CTRMode {
    byte[] iv;

    CTRMode(byte[] iv) {
        this.iv = Arrays.copyOf(iv, iv.length);
    }

    // Метод для инкрементации счетчика
    private void incrementCounter(byte[] counter) {
        for (int i = counter.length - 1; i >= 0; i--) {
            if (++counter[i] != 0) break;
        }
    }

    // Реализация шифрования в режиме CTR
    public byte[] ctrEncrypt(byte[] plaintext, byte[] key) {
        GOST gost = new GOST(key);
        byte[] encryptedText = new byte[plaintext.length];

        byte[] counter = Arrays.copyOf(iv, iv.length);
        for (int i = 0; i < plaintext.length; i += CONSTANTS.BLOCK_SIZE) {
            byte[] block = Arrays.copyOfRange(plaintext, i, Math.min(i + CONSTANTS.BLOCK_SIZE, plaintext.length));
            byte[] encryptedCounter = gost.Kuz_Encript(counter);
            byte[] encryptedBlock = GOSTUtils.XOR(block, Arrays.copyOf(encryptedCounter, block.length));
            System.arraycopy(encryptedBlock, 0, encryptedText, i, encryptedBlock.length);
            incrementCounter(counter);
        }

        return encryptedText;
    }

    public byte[] ctrDecrypt(byte[] ciphertext, byte[] key) {
        return ctrEncrypt(ciphertext, key);
    }
}
