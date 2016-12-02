package com.wokee.qrcodelibrary.zxing.decode;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class DecodeUtils {
	public String decodeWithZxing(Bitmap bitmap) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        multiFormatReader.setHints(changeZXingDecodeDataMode());

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        Result rawResult = null;
        RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);

        if (source != null) {
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                rawResult = multiFormatReader.decodeWithState(binaryBitmap);
            } catch (ReaderException re) {
                // continue
            } finally {
                multiFormatReader.reset();
            }
        }

        return rawResult != null ? rawResult.getText() : null;
    }
	 private Map<DecodeHintType, Object> changeZXingDecodeDataMode() {
	        Map<DecodeHintType, Object> hints = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
	        Collection<BarcodeFormat> decodeFormats = new ArrayList<BarcodeFormat>();

	        switch (mDataMode) {
	            case DECODE_DATA_MODE_ALL:
	                decodeFormats.addAll(DecodeFormatManager.getBarCodeFormats());
	                decodeFormats.addAll(DecodeFormatManager.getQrCodeFormats());
	                break;

	            case DECODE_DATA_MODE_QRCODE:
	                decodeFormats.addAll(DecodeFormatManager.getQrCodeFormats());
	                break;

	            case DECODE_DATA_MODE_BARCODE:
	                decodeFormats.addAll(DecodeFormatManager.getBarCodeFormats());
	                break;
	        }
	        hints.put(DecodeHintType.POSSIBLE_FORMATS, decodeFormats);

	        return hints;
	    }
	  public static final int DECODE_MODE_ZBAR = 10001;
	    public static final int DECODE_MODE_ZXING = 10002;

	    public static final int DECODE_DATA_MODE_ALL = 10003;
	    public static final int DECODE_DATA_MODE_QRCODE = 10004;
	    public static final int DECODE_DATA_MODE_BARCODE = 10005;

	    private int mDataMode;
	    public DecodeUtils(int dataMode) {

	        mDataMode = (dataMode != 0) ? dataMode : DECODE_DATA_MODE_ALL;
	    }
}
