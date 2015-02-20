package com.lowlevel.videoviewcompat.internal;

import java.lang.reflect.Method;

import android.content.Context;
import android.view.Window;

public class PolicyManager {
	/*
	 * Private constants
	 */
    private static final String POLICY_MANAGER_CLASS_NAME = "com.android.internal.policy.PolicyManager";

    /*
     * Private variables
     */
    private static final Class<?> cPolicyManager;


    /*
     * Static code
     */
    static {
        try {
        	/* Get policy manager class */
			cPolicyManager = Class.forName(POLICY_MANAGER_CLASS_NAME);
        }
        catch (ClassNotFoundException e) {
            /* Throw exception */
            throw new RuntimeException(POLICY_MANAGER_CLASS_NAME + " could not be loaded", e);
        }
    }

    
    private PolicyManager() {
    }

    
    /*
     * Public methods
     */
    public static Window makeNewWindow(Context context) {
    	try {
	    	/* Find method */
			Method m = cPolicyManager.getMethod("makeNewWindow", Context.class);
	    	
	    	/* Invoke method */
	        return (Window)m.invoke(null, context);
    	}
    	catch (Exception e) {
            /* Throw exception */
    		throw new RuntimeException(POLICY_MANAGER_CLASS_NAME + ".makeNewWindow could not be invoked", e);
    	}
    }
}
