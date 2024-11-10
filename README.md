## Realisation of [GOST R 34.12-2018](https://meganorm.ru/Data2/1/4293732/4293732907.pdf)
### The program include [CTR mode](https://meganorm.ru/Data2/1/4293732/4293732952.pdf)
The whole code is written on java programming language

In file ./src/CONSTANTS.java change the iv (initialisation vector) to another (128 bits)

For crypt/decrypt file:
```bash
javac *.java
java Main key file crypt/decrypt
```

After execution in directory u will find file named "file_encrypted" or "file_decrypted".
