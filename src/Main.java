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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3)
            help();

        byte[] key = null;

        try (FileInputStream fis = new FileInputStream(args[0])) {
            key = fis.readAllBytes();
        } catch (FileNotFoundException e) {
            System.out.println("File with key not found!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!Files.exists(Paths.get(args[1]))) {
            System.out.println("File " + args[1] + " not found!");
            System.exit(1);
        }
        FileCTR fileCTR = new FileCTR(args[1]);
        if (args[2].compareToIgnoreCase("crypt") == 0) {
            fileCTR.encryptFile(key, CONSTANTS.iv);
        } else if (args[2].compareToIgnoreCase("decrypt") == 0) {
            fileCTR.decryptFile(key, CONSTANTS.iv);
        } else {
            System.out.println("Unknown mode of encryption! ");
            System.exit(1);
        }

        /*
        GOST gost = new GOST(key);

        byte[] originalText = new byte[] {
                0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x00,
                (byte) 0xff, (byte) 0xee, (byte) 0xdd, (byte) 0xcc, (byte) 0xbb, (byte) 0xaa, (byte) 0x99, (byte) 0x88
        };
        byte[] cipherText = gost.Kuz_Encript(originalText);
        System.out.println("\n\t\tCIPHER TEXT");
        for (byte el : cipherText)
            System.out.print("0x" + String.format("%02X", el) + " ");

        originalText = gost.Kuz_Decript(cipherText);
        System.out.println("\n\t\tORIGINAL TEXT");
        for (byte el : originalText)
            System.out.print("0x" + String.format("%02X", el) + " ");
        originalText = new byte[] {
                0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88,
                0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88,
                0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88,
                0x11, 0x22, 0x33
        };

        CTRMode ctr = new CTRMode(CONSTANTS.iv);
        cipherText = ctr.ctrEncrypt(originalText, key);
        System.out.println("\n\t\tCIPHER TEXT:");
        for (byte el : cipherText)
            System.out.print("0x" + Integer.toHexString(el & 0xFF) + " ");
        System.out.println("\n\t\tORIGINAL TEXT:");
        originalText = ctr.ctrDecrypt(cipherText, key);
        for (byte el : originalText)
            System.out.print("0x" + Integer.toHexString(el & 0xFF) + " ");

        FileCTR fCtr = new FileCTR("out/production/Project/1234.jpg");
        fCtr.encryptFile(key, CONSTANTS.iv);

        fCtr = new FileCTR("out/production/Project/1234_encrypted.jpg");
        fCtr.decryptFile(key, CONSTANTS.iv);
        */
    }

    private static void help() {
        System.out.println("Usage: java Main <key> <file> <mode>");
        System.out.println("<key> - file which contains the key");
        System.out.println("<file> - a file which need to be encrypted or decrypted");
        System.out.println("<mode> - mode of encryption (crypt | decrypt) any case");
        System.exit(1);
    }
}
