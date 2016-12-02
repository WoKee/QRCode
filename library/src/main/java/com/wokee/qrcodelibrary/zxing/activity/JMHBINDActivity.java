package com.wokee.qrcodelibrary.zxing.activity;//package com.wokee.qrcode.zxing.activity;
//
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Message;
//
//import com.gf.community.CommunityActivity;
//import com.gf.community.R;
//import com.gf.community.bean.QcordInfo;
//import com.gf.community.bean.RootInfo;
//import com.gf.community.conts.Conts;
//import com.gf.community.manager.CommunityPrivateDataManager;
//import com.gf.community.util.AsyncHttpUtil;
//import com.gf.community.util.HttpManagerUtil;
//import com.gf.community.util.Utils;
//import com.loopj.android.http.TextHttpResponseHandler;
//
//import java.util.Date;
//import java.util.HashMap;
//
//public class JMHBINDActivity extends CommunityActivity {
//
//
//	@Override
//	protected void init() {
//		setContentView(R.layout.pay_result);
//	}
//
//	@Override
//	protected void initEvent() {
//		Bundle extras = getIntent().getExtras();
//		if (null != extras) {
////			int width = extras.getInt("width");
////			int height = extras.getInt("height");
//			String result = extras.getString("result");
//
//			checkQcr(result);
//		}
//	}
//
//
//	private String captchString;
//	private void checkEnd(String responseString){
//		try {
//			RootInfo rootInfo=gson.fromJson(responseString, RootInfo.class);
//			if (rootInfo.isState()) {
//				QcordInfo qcordInfo=gson.fromJson(gson.toJson(rootInfo.getMsg()),QcordInfo.class);
//					captchString=qcordInfo.getId();
//				urlMap=new HashMap<>();
//				urlMap.put(Conts.token, CommunityPrivateDataManager.getToken(getApplicationContext()));
//				urlMap.put(Conts.cardId,qcordInfo.getId());
//				HttpManagerUtil.post(Conts.bindQcrUrl,urlMap,this,handler);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			Utils.showToast(JMHBINDActivity.this, "二维码校验失败，请重试");
//			finish();
//
//		}
//	}
//
//	@Override
//	protected void handlerMessage(Message msg) {
//		super.handlerMessage(msg);
//		switch (msg.what){
//			case HttpManagerUtil.SUC:
//				RootInfo rootInfo= (RootInfo) msg.obj;
//				if (rootInfo.isState()){
//					Intent data=new Intent();
//					getUseInfo().getMemberUser().setCardId(captchString);
//					getUseInfo().getMemberUser().setBindTime(new Date().getTime()+"");
//					data.putExtra(Conts.cardId,captchString);
//					setResult(Activity.RESULT_OK,data);
//				}
//				finish();
//				break;
//
//		}
//	}
//
//	private void checkQcr(String result){
//		showDialog(this,"正在校验...");
//		AsyncHttpUtil.getInstance().get(result+"?flag=xqhz_admin",
//				new TextHttpResponseHandler() {
//					@Override
//					public void onFailure(int statusCode, org.apache.http.Header[] headers, String responseString, Throwable throwable) {
//						dismissDialog();
//						Utils.showToast(JMHBINDActivity.this, "二维码校验失败，请重试");
//						finish();
//					}
//
//					@Override
//					public void onSuccess(int statusCode, org.apache.http.Header[] headers, final String responseString) {
//						dismissDialog();
//						runOnUiThread(new Runnable() {
//							@Override
//							public void run() {
//								checkEnd(responseString);
//							}
//						});
//					}
//
//				});
//	}
//
//}