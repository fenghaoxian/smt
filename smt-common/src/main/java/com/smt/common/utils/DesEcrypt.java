package com.smt.common.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author Seven
 *
 */
public class DesEcrypt {  
	
    private class TKeyByte{
    	public short[] ShortArr = null; 
    } 
    
    private enum TDesMode {dmEncry, dmDecry};
    
    private short[] BitIP = 
    	{
    		57, 49, 41, 33, 25, 17,  9,  1,
    	    59, 51, 43, 35, 27, 19, 11,  3,
    	    61, 53, 45, 37, 29, 21, 13,  5,
    	    63, 55, 47, 39, 31, 23, 15,  7,
    	    56, 48, 40, 32, 24, 16,  8,  0,
    	    58, 50, 42, 34, 26, 18, 10,  2,
    	    60, 52, 44, 36, 28, 20, 12,  4,
    	    62, 54, 46, 38, 30, 22, 14,  6};
    private Short[] BitCP =
    	{
    		39,  7, 47, 15, 55, 23, 63, 31,
    		38,  6, 46, 14, 54, 22, 62, 30,
    		37,  5, 45, 13, 53, 21, 61, 29,
    		36,  4, 44, 12, 52, 20, 60, 28,
    		35,  3, 43, 11, 51, 19, 59, 27,
    		34,  2, 42, 10, 50, 18, 58, 26,
    		33,  1, 41,  9, 49, 17, 57, 25,
    		32,  0, 40,  8, 48, 16, 56, 24
    	};
    private int[] BitExp = {
    		31, 0, 1, 2, 3, 4, 3, 4, 5, 6, 7, 8, 7, 8, 9,10,
    	    11,12,11,12,13,14,15,16,15,16,17,18,19,20,19,20,
    	    21,22,23,24,23,24,25,26,27,28,27,28,29,30,31,0  
    };
    private Short[] BitPM = {
    		15, 6,19,20,28,11,27,16, 0,14,22,25, 4,17,30, 9,
    	    1, 7,23,13,31,26, 2, 8,18,12,29, 5,21,10, 3,24
    };
    private Short[][] sBox = {
    		{ 14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7,
    		         0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8,
    		         4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0,
    		        15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6, 13 },

    		      { 15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10,
    		         3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5,
    		         0, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15,
    		        13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9 },

    		      { 10,  0,  9, 14,  6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8,
    		        13,  7,  0,  9,  3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1,
    		        13,  6,  4,  9,  8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7,
    		         1, 10, 13,  0,  6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12 },

    		      {  7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15,
    		        13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9,
    		        10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4,
    		         3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14 },

    		      {  2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9,
    		        14, 11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6,
    		         4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14,
    		        11,  8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3 },

    		        { 12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11,
    		        10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8,
    		         9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6,
    		         4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13 },

    		      {  4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1,
    		        13,  0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6,
    		         1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2,
    		         6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12 },

    		      { 13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7,
    		         1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2,
    		         7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8,
    		         2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11 } 
    };
    private Short[] BitPMC1 = {
    		56, 48, 40, 32, 24, 16,  8,
    	       0, 57, 49, 41, 33, 25, 17,
    	       9,  1, 58, 50, 42, 34, 26,
    	      18, 10,  2, 59, 51, 43, 35,
    	      62, 54, 46, 38, 30, 22, 14,
    	       6, 61, 53, 45, 37, 29, 21,
    	      13,  5, 60, 52, 44, 36, 28,
    	      20, 12,  4, 27, 19, 11,  3
    };
    private Short[] BitPMC2 = {
    		13, 16, 10, 23,  0,  4,
    	       2, 27, 14,  5, 20,  9,
    	      22, 18, 11,  3, 25,  7,
    	      15,  6, 26, 19, 12,  1,
    	      40, 51, 30, 36, 46, 54,
    	      29, 39, 50, 44, 32, 47,
    	      43, 48, 38, 55, 33, 52,
    	      45, 41, 49, 35, 28, 31
    };
    private TKeyByte[] subKey = new TKeyByte[64];
    
    
    public String GB2Code(String value) throws UnsupportedEncodingException {
    	if  (value==null || ("".equals(value.trim()))) 
    	{
    		return "";
    	}
    	String sRet = "";  
    	String sTmp = "";
    	char c;
    	int intAsc; 
    	value= new String(value.getBytes("GBK"),"ISO-8859-1");
    	for (int i= 0; i< value.length(); i++ ){
    	 c= value.charAt(i);
    	 intAsc= (int)(c&0xFFFF); 
    	 sTmp = Integer.toHexString(intAsc);
    	 if (sTmp.length() == 2) sTmp="00"+sTmp; 
    	 sRet = sRet + sTmp;
    	} 
    	return sRet.toUpperCase();
    }; 
    
    public String Code2GB(String value) throws UnsupportedEncodingException {
    	if  (value==null || ("".equals(value.trim()))) 
    	{
    		return "";
    	}
    	String sRet=""; 
    	for (int i=0; i<value.length()/4;i++){
    		
    	    String stmp = "";
    	    stmp = value.substring(i*4, i*4+4); 
    	    String hexCode = stmp.toLowerCase();
            int sum = 0;
            sum = HexToInt(hexCode); 
    		sRet = sRet + (char) sum; 
    	} 
    	return new String(sRet.getBytes("ISO-8859-1"), "GBK");
    }
    
    private void initPermutation(short[] inData){
    	short[] newData = new short[8];
    	for (int i=0;i<=63;i++){   
    		if ((((inData[BitIP[i]>>3]) & (1 << (7 - (BitIP[i] & 0x07))))&255)!= 0) {
    			newData[i >> 3] = (short)((newData[i >> 3] | (1 << (7 - (i & 0x07))))&255);
    		}
    	}  
    	for (int i=0;i<=7;i++){
    		inData[i]=newData[i];
    	}
    }
    
    private void conversePermutation(short[] inData){
    	short[] newData = new short[8];
    	for (int i=0;i<=63;i++){   
    		if ((((inData[BitCP[i]>>3]) & (1 << (7 - (BitCP[i] & 0x07))))&255)!= 0) {
    			newData[i >> 3] = (short)((newData[i >> 3] | (1 << (7 - (i & 0x07))))&255);
    		}
    	}  
    	for (int i=0;i<=7;i++){
    		inData[i]=newData[i];
    	}
    } 
    private void expand(short[] inData, short[] outData){
    	for (int i=0;i<=47;i++){
    		if (((inData[BitExp[i]>>3] & (1<<(7-(BitExp[i] & 0x07))))&255)!=0){
    			outData[i>>3]= (short)((outData[i>>3] | (1 << (7-(i & 0x07))))&255);
    		}
    	}
    }
    

    private void permutation(short[] inData){
    	short[] newData = new short[4];
    	for (int i=0;i<=31;i++){   
    		if ((((inData[BitPM[i]>>3]) & (1 << (7 - (BitPM[i] & 0x07))))&255)!= 0) {
    			newData[i >> 3] = (short)((newData[i >> 3] | (1 << (7 - (i & 0x07))))&255);
    		}
    	}  
    	for (int i=0;i<=3;i++){
    		inData[i]=newData[i];
    	}
    }
    
    private short si(short s, short inByte){
    	short c; 
    	c = (short) (((inByte & 0x20) | ((inByte & 0x1e)>>1) | ((inByte & 0x01)<<4))&255);
    	return (short) ((sBox[s][c] & 0x0f)&255);
    }
    
    private void permutationChoose1(short[] inData, short[] outData){
    	for (int i=0;i<=55;i++){
    		if (((inData[BitPMC1[i]>>3] & (1<<(7-(BitPMC1[i] & 0x07))))&255)!=0){
    			outData[i>>3]= (short)((outData[i>>3] | (1 << (7-(i & 0x07))))&255);
    		}
    	}
    }
    private void permutationChoose2(short[] inData, TKeyByte outData){
    	for (int i=0;i<=47;i++){
    		if (((inData[BitPMC2[i]>>3] & (1<<(7-(BitPMC2[i] & 0x07))))&255)!=0){
    			outData.ShortArr[i>>3]= (short)((outData.ShortArr[i>>3] | (1 << (7-(i & 0x07))))&255);
    		}
    	}
    }
    
    private void cycleMove(short[] inData, short bitMove){
    	for (int i=0;i<bitMove;i++){
    		inData[0] = (short) (((inData[0]<<1) | (inData[1]>>7))&255);
    		inData[1] = (short) (((inData[1]<<1) | (inData[2]>>7))&255);
    		inData[2] = (short) (((inData[2]<<1) | (inData[3]>>7))&255); 
    	    inData[3] = (short) (((inData[3]<<1) | ((inData[0] & 0x10) >> 4))&255);
    	    inData[0] = (short) ((inData[0] & 0x0f)&255);
    	}
    }
    
    private void makeKey(short[] inKey, TKeyByte[] outKey){
    	short[] outData56 = new short[7];
    	permutationChoose1(inKey, outData56);
    	short[] key28l = new short[4];
    	key28l[0] = (short) ((outData56[0] >> 4) & 255);
    	key28l[1] = (short) (((outData56[0] << 4) | (outData56[1] >> 4))&255);
    	key28l[2] = (short) (((outData56[1] << 4) | (outData56[2] >> 4))&255);
    	key28l[3] = (short) (((outData56[2] << 4) | (outData56[3] >> 4))&255);
    	short[] key28r = new short[4];  
    	key28r[0] = (short) ((outData56[3] & 0x0f)&255);
    	key28r[1] = outData56[4];
    	key28r[2] = outData56[5];
    	key28r[3] = outData56[6]; 
    	short[] bitDisplace = {1,1,2,2, 2,2,2,2, 1,2,2,2, 2,2,2,1};
    	short[] key56o= new short[7];
    	for (int i=0;i<=15;i++){
    		cycleMove(key28l, bitDisplace[i]);
    		cycleMove(key28r, bitDisplace[i]);
    		key56o[0] = (short) (((key28l[0] << 4) | (key28l[1] >> 4))&255);
    		key56o[1] = (short) (((key28l[1] << 4) | (key28l[2] >> 4))&255);
    		key56o[2] = (short) (((key28l[2] << 4) | (key28l[3] >> 4))&255);
    		key56o[3] = (short) (((key28l[3] << 4) | (key28r[0]))&255);
    		key56o[4] = key28r[1];
    		key56o[5] = key28r[2];
    		key56o[6] = key28r[3];
    		permutationChoose2(key56o, outKey[i]);
    	} 	 
    }
    
    private void encry(short[] inData, TKeyByte suberKey, short[] outData){
    	short[] outBuf = new short[6];    	
    	expand(inData, outBuf);
    	 for (int i=0;i<=5;i++){
    		 outBuf[i] = (short) (outBuf[i] ^ suberKey.ShortArr[i]);
    	 }

    	 short[] buf = new short[8];                                               // outBuf       xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx
    	 buf[0] = (short) ((outBuf[0] >> 2)&255);                              //xxxxxx -> 2
    	 buf[1] = (short) ((((outBuf[0] & 0x03) << 4) | (outBuf[1] >> 4))&255); // 4 <- xx xxxx -> 4
    	 buf[2] = (short) ((((outBuf[1] & 0x0f) << 2) | (outBuf[2] >> 6))&255); //        2 <- xxxx xx -> 6
    	 buf[3] = (short) ((outBuf[2] & 0x3f)&255);                                //                    xxxxxx
    	 buf[4] = (short) ((outBuf[3] >> 2)&255);                               //                           xxxxxx
    	 buf[5] = (short) ((((outBuf[3] & 0x03) << 4) | (outBuf[4] >> 4))&255);//                                 xx xxxx
    	 buf[6] = (short) ((((outBuf[4] & 0x0f) << 2) | (outBuf[5] >> 6))&255); //                                        xxxx xx
    	 buf[7] = (short) ((outBuf[5] & 0x3f)&255);                               //                                               xxxxxx
    	 for (short i=0;i<=7;i++){
    		 buf[i] = si(i, buf[i]);
    	 }
    	 for (short i=0;i<=3;i++){
    		 outBuf[i] = (short) (((buf[i*2] << 4) | buf[i*2+1])&255);
    	 }
    	 permutation(outBuf);
    	 for (short i=0;i<=3;i++){
    		 outData[i] = outBuf[i];
    	 }
    }
    
    private void desData(TDesMode desMode, short[] inData, short[] outData){
    	for (short i=0;i<=7;i++){
    		outData[i] = inData[i];
    	}
    	initPermutation(outData);
    	short[] temp= new short[4];
    	short[] buf= new short[4];
    	if (desMode.equals(TDesMode.dmEncry)) {
    		for (short i=0;i<=15;i++){
    		  for (short j=0;j<=3;j++) temp[j] = outData[j];                 //temp = Ln
    	      for (short j=0;j<=3;j++) outData[j] = outData[j + 4];	        //Ln+1 = Rn
    	      encry(outData, subKey[i], buf);                           //Rn ==Kn==> buf
    	      for (short j=0;j<=3;j++) outData[j + 4] = (short) ((temp[j] ^ buf[j])&255);  //Rn+1 = Ln^buf
    		} 
    	    for (short j=0;j<=3;j++) temp[j] = outData[j + 4];
    	    for (short j=0;j<=3;j++) outData[j + 4] = outData[j];
    	    for (short j=0;j<=3;j++) outData[j] = temp[j];
    	} 
    	else if (desMode.equals(TDesMode.dmDecry)) {
    	   for (short i=15;i>=0;i--){
    		  for (short j=0;j<=3;j++) temp[j] = outData[j];
    	      for (short j=0;j<=3;j++) outData[j] = outData[j + 4];
    	      encry(outData, subKey[i], buf);
    	      for (short j=0;j<=3;j++) outData[j + 4] = (short) ((temp[j] ^ buf[j])&255);
    	   } 
    	    for (short j=0;j<=3;j++) temp[j] = outData[j + 4];
    	    for (short j=0;j<=3;j++) outData[j + 4] = outData[j];
    	    for (short j=0;j<=3;j++) outData[j] = temp[j];
    	}  
    	conversePermutation(outData);
    }
    
    public String EncryStr(String str, String key) {
    	if (str.length() > 0 && (str.charAt(str.length() - 1) == 0)) {
    		return "";  
    	}
    	if (key.length()<8) {
    		while (key.length()<8){
    			key = key + " ";
    		} 
    	}
    	while (str.length() % 8 != 0) {
    		str = str + " ";
    	}
    	short[] keyByte=new short[8];
    	for (short j=0;j<=7;j++){
    		keyByte[j] = (short) key.charAt(j);
    	} 
    	for (short j=0;j<=63;j++){ 
    		subKey[j] = new TKeyByte();
    		subKey[j].ShortArr = new short[6];
    	}
    	makeKey(keyByte, subKey);
    	String strResult = "";
    	short[] strByte=new short[8];
    	short[] outByte=new short[8];
    	for (int i=0;i<=str.length() / 8 - 1; i++){
    		for (short j=0;j<=7;j++){
    			strByte[j] = (short) str.charAt(i * 8 + j);  
    		}
    		desData(TDesMode.dmEncry, strByte, outByte);
    		for (short j=0;j<=7;j++){
    			strResult = strResult + (char)outByte[j];
    		}
    	}
    	return strResult;
    }
    
    
    public String EncryStrHex(String str, String key) { 
    	String tempResult = EncryStr(str, key);
    	String strResult = "";
    	for (int i=0;i<=tempResult.length()-1;i++) {
    		int temp = tempResult.charAt(i);  
    		String sTemp = Integer.toHexString(temp);
    		if (sTemp.length()==1) sTemp="0"+sTemp; 
    		strResult = strResult + sTemp;
    	} 
    	return strResult.toUpperCase();
    }
    
    private int HexToInt(String Hex) {
    		int res=0;
    		char ch;
    		for (int i=0;i<=Hex.length()-1;i++){
    			ch = Hex.charAt(i);
    		    if ((ch >= '0') & (ch <= '9'))
    		    	res = res * 16 + ch - "0".charAt(0);
    		    else if ((ch >= 'A') & (ch <= 'F'))
    		    	res = res * 16 + ch - "A".charAt(0) + 10;
    		    else if ((ch >= 'a') & (ch <= 'f')) 
    		        res = res * 16 + ch - "a".charAt(0) + 10;
    		    else res =0;
    		} 
    		return res;
    	}
    
};
