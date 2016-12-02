package com.wokee.qrcodelibrary.zxing.activity;//package com.wokee.qrcode.zxing.activity;
//
//import android.app.Activity;
//import android.graphics.Bitmap;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.gf.community.R;
//import com.gf.zxing.utils.CreatQcordUtils;
//import com.google.zxing.WriterException;
//
///**
// * 生成二维码
// */
//public class CreatQCordActivity extends Activity{
//
//
//	private ImageView img;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
////		setContentView(R.layout.activity_creatqcord);
//		img=(ImageView) findViewById(R.id.imageView1);
//		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				try {
//					img.setImageBitmap(CreatQcordUtils.createQRCode("123",200));
//					Toast.makeText(CreatQCordActivity.this, "success",Toast.LENGTH_LONG).show();
//				} catch (WriterException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					Toast.makeText(CreatQCordActivity.this, "error",Toast.LENGTH_LONG).show();
//				}
//			}
//		});
//	}
//
//	private class  MyAsyncTask extends AsyncTask<String [], Integer, Bitmap>{
//
//
//		public MyAsyncTask() {
//			// TODO Auto-generated constructor stub
//		}
//
//		@Override
//		protected Bitmap doInBackground(String[]... arg0) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		protected void onPostExecute(Bitmap result) {
//			// TODO Auto-generated method stub
//			super.onPostExecute(result);
//		}
//
//
//	}
//
//
//
//
//
//
//}
