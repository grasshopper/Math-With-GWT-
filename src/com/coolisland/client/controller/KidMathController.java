package com.coolisland.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.gui.AdsPanel;
import com.coolisland.client.gui.NavigationPanel;
import com.coolisland.client.model.KidMathModel;
import com.coolisland.client.model.NavigationModel;

public class KidMathController {
	private KidMathController() {
		Log.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);
		Log.debug("Constructor KidMathController() starting");

		initialize();

		Log.debug("Constructor KidMathController() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of KidMathController.getInstance() or the
	 * first access to SingletonHolder.theKidMathControllerSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final KidMathController theKidMathControllerSingletonInst = new KidMathController();
	}

	public static KidMathController getInstance() {
		Log.debug("KidMathController.getInstance() starting");

		return SingletonHolder.theKidMathControllerSingletonInst;
	}

	/**
	 * initializes all the panel views, models, and controllers
	 */
	public void initialize() {
		Log.debug(this.getClass().getName() + ".initialize() starting");

		/*
		 * initialize the general model
		 */
		Log.debug(this.getClass().getName() + ".initialize() initializing KidMathModel");
		KidMathModel.getInstance().initialize();

		/*
		 * initialize the navigation panel
		 */

		/*
		 * initialize the specific models
		 */

		/*
		 * initialize the specific controllers
		 */
		Log.debug(this.getClass().getName() + ".initialize() initializing NavigationController");
		NavigationController.getInstance().initialize();

		/*
		 * initialize the specific panels
		 */
		Log.debug(this.getClass().getName() + ".initialize() initializing NavigationPanel");
		NavigationPanel.getInstance().initialize();

		Log.debug(this.getClass().getName() + ".initialize() initializing AdsPanel");
		AdsPanel.getInstance().initialize();

		Log.debug(this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * resets the panel views and models
	 */
	public void reset() {
		Log.debug(this.getClass().getName() + ".reset() starting");

		initialize();

		Log.debug(this.getClass().getName() + ".reset() finished");
	}

	public void printDebugInfo() {
		Log.debug(this.getClass().getName() + ".printDebugInfo() starting");

		NavigationModel.getInstance().printDebugInfo();
		NavigationPanel.getInstance().printDebugInfo();
		AdsPanel.getInstance().printDebugInfo();

		Log.debug(this.getClass().getName() + ".printDebugInfo() finished");
	}

}
