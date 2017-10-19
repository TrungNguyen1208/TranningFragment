package ptit.nttrung.tranningfragment.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import ptit.nttrung.tranningfragment.R;

/**
 * Created by TrungNguyen on 10/14/2017.
 */

public class MessageService extends Service {

    private WindowManager mWindowManager;
    private MyGroupView mViewIcon;
    private WindowManager.LayoutParams mIconViewParam;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initView();
        return START_STICKY;
    }

    private void initView() {
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        createIconView();
        showIcon();
    }

    private void createIconView() {
        mViewIcon = new MyGroupView(this);

        View view = View.inflate(this, R.layout.view_icon, mViewIcon);
        TextView textView = (TextView) view.findViewById(R.id.tv);

        mIconViewParam = new WindowManager.LayoutParams();
        mIconViewParam.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mIconViewParam.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mIconViewParam.gravity = Gravity.CENTER;
        mIconViewParam.format = PixelFormat.TRANSPARENT;
        mIconViewParam.type = WindowManager.LayoutParams.TYPE_PHONE;
        mIconViewParam.flags = WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        mIconViewParam.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        mIconViewParam.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
    }

    private void showIcon() {
        mWindowManager.addView(mViewIcon,mIconViewParam);
    }
}
