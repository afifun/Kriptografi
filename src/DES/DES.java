package DES;


import java.util.*;

/**
 *
 * @author moh.afifun.naily - 1106016802
 * @author haris.dwi - 1206239011
 */
public class DES {

    //tabel IP
    private static final byte[] IP = {
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6,
        64, 56, 48, 40, 32, 24, 16, 8,
        57, 49, 41, 33, 25, 17, 9, 1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7
    };

    // tabel PC1
    private static final byte[] PC1 = {
        57, 49, 41, 33, 25, 17, 9,
        1, 58, 50, 42, 34, 26, 18,
        10, 2, 59, 51, 43, 35, 27,
        19, 11, 3, 60, 52, 44, 36,
        63, 55, 47, 39, 31, 23, 15,
        7, 62, 54, 46, 38, 30, 22,
        14, 6, 61, 53, 45, 37, 29,
        21, 13, 5, 28, 20, 12, 4
    };

    // tabel PC2
    private static final byte[] PC2 = {
        14, 17, 11, 24, 1, 5,
        3, 28, 15, 6, 21, 10,
        23, 19, 12, 4, 26, 8,
        16, 7, 27, 20, 13, 2,
        41, 52, 31, 37, 47, 55,
        30, 40, 51, 45, 33, 48,
        44, 49, 39, 56, 34, 53,
        46, 42, 50, 36, 29, 32
    };

    // tabel Expansion
    private static final byte[] E = {
        32, 1, 2, 3, 4, 5,
        4, 5, 6, 7, 8, 9,
        8, 9, 10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1
    };

    // S-boxes (s1 - s8)
    private static final byte[][] S = {{
        14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7,
        0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8,
        4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0,
        15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13
    }, {
        15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10,
        3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5,
        0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15,
        13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9
    }, {
        10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8,
        13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1,
        13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7,
        1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12
    }, {
        7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15,
        13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9,
        10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4,
        3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14
    }, {
        2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9,
        14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6,
        4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14,
        11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3
    }, {
        12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11,
        10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8,
        9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6,
        4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13
    }, {
        4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1,
        13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6,
        1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2,
        6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12
    }, {
        13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7,
        1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2,
        7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8,
        2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11
    }};

    // table permutasi
    private static final byte[] P = {
        16, 7, 20, 21,
        29, 12, 28, 17,
        1, 15, 23, 26,
        5, 18, 31, 10,
        2, 8, 24, 14,
        32, 27, 3, 9,
        19, 13, 30, 6,
        22, 11, 4, 25
    };

    // Final permutation
    private static final byte[] FP = {
        40, 8, 48, 16, 56, 24, 64, 32,
        39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41, 9, 49, 17, 57, 25
    };
    
    //Array untuk menyimpan bayaknya rotasi pada setiap ronde
    private static final byte[] rotasi = {
        1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
    };

    //array untuk menyimpan key yang potong menjadi dua
    private static int[] C = new int[28];
    private static int[] D = new int[28];

    //array untuk menyimpan  key yang dipermute tiap ronde
    private static int[][] subkey = new int[16][48];

    public static String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < hex.length() - 1; i += 2) {
            String output = hex.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            sb.append((char) decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }

    public static String convertStringToHex(String str) {

        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }

        return hex.toString();
    }

    /*
     Method permute menerima argumen input, key dan status
     input = berupa 64 bits (array integer dengan ukuran 64)
     key = berupa 64 bits key (array integer dengan ukuran 64)
     status = false untuk enkrip dan true untuk dekripsi
    
     */
    public static String permute(int[] input, int[] key, boolean status) {
        // intial permute untuk input dan disimpan ke kedalam array baru
        int[] bitsNew = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            bitsNew[i] = input[IP[i] - 1];
        }

        int L[] = new int[32];
        int R[] = new int[32];
        int i;

        // PC1
        for (i = 0; i < 28; i++) {
            C[i] = key[PC1[i] - 1];
        }
        for (; i < 56; i++) {
            D[i - 28] = key[PC1[i] - 1];
        }

        System.arraycopy(bitsNew, 0, L, 0, 32);
        System.arraycopy(bitsNew, 32, R, 0, 32);
        
        if (status){
            for (int j = 0; j < 16; j++) {
                    KS(j, key); 
                }
        }
        for (int n = 0; n < 16; n++) {

            int newR[] = new int[0];
            if (status) {
                newR = fiestelFunction(R, subkey[15 - n]);
            } else {
                newR = fiestelFunction(R, KS(n, key));
            }

            int newL[] = xor(L, newR);
            L = R;
            R = newL;
        }

        // concat R dan L.
        int output[] = new int[64];
        System.arraycopy(R, 0, output, 0, 32);
        System.arraycopy(L, 0, output, 32, 32);
        int finalOutput[] = new int[64];
        
	// finalOutput untuk menyimpan hasil akhir (enkripsi atau deskripsi)
        for (i = 0; i < 64; i++) {
            finalOutput[i] = output[FP[i] - 1];
        }

	// convert array bits ke hex
        String hex = new String();
        for (i = 0; i < 16; i++) {
            String bin = new String();
            for (int j = 0; j < 4; j++) {
                bin += finalOutput[(4 * i) + j];
            }
            int decimal = Integer.parseInt(bin, 2);
            hex += Integer.toHexString(decimal);
        }
        return hex;
    }
    
    //method ini berfungsi untuk me-genarate key tiap ronde
    private static int[] KS(int round, int[] key) {
        
        int C1[] = new int[28];
        int D1[] = new int[28];

        //mengambil banyaknya rotasi dari array rotasi
        int banyakRotasi = (int) rotasi[round];
		
        //melakukan rotasi
        C1 = leftShift(C, banyakRotasi);
        D1 = leftShift(D, banyakRotasi);
        
        // menyimpan C1 dan D1 ke dalan CDNew
        int[] CDNew = new int[56];
        System.arraycopy(C1, 0, CDNew, 0, 28);
        System.arraycopy(D1, 0, CDNew, 28, 28);
		
        
        int Kn[] = new int[48];
        for (int i = 0; i < Kn.length; i++) {
            Kn[i] = CDNew[PC2[i] - 1];
        }

		
        
        //menyimpan C1 dan D1 ke dalam C dan D untuk ronde berikutnya
        subkey[round] = Kn;
        C = C1;
        D = D1;
        return Kn;
    }

    private static int[] fiestelFunction(int[] R, int[] key) {
        
        // 32 bits pertama dari R array di expand menggunakan E table.
        int[] expandR = new int[48];
        for (int i = 0; i < 48; i++) {
            expandR[i] = R[E[i] - 1];
        }
        
        // xor expanded R dan key
        int temp[] = xor(expandR, key);
		
        int output[] = sBlock(temp);
        return output;
    }
    
    //xor untk dua buah bit
    private static int[] xor(int[] a, int[] b) {
        int answer[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            answer[i] = a[i] ^ b[i];
        }
        return answer;
    }

    private static int[] sBlock(int[] bits) {
        int output[] = new int[32];
        
        for (int i = 0; i < 8; i++) {
		
            
            int row[] = new int[2];
            row[0] = bits[6 * i];
            row[1] = bits[(6 * i) + 5];
            String sRow = row[0] + "" + row[1];
		
            int column[] = new int[4];
            column[0] = bits[(6 * i) + 1];
            column[1] = bits[(6 * i) + 2];
            column[2] = bits[(6 * i) + 3];
            column[3] = bits[(6 * i) + 4];
            String sColumn = column[0] + "" + column[1] + "" + column[2] + "" + column[3];
			
            
            int iRow = Integer.parseInt(sRow, 2);
            int iColumn = Integer.parseInt(sColumn, 2);
            int x = S[i][(iRow * 16) + iColumn];
			
            String s = Integer.toBinaryString(x);
		
            while (s.length() < 4) {
                s = "0" + s;
            }
            // append bits
            for (int j = 0; j < 4; j++) {
                output[(i * 4) + j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
	
        
        int finalOutput[] = new int[32];
        for (int i = 0; i < 32; i++) {
            finalOutput[i] = output[P[i] - 1];
        }
        return finalOutput;
    }

    public static String padding(String hex) {
        int length = hex.length();
        if (hex.length() < 16) {
            System.out.println(hex.length());
            for (int i = 0; i < 16 - length; i++) {
                hex = 0 + hex;
            }
        }
        return hex;
    }

    public static String removePadding(String hex) {
        int count = 0;
        while (hex.charAt(count) == '0') {
            count++;
        }
        hex = hex.substring(count);
        return hex;
    }

    public static Stack<String> cutTo16Hexa(String input) {
        int length = 64;
        Stack<String> stack = new Stack();
        while (input.length() >= 16) {
            String input64 = input.substring(input.length() - 16, input.length());
            stack.push(input64);
            input = input.substring(0, (input.length() - 16));
        }

        if (input.length() > 0) {
            input = padding(input);
            stack.push(input);
        }
        return stack;
    }

    public static int[] paddingZeroEachHexa(String input) {
        int inputBits[] = new int[64];
        for (int i = 0; i < 16; i++) {

            //convert Hexa ke bit string
            String s = Integer.toBinaryString(Integer.parseInt(input.charAt(i) + "", 16));

            while (s.length() < 4) {
                s = "0" + s;
            }

            //menyimpan 4 bit yang dihasilkan kedalam array
            for (int j = 0; j < 4; j++) {
                inputBits[(4 * i) + j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
        return inputBits;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
    
    public static String convertBytestoHexa(byte[] input){
        StringBuilder sb = new StringBuilder();
        for (byte b : input) {
                sb.append(String.format("%02X", b));
            }
        return sb.toString();
    }
    
    public static int[] generate64BitKey(String hexKey){
        //method ini mengambil 16 Hexa pertama dari key
        int keyBits[] = new int[64];
            for (int i = 0; i < 16; i++) {
                String s = Integer.toBinaryString(Integer.parseInt(hexKey.charAt(i) + "", 16));
                while (s.length() < 4) {
                    s = "0" + s;
                }
                for (int j = 0; j < 4; j++) {
                    keyBits[(4 * i) + j] = Integer.parseInt(s.charAt(j) + "");
                }
            }
        return keyBits;
    }
    
     private static int[] leftShift(int[] bits, int n) {
        
        int[] output = new int[bits.length];
        System.arraycopy(bits, 0, output, 0, bits.length);
        for (int i = 0; i < n; i++) {
            int temp = output[0];
            for (int j = 0; j < bits.length - 1; j++) {
                output[j] = output[j + 1];
            }
            output[bits.length - 1] = temp;
        }
        return output;
    }
}
