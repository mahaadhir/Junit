package com.stepdefinition.amazon;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Clothes.class, TvPurchase.class})

public class TestRunner {
	
    public static void main(String[] args) {
		
    	Result runClasses = JUnitCore.runClasses(Clothes.class, TvPurchase.class);
    	runClasses.getRunCount();
	}
	

}
