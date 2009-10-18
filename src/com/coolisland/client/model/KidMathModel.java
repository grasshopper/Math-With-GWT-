package com.coolisland.client.model;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.HTML;

/**
 * @author Silvio Nunes
 */
public class KidMathModel {
	private HTML adsHtml = null;

	/**
	 * Private constructor prevents instantiation from other classes
	 */
	private KidMathModel() {
		Log.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);
		Log.debug("Constructor KidMathModel() starting");

		initialize();

		Log.debug("Constructor KidMathModel() finished");
	}

	/**
	 * initialize the object
	 */
	public void initialize() {
		Log.debug(this.getClass().getName() + ".initialize() starting");

		/*
		 * Initialize the data for the Ads
		 */
		adsHtml = new HTML("Advertisements go here");

		/*
		 * Initialize the data for the Title
		 */

		Log.debug(this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of KidMathModel.getInstance() or the first
	 * access to SingletonHolder.theKidMathModelSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final KidMathModel theKidMathModelSingletonInst = new KidMathModel();
	}

	public static KidMathModel getInstance() {
		Log.debug("KidMathModel.getInstance() starting");

		return SingletonHolder.theKidMathModelSingletonInst;
	}

	public void reset() {
		Log.debug(this.getClass().getName() + ".reset() starting");

		Log.debug(this.getClass().getName() + ".reset() finished");
	}

	public void printDebugInfo() {
		Log.debug(this.getClass().getName() + ".printDebugInfo() starting");

		Log.debug("Ads Panel data: " + this.adsHtml);

		Log.debug(this.getClass().getName() + ".printDebugInfo() finished");
	}

	public HTML getAdsData() {
		Log.debug(this.getClass().getName() + ".getAdsData()");

		return adsHtml;
	}
}
