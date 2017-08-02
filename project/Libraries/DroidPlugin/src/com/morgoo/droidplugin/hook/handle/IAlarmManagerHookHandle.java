package com.morgoo.droidplugin.hook.handle;

import android.content.Context;
import android.text.TextUtils;

import com.morgoo.droidplugin.hook.BaseHookHandle;
import com.morgoo.droidplugin.hook.HookedMethodHandler;

import java.lang.reflect.Method;

/**
 * author：lyno9527
 * email：lyno9527@163.com
 * date：17/5/9 上午9:59
 */

public class IAlarmManagerHookHandle extends BaseHookHandle {

    public IAlarmManagerHookHandle(Context hostContext) {
        super(hostContext);
    }

    @Override
    protected void init() {
        //IAlarmManager.aidl
        sHookedMethodHandlers.put("set", new set(mHostContext));
        sHookedMethodHandlers.put("setTime", new setTime(mHostContext));
        sHookedMethodHandlers.put("setTimeZone", new setTimeZone(mHostContext));
        sHookedMethodHandlers.put("remove",new remove(mHostContext));
        sHookedMethodHandlers.put("getNextWakeFromIdleTime", new getNextWakeFromIdleTime(mHostContext));
        sHookedMethodHandlers.put("getNextAlarmClock", new getNextAlarmClock(mHostContext));

        //AlarmManager.java
        sHookedMethodHandlers.put("setRepeating", new setRepeating(mHostContext));
        sHookedMethodHandlers.put("setWindow", new setWindow(mHostContext));
        sHookedMethodHandlers.put("setExact", new setExact(mHostContext));
        sHookedMethodHandlers.put("setIdleUntil", new setIdleUntil(mHostContext));
        sHookedMethodHandlers.put("setAlarmClock", new setAlarmClock(mHostContext));
        sHookedMethodHandlers.put("setInexactRepeating", new setInexactRepeating(mHostContext));
        sHookedMethodHandlers.put("setAndAllowWhileIdle", new setAndAllowWhileIdle(mHostContext));
        sHookedMethodHandlers.put("setExactAndAllowWhileIdle", new setExactAndAllowWhileIdle(mHostContext));
        sHookedMethodHandlers.put("cancel", new cancel(mHostContext));


    }

    private class AlarmBaseHandler extends HookedMethodHandler {

        public AlarmBaseHandler(Context hostContext) {
            super(hostContext);
        }

        @Override
        protected boolean beforeInvoke(Object receiver, Method method, Object[] args) throws Throwable {
            return super.beforeInvoke(receiver, method, args);
        }
    }

    private class set extends AlarmBaseHandler {

        public set(Context hostContext) {
            super(hostContext);
        }

        @Override
        protected boolean beforeInvoke(Object receiver, Method method, Object[] args) throws Throwable {
            //callingPackage,from Android N 7.0.0_r1
            final int index = 0;
            if (args != null && args.length > index && args[index] instanceof String) {
                String callingPackage = (String) args[index];
                if (!TextUtils.equals(callingPackage, mHostContext.getPackageName())) {
                    args[index] = mHostContext.getPackageName();
                }
            }
            return super.beforeInvoke(receiver, method, args);
        }
    }

    private class setRepeating extends AlarmBaseHandler {

        public setRepeating(Context hostContext) {
            super(hostContext);
        }
    }

    private class setWindow extends AlarmBaseHandler {
        public setWindow(Context hostContext) {
            super(hostContext);
        }
    }

    private class setExact extends AlarmBaseHandler {
        public setExact(Context hostContext) {
            super(hostContext);
        }
    }

    private class setIdleUntil extends AlarmBaseHandler {
        public setIdleUntil(Context hostContext) {
            super(hostContext);
        }
    }

    private class setAlarmClock extends AlarmBaseHandler {
        public setAlarmClock(Context hostContext) {
            super(hostContext);
        }
    }

    private class setInexactRepeating extends AlarmBaseHandler {
        public setInexactRepeating(Context hostContext) {
            super(hostContext);
        }
    }

    private class setAndAllowWhileIdle extends AlarmBaseHandler {
        public setAndAllowWhileIdle(Context hostContext) {
            super(hostContext);
        }
    }

    private class setExactAndAllowWhileIdle extends AlarmBaseHandler {
        public setExactAndAllowWhileIdle(Context hostContext) {
            super(hostContext);
        }
    }

    private class cancel extends AlarmBaseHandler {
        public cancel(Context hostContext) {
            super(hostContext);
        }
    }

    private class setTime extends AlarmBaseHandler {
        public setTime(Context hostContext) {
            super(hostContext);
        }
    }

    private class setTimeZone extends AlarmBaseHandler {
        public setTimeZone(Context hostContext) {
            super(hostContext);
        }
    }

    private class getNextWakeFromIdleTime extends AlarmBaseHandler {
        public getNextWakeFromIdleTime(Context hostContext) {
            super(hostContext);
        }
    }

    private class getNextAlarmClock extends AlarmBaseHandler {
        public getNextAlarmClock(Context hostContext) {
            super(hostContext);
        }
    }

    private class remove extends AlarmBaseHandler{
        public remove(Context hostContext) {
            super(hostContext);
        }
    }


}
