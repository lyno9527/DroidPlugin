package com.morgoo.droidplugin.hook.binder;

import android.content.Context;
import android.os.IBinder;

import com.morgoo.droidplugin.hook.BaseHookHandle;
import com.morgoo.droidplugin.hook.handle.IAlarmManagerHookHandle;
import com.morgoo.helper.compat.IAlarmManagerCompat;

/**
 * author：lyno9527
 * email：lyno9527@163.com
 * date：17/5/9 上午10:41
 */

public class IAlarmManagerHook extends BinderHook {

    private final static String ALARM_SERVICE = "alarm";

    public IAlarmManagerHook(Context hostContext) {
        super(hostContext);
    }

    @Override
    protected BaseHookHandle createHookHandle() {
        return new IAlarmManagerHookHandle(mHostContext);
    }

    @Override
    Object getOldObj() throws Exception {
        IBinder iBinder = MyServiceManager.getOriginService(ALARM_SERVICE);
        return IAlarmManagerCompat.asInterface(iBinder);
    }

    @Override
    public String getServiceName() {
        return ALARM_SERVICE;
    }
}
