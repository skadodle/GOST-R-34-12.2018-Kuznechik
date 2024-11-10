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

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCTR {
    String inputFile;
    String outputFile;
    FileCTR(String inputFile) {
        this.inputFile = inputFile;
        this.outputFile = null;
    }

    public void encryptFile(byte[] key, byte[] iv) {
        CTRMode ctr = new CTRMode(iv);
        if (outputFile == null)
            outputFile = inputFile.substring(0, inputFile.lastIndexOf(".")) + "_encrypted" + inputFile.substring(inputFile.lastIndexOf("."));

        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(inputFile));

            byte[] encryptedContent = ctr.ctrEncrypt(fileContent, key);

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(encryptedContent);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void decryptFile(byte[] key, byte[] iv) {
        outputFile = inputFile.substring(0, inputFile.lastIndexOf(".")) + "_decrypted" + inputFile.substring(inputFile.lastIndexOf("."));
        encryptFile(key, iv);
    }
}
