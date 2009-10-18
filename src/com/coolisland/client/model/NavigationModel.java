/**
 * 
 */
package com.coolisland.client.model;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;

/**
 * @author Silvio Nunes
 */
public class NavigationModel {
	private List<String> theNavigationLinks = null;

	/**
	 * Private constructor prevents instantiation from other classes
	 */
	private NavigationModel() {
		Log.debug(this.getClass().getName() + ".Constructor NavigationModel() starting");

		initialize();

		Log.debug(this.getClass().getName() + ".Constructor NavigationModel() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of NavigationModel.getInstance() or the
	 * first access to SingletonHolder.theNavigationModelSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final NavigationModel theNavigationModelSingletonInst = new NavigationModel();
	}

	public static NavigationModel getInstance() {
		Log.debug("NavigationModel.getInstance() starting");

		return SingletonHolder.theNavigationModelSingletonInst;
	}

	/**
	 * initialize the object
	 */
	private void initialize() {
		Log.debug(this.getClass().getName() + ".initialize() starting");

		theNavigationLinks = new ArrayList<String>();

		Log.debug(this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * add a link to the navigation model
	 */
	public void addLink(String linkLabel) {
		Log.debug(this.getClass().getName() + ".addLink() starting");

		if (linkLabel == null) {
			return;
		}

		Log.debug(this.getClass().getName() + ".addLink() linkLabel:" + linkLabel);

		/*
		 * initialize the navigation links if needed
		 */
		if (theNavigationLinks == null) {
			theNavigationLinks = new ArrayList<String>();
		}

		/*
		 * add the new link to the navigation link list and redraw the navigation menu
		 */
		theNavigationLinks.add(linkLabel);

		Log.debug(this.getClass().getName() + ".addLink() finished");
	}

	public void reset() {
		Log.debug(this.getClass().getName() + ".reset() starting");

		theNavigationLinks = null;

		Log.debug(this.getClass().getName() + ".reset() finished");
	}

	public List<String> getNavigationLinks() {
		Log.debug(this.getClass().getName() + ".getNavigationLinks() starting");

		return theNavigationLinks;
	}

	public void printDebugInfo() {
		Log.debug(this.getClass().getName() + ".printDebugInfo() starting");

		if (theNavigationLinks != null) {
			Log.debug("Number of navigation links:  " + theNavigationLinks.size());

			int numLinks = theNavigationLinks.size();
			for (int i = 0; i < numLinks; i++) {
				Log.debug("Link[" + i + "]: " + theNavigationLinks.get(i));
			}
		}

		Log.debug(this.getClass().getName() + ".printDebugInfo() finished");
	}

}
