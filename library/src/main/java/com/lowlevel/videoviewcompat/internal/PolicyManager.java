package com.lowlevel.videoviewcompat.internal;

import java.lang.reflect.Method;

import android.content.Context;
import android.view.Window;

public class PolicyManager {
	/*
	 * Private constants
	 */
    private static final String POLICY_MANAGER_CLASS_NAME = "com.android.internal.policy.PolicyManager";

    
    private PolicyManager() {
    }

    
    /*
     * Public methods
     */
    public static Window makeNewWindow(Context context) {
    	try {
            /* Find class */
            Class<?> c = Class.forName(POLICY_MANAGER_CLASS_NAME);

	    	/* Find method */
			Method m = c.getMethod("makeNewWindow", Context.class);
	    	
	    	/* Invoke method */
	        return (Window)m.invoke(null, context);
    	}
        catch (ClassNotFoundException e) {
            throw new RuntimeException(POLICY_MANAGER_CLASS_NAME + " could not be loaded", e);
        }
    	catch (Exception e) {
    		throw new RuntimeException(POLICY_MANAGER_CLASS_NAME + ".makeNewWindow could not be invoked", e);
    	}
    }
}
