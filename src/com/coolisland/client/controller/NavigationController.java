package com.coolisland.client.controller;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.gui.NavigationPanel;
import com.coolisland.client.model.NavigationModel;

public class NavigationController {

	private NavigationController() {
		Log.debug("Constructor NavigationController() starting");

		initialize();

		Log.debug("Constructor NavigationController() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of NavigationController.getInstance() or the
	 * first access to SingletonHolder.theNavigationControllerSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final NavigationController theNavigationControllerSingletonInst = new NavigationController();
	}

	public static NavigationController getInstance() {
		Log.debug("NavigationController.getInstance() starting");

		return SingletonHolder.theNavigationControllerSingletonInst;
	}

	/**
	 * initializes the navigation panel view and model
	 */
	public void initialize() {
		Log.debug(this.getClass().getName() + ".initialize() starting");

		/*
		 * build the navigation links...
		 */
		for (int i = 1; i < 10; i++) {
			String linkLabel = "Link " + i;
			NavigationModel.getInstance().addLink(linkLabel);
		}

		/*
		 * initialize the view
		 */
		NavigationPanel.getInstance().initialize();

		Log.debug(this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * resets the navigation panel view and model
	 */
	public void reset() {
		Log.debug(this.getClass().getName() + ".reset() starting");

		Log.debug(this.getClass().getName() + ".reset()");

		NavigationModel.getInstance().reset();
		NavigationPanel.getInstance().reset();
		initialize();

		Log.debug(this.getClass().getName() + ".reset() finished");
	}

	public void printDebugInfo() {
		Log.debug(this.getClass().getName() + ".printDebugInfo() starting");

		NavigationModel.getInstance().printDebugInfo();
		NavigationPanel.getInstance().printDebugInfo();

		Log.debug(this.getClass().getName() + ".printDebugInfo() finished");
	}

}
