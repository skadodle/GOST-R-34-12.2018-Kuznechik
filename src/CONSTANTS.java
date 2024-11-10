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


public class CONSTANTS {
    static public final int BLOCK_SIZE = 16; //   длина блока

    // начальный вектор
    static byte[] iv = new byte[] {
            0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8,
            0x9, 0x0, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf
    };

    // таблица нелинейного преобразования
    static public final byte[] Pi = {
            (byte) 0xFC, (byte) 0xEE, (byte) 0xDD, 0x11, (byte) 0xCF, 0x6E, 0x31, 0x16,
            (byte) 0xFB, (byte) 0xC4, (byte) 0xFA, (byte) 0xDA, 0x23, (byte) 0xC5, 0x04, 0x4D,
            (byte) 0xE9, 0x77, (byte) 0xF0, (byte) 0xDB, (byte) 0x93, 0x2E, (byte) 0x99, (byte) 0xBA,
            0x17, 0x36, (byte) 0xF1, (byte) 0xBB, 0x14, (byte) 0xCD, 0x5F, (byte) 0xC1,
            (byte) 0xF9, 0x18, 0x65, 0x5A, (byte) 0xE2, 0x5C, (byte) 0xEF, 0x21,
            (byte) 0x81, 0x1C, 0x3C, 0x42, (byte) 0x8B, 0x01, (byte) 0x8E, 0x4F,
            0x05, (byte) 0x84, 0x02, (byte) 0xAE, (byte) 0xE3, 0x6A, (byte) 0x8F, (byte) 0xA0,
            0x06, 0x0B, (byte) 0xED, (byte) 0x98, 0x7F, (byte) 0xD4, (byte) 0xD3, 0x1F,
            (byte) 0xEB, 0x34, 0x2C, 0x51, (byte) 0xEA, (byte) 0xC8, 0x48, (byte) 0xAB,
            (byte) 0xF2, 0x2A, 0x68, (byte) 0xA2, (byte) 0xFD, 0x3A, (byte) 0xCE, (byte) 0xCC,
            (byte) 0xB5, 0x70, 0x0E, 0x56, 0x08, 0x0C, 0x76, 0x12,
            (byte) 0xBF, 0x72, 0x13, 0x47, (byte) 0x9C, (byte) 0xB7, 0x5D, (byte) 0x87,
            0x15, (byte) 0xA1, (byte) 0x96, 0x29, 0x10, 0x7B, (byte) 0x9A, (byte) 0xC7,
            (byte) 0xF3, (byte) 0x91, 0x78, 0x6F, (byte) 0x9D, (byte) 0x9E, (byte) 0xB2, (byte) 0xB1,
            0x32, 0x75, 0x19, 0x3D, (byte) 0xFF, 0x35, (byte) 0x8A, 0x7E,
            0x6D, 0x54, (byte) 0xC6, (byte) 0x80, (byte) 0xC3, (byte) 0xBD, 0x0D, 0x57,
            (byte) 0xDF, (byte) 0xF5, 0x24, (byte) 0xA9, 0x3E, (byte) 0xA8, (byte) 0x43, (byte) 0xC9,
            (byte) 0xD7, 0x79, (byte) 0xD6, (byte) 0xF6, 0x7C, 0x22, (byte) 0xB9, 0x03,
            (byte) 0xE0, 0x0F, (byte) 0xEC, (byte) 0xDE, 0x7A, (byte) 0x94, (byte) 0xB0, (byte) 0xBC,
            (byte) 0xDC, (byte) 0xE8, 0x28, 0x50, 0x4E, 0x33, 0x0A, 0x4A,
            (byte) 0xA7, (byte) 0x97, 0x60, 0x73, 0x1E, 0x00, 0x62, 0x44,
            0x1A, (byte) 0xB8, 0x38, (byte) 0x82, 0x64, (byte) 0x9F, 0x26, 0x41,
            (byte) 0xAD, 0x45, 0x46, (byte) 0x92, 0x27, 0x5E, 0x55, 0x2F,
            (byte) 0x8C, (byte) 0xA3, (byte) 0xA5, 0x7D, 0x69, (byte) 0xD5, (byte) 0x95, 0x3B,
            0x07, 0x58, (byte) 0xB3, 0x40, (byte) 0x86, (byte) 0xAC, 0x1D, (byte) 0xF7,
            0x30, 0x37, 0x6B, (byte) 0xE4, (byte) 0x88, (byte) 0xD9, (byte) 0xE7, (byte) 0x89,
            (byte) 0xE1, 0x1B, (byte) 0x83, 0x49, 0x4C, 0x3F, (byte) 0xF8, (byte) 0xFE,
            (byte) 0x8D, 0x53, (byte) 0xAA, (byte) 0x90, (byte) 0xCA, (byte) 0xD8, (byte) 0x85, 0x61,
            0x20, 0x71, 0x67, (byte) 0xA4, 0x2D, 0x2B, 0x09, 0x5B,
            (byte) 0xCB, (byte) 0x9B, 0x25, (byte) 0xD0, (byte) 0xBE, (byte) 0xE5, 0x6C, 0x52,
            0x59, (byte) 0xA6, 0x74, (byte) 0xD2, (byte) 0xE6, (byte) 0xF4, (byte) 0xB4, (byte) 0xC0,
            (byte) 0xD1, 0x66, (byte) 0xAF, (byte) 0xC2, 0x39, 0x4B, 0x63, (byte) 0xB6
    };

    // таблица обратного нелинейного преобразования
    static public final byte[] reverse_Pi = {
            (byte) 0xA5, 0x2D, 0x32, (byte) 0x8F, 0x0E, 0x30, 0x38, (byte) 0xC0,
            0x54, (byte) 0xE6, (byte) 0x9E, 0x39, 0x55, 0x7E, 0x52, (byte) 0x91,
            0x64, 0x03, 0x57, 0x5A, 0x1C, 0x60, 0x07, 0x18,
            0x21, 0x72, (byte) 0xA8, (byte) 0xD1, 0x29, (byte) 0xC6, (byte) 0xA4, 0x3F,
            (byte) 0xE0, 0x27, (byte) 0x8D, 0x0C, (byte) 0x82, (byte) 0xEA, (byte) 0xAE, (byte) 0xB4,
            (byte) 0x9A, 0x63, 0x49, (byte) 0xE5, 0x42, (byte) 0xE4, 0x15, (byte) 0xB7,
            (byte) 0xC8, 0x06, 0x70, (byte) 0x9D, 0x41, 0x75, 0x19, (byte) 0xC9,
            (byte) 0xAA, (byte) 0xFC, 0x4D, (byte) 0xBF, 0x2A, 0x73, (byte) 0x84, (byte) 0xD5,
            (byte) 0xC3, (byte) 0xAF, 0x2B, (byte) 0x86, (byte) 0xA7, (byte) 0xB1, (byte) 0xB2, 0x5B,
            0x46, (byte) 0xD3, (byte) 0x9F, (byte) 0xFD, (byte) 0xD4, 0x0F, (byte) 0x9C, 0x2F,
            (byte) 0x9B, 0x43, (byte) 0xEF, (byte) 0xD9, 0x79, (byte) 0xB6, 0x53, 0x7F,
            (byte) 0xC1, (byte) 0xF0, 0x23, (byte) 0xE7, 0x25, 0x5E, (byte) 0xB5, 0x1E,
            (byte) 0xA2, (byte) 0xDF, (byte) 0xA6, (byte) 0xFE, (byte) 0xAC, 0x22, (byte) 0xF9, (byte) 0xE2,
            0x4A, (byte) 0xBC, 0x35, (byte) 0xCA, (byte) 0xEE, 0x78, 0x05, 0x6B,
            0x51, (byte) 0xE1, 0x59, (byte) 0xA3, (byte) 0xF2, 0x71, 0x56, 0x11,
            0x6A, (byte) 0x89, (byte) 0x94, 0x65, (byte) 0x8C, (byte) 0xBB, 0x77, 0x3C,
            0x7B, 0x28, (byte) 0xAB, (byte) 0xD2, 0x31, (byte) 0xDE, (byte) 0xC4, 0x5F,
            (byte) 0xCC, (byte) 0xCF, 0x76, 0x2C, (byte) 0xB8, (byte) 0xD8, 0x2E, 0x36,
            (byte) 0xDB, 0x69, (byte) 0xB3, 0x14, (byte) 0x95, (byte) 0xBE, 0x62, (byte) 0xA1,
            0x3B, 0x16, 0x66, (byte) 0xE9, 0x5C, 0x6C, 0x6D, (byte) 0xAD,
            0x37, 0x61, 0x4B, (byte) 0xB9, (byte) 0xE3, (byte) 0xBA, (byte) 0xF1, (byte) 0xA0,
            (byte) 0x85, (byte) 0x83, (byte) 0xDA, 0x47, (byte) 0xC5, (byte) 0xB0, 0x33, (byte) 0xFA,
            (byte) 0x96, 0x6F, 0x6E, (byte) 0xC2, (byte) 0xF6, 0x50, (byte) 0xFF, 0x5D,
            (byte) 0xA9, (byte) 0x8E, 0x17, 0x1B, (byte) 0x97, 0x7D, (byte) 0xEC, 0x58,
            (byte) 0xF7, 0x1F, (byte) 0xFB, 0x7C, 0x09, 0x0D, 0x7A, 0x67,
            0x45, (byte) 0x87, (byte) 0xDC, (byte) 0xE8, 0x4F, 0x1D, 0x4E, 0x04,
            (byte) 0xEB, (byte) 0xF8, (byte) 0xF3, 0x3E, 0x3D, (byte) 0xBD, (byte) 0x8A, (byte) 0x88,
            (byte) 0xDD, (byte) 0xCD, 0x0B, 0x13, (byte) 0x98, 0x02, (byte) 0x93, (byte) 0x80,
            (byte) 0x90, (byte) 0xD0, 0x24, 0x34, (byte) 0xCB, (byte) 0xED, (byte) 0xF4, (byte) 0xCE,
            (byte) 0x99, 0x10, 0x44, 0x40, (byte) 0x92, 0x3A, 0x01, 0x26,
            0x12, 0x1A, 0x48, 0x68, (byte) 0xF5, (byte) 0x81, (byte) 0x8B, (byte) 0xC7,
            (byte) 0xD6, 0x20, 0x0A, 0x08, 0x00, 0x4C, (byte) 0xD7, 0x74
    };

    // вектор линейного преобразования
    static public final byte[] l_vec = {
            1, (byte) 148, 32, (byte) 133, 16, (byte) 194, (byte) 192, 1,
            (byte) 251, 1, (byte) 192, (byte) 194, 16, (byte) 133, 32, (byte) 148
    };

    // итерационные константы
    static public final byte[][] C = new byte[][] {
            {(byte) 0x6e, (byte) 0xa2, (byte) 0x76, (byte) 0x72, (byte) 0x6c, (byte) 0x48, (byte) 0x7a, (byte) 0xb8,
            (byte) 0x5d, (byte) 0x27, (byte) 0xbd, (byte) 0x10, (byte) 0xdd, (byte) 0x84, (byte) 0x94, (byte) 0x01},
            {(byte) 0xdc, (byte) 0x87, (byte) 0xec, (byte) 0xe4, (byte) 0xd8, (byte) 0x90, (byte) 0xf4, (byte) 0xb3,
            (byte) 0xba, (byte) 0x4e, (byte) 0xb9, (byte) 0x20, (byte) 0x79, (byte) 0xcb, (byte) 0xeb, (byte) 0x02},
            {(byte) 0xb2, (byte) 0x25, (byte) 0x9a, (byte) 0x96, (byte) 0xb4, (byte) 0xd8, (byte) 0x8e, (byte) 0x0b,
            (byte) 0xe7, (byte) 0x69, (byte) 0x04, (byte) 0x30, (byte) 0xa4, (byte) 0x4f, (byte) 0x7f, (byte) 0x03},
            {(byte) 0x7b, (byte) 0xcd, (byte) 0x1b, (byte) 0x0b, (byte) 0x73, (byte) 0xe3, (byte) 0x2b, (byte) 0xa5,
            (byte) 0xb7, (byte) 0x9c, (byte) 0xb1, (byte) 0x40, (byte) 0xf2, (byte) 0x55, (byte) 0x15, (byte) 0x04},
            {(byte) 0x15, (byte) 0x6f, (byte) 0x6d, (byte) 0x79, (byte) 0x1f, (byte) 0xab, (byte) 0x51, (byte) 0x1d,
            (byte) 0xea, (byte) 0xbb, (byte) 0x0c, (byte) 0x50, (byte) 0x2f, (byte) 0xd1, (byte) 0x81, (byte) 0x05},
            {(byte) 0xa7, (byte) 0x4a, (byte) 0xf7, (byte) 0xef, (byte) 0xab, (byte) 0x73, (byte) 0xdf, (byte) 0x16,
            (byte) 0x0d, (byte) 0xd2, (byte) 0x08, (byte) 0x60, (byte) 0x8b, (byte) 0x9e, (byte) 0xfe, (byte) 0x06},
            {(byte) 0xc9, (byte) 0xe8, (byte) 0x81, (byte) 0x9d, (byte) 0xc7, (byte) 0x3b, (byte) 0xa5, (byte) 0xae,
            (byte) 0x50, (byte) 0xf5, (byte) 0xb5, (byte) 0x70, (byte) 0x56, (byte) 0x1a, (byte) 0x6a, (byte) 0x07},
            {(byte) 0xf6, (byte) 0x59, (byte) 0x36, (byte) 0x16, (byte) 0xe6, (byte) 0x05, (byte) 0x56, (byte) 0x89,
            (byte) 0xad, (byte) 0xfb, (byte) 0xa1, (byte) 0x80, (byte) 0x27, (byte) 0xaa, (byte) 0x2a, (byte) 0x08},
            {(byte) 0x98, (byte) 0xfb, (byte) 0x40, (byte) 0x64, (byte) 0x8a, (byte) 0x4d, (byte) 0x2c, (byte) 0x31,
            (byte) 0xf0, (byte) 0xdc, (byte) 0x1c, (byte) 0x90, (byte) 0xfa, (byte) 0x2e, (byte) 0xbe, (byte) 0x09},
            {(byte) 0x2a, (byte) 0xde, (byte) 0xda, (byte) 0xf2, (byte) 0x3e, (byte) 0x95, (byte) 0xa2, (byte) 0x3a,
            (byte) 0x17, (byte) 0xb5, (byte) 0x18, (byte) 0xa0, (byte) 0x5e, (byte) 0x61, (byte) 0xc1, (byte) 0x0a},
            {(byte) 0x44, (byte) 0x7c, (byte) 0xac, (byte) 0x80, (byte) 0x52, (byte) 0xdd, (byte) 0xd8, (byte) 0x82,
            (byte) 0x4a, (byte) 0x92, (byte) 0xa5, (byte) 0xb0, (byte) 0x83, (byte) 0xe5, (byte) 0x55, (byte) 0x0b},
            {(byte) 0x8d, (byte) 0x94, (byte) 0x2d, (byte) 0x1d, (byte) 0x95, (byte) 0xe6, (byte) 0x7d, (byte) 0x2c,
            (byte) 0x1a, (byte) 0x67, (byte) 0x10, (byte) 0xc0, (byte) 0xd5, (byte) 0xff, (byte) 0x3f, (byte) 0x0c},
            {(byte) 0xe3, (byte) 0x36, (byte) 0x5b, (byte) 0x6f, (byte) 0xf9, (byte) 0xae, (byte) 0x07, (byte) 0x94,
            (byte) 0x47, (byte) 0x40, (byte) 0xad, (byte) 0xd0, (byte) 0x08, (byte) 0x7b, (byte) 0xab, (byte) 0x0d},
            {(byte) 0x51, (byte) 0x13, (byte) 0xc1, (byte) 0xf9, (byte) 0x4d, (byte) 0x76, (byte) 0x89, (byte) 0x9f,
            (byte) 0xa0, (byte) 0x29, (byte) 0xa9, (byte) 0xe0, (byte) 0xac, (byte) 0x34, (byte) 0xd4, (byte) 0x0e},
            {(byte) 0x3f, (byte) 0xb1, (byte) 0xb7, (byte) 0x8b, (byte) 0x21, (byte) 0x3e, (byte) 0xf3, (byte) 0x27,
            (byte) 0xfd, (byte) 0x0e, (byte) 0x14, (byte) 0xf0, (byte) 0x71, (byte) 0xb0, (byte) 0x40, (byte) 0x0f},
            {(byte) 0x2f, (byte) 0xb2, (byte) 0x6c, (byte) 0x2c, (byte) 0x0f, (byte) 0x0a, (byte) 0xac, (byte) 0xd1,
            (byte) 0x99, (byte) 0x35, (byte) 0x81, (byte) 0xc3, (byte) 0x4e, (byte) 0x97, (byte) 0x54, (byte) 0x10},
            {(byte) 0x41, (byte) 0x10, (byte) 0x1a, (byte) 0x5e, (byte) 0x63, (byte) 0x42, (byte) 0xd6, (byte) 0x69,
            (byte) 0xc4, (byte) 0x12, (byte) 0x3c, (byte) 0xd3, (byte) 0x93, (byte) 0x13, (byte) 0xc0, (byte) 0x11},
            {(byte) 0xf3, (byte) 0x35, (byte) 0x80, (byte) 0xc8, (byte) 0xd7, (byte) 0x9a, (byte) 0x58, (byte) 0x62,
            (byte) 0x23, (byte) 0x7b, (byte) 0x38, (byte) 0xe3, (byte) 0x37, (byte) 0x5c, (byte) 0xbf, (byte) 0x12},
            {(byte) 0x9d, (byte) 0x97, (byte) 0xf6, (byte) 0xba, (byte) 0xbb, (byte) 0xd2, (byte) 0x22, (byte) 0xda,
            (byte) 0x7e, (byte) 0x5c, (byte) 0x85, (byte) 0xf3, (byte) 0xea, (byte) 0xd8, (byte) 0x2b, (byte) 0x13},
            {(byte) 0x54, (byte) 0x7f, (byte) 0x77, (byte) 0x27, (byte) 0x7c, (byte) 0xe9, (byte) 0x87, (byte) 0x74,
            (byte) 0x2e, (byte) 0xa9, (byte) 0x30, (byte) 0x83, (byte) 0xbc, (byte) 0xc2, (byte) 0x41, (byte) 0x14},
            {(byte) 0x3a, (byte) 0xdd, (byte) 0x01, (byte) 0x55, (byte) 0x10, (byte) 0xa1, (byte) 0xfd, (byte) 0xcc,
            (byte) 0x73, (byte) 0x8e, (byte) 0x8d, (byte) 0x93, (byte) 0x61, (byte) 0x46, (byte) 0xd5, (byte) 0x15},
            {(byte) 0x88, (byte) 0xf8, (byte) 0x9b, (byte) 0xc3, (byte) 0xa4, (byte) 0x79, (byte) 0x73, (byte) 0xc7,
            (byte) 0x94, (byte) 0xe7, (byte) 0x89, (byte) 0xa3, (byte) 0xc5, (byte) 0x09, (byte) 0xaa, (byte) 0x16},
            {(byte) 0xe6, (byte) 0x5a, (byte) 0xed, (byte) 0xb1, (byte) 0xc8, (byte) 0x31, (byte) 0x09, (byte) 0x7f,
            (byte) 0xc9, (byte) 0xc0, (byte) 0x34, (byte) 0xb3, (byte) 0x18, (byte) 0x8d, (byte) 0x3e, (byte) 0x17},
            {(byte) 0xd9, (byte) 0xeb, (byte) 0x5a, (byte) 0x3a, (byte) 0xe9, (byte) 0x0f, (byte) 0xfa, (byte) 0x58,
            (byte) 0x34, (byte) 0xce, (byte) 0x20, (byte) 0x43, (byte) 0x69, (byte) 0x3d, (byte) 0x7e, (byte) 0x18},
            {(byte) 0xb7, (byte) 0x49, (byte) 0x2c, (byte) 0x48, (byte) 0x85, (byte) 0x47, (byte) 0x80, (byte) 0xe0,
            (byte) 0x69, (byte) 0xe9, (byte) 0x9d, (byte) 0x53, (byte) 0xb4, (byte) 0xb9, (byte) 0xea, (byte) 0x19},
            {(byte) 0x05, (byte) 0x6c, (byte) 0xb6, (byte) 0xde, (byte) 0x31, (byte) 0x9f, (byte) 0x0e, (byte) 0xeb,
            (byte) 0x8e, (byte) 0x80, (byte) 0x99, (byte) 0x63, (byte) 0x10, (byte) 0xf6, (byte) 0x95, (byte) 0x1a},
            {(byte) 0x6b, (byte) 0xce, (byte) 0xc0, (byte) 0xac, (byte) 0x5d, (byte) 0xd7, (byte) 0x74, (byte) 0x53,
            (byte) 0xd3, (byte) 0xa7, (byte) 0x24, (byte) 0x73, (byte) 0xcd, (byte) 0x72, (byte) 0x01, (byte) 0x1b},
            {(byte) 0xa2, (byte) 0x26, (byte) 0x41, (byte) 0x31, (byte) 0x9a, (byte) 0xec, (byte) 0xd1, (byte) 0xfd,
            (byte) 0x83, (byte) 0x52, (byte) 0x91, (byte) 0x03, (byte) 0x9b, (byte) 0x68, (byte) 0x6b, (byte) 0x1c},
            {(byte) 0xcc, (byte) 0x84, (byte) 0x37, (byte) 0x43, (byte) 0xf6, (byte) 0xa4, (byte) 0xab, (byte) 0x45,
            (byte) 0xde, (byte) 0x75, (byte) 0x2c, (byte) 0x13, (byte) 0x46, (byte) 0xec, (byte) 0xff, (byte) 0x1d},
            {(byte) 0x7e, (byte) 0xa1, (byte) 0xad, (byte) 0xd5, (byte) 0x42, (byte) 0x7c, (byte) 0x25, (byte) 0x4e,
            (byte) 0x39, (byte) 0x1c, (byte) 0x28, (byte) 0x23, (byte) 0xe2, (byte) 0xa3, (byte) 0x80, (byte) 0x1e},
            {(byte) 0x10, (byte) 0x03, (byte) 0xdb, (byte) 0xa7, (byte) 0x2e, (byte) 0x34, (byte) 0x5f, (byte) 0xf6,
            (byte) 0x64, (byte) 0x3b, (byte) 0x95, (byte) 0x33, (byte) 0x3f, (byte) 0x27, (byte) 0x14, (byte) 0x1f},
            {(byte) 0x5e, (byte) 0xa7, (byte) 0xd8, (byte) 0x58, (byte) 0x1e, (byte) 0x14, (byte) 0x9b, (byte) 0x61,
            (byte) 0xf1, (byte) 0x6a, (byte) 0xc1, (byte) 0x45, (byte) 0x9c, (byte) 0xed, (byte) 0xa8, (byte) 0x20}
    };
}
