package com.coolisland.client;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.gui.ScreenManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.RootPanel;

/*
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class KidMath implements EntryPoint {
	private ScreenManager              theScreenManager = null;

	/**
	 * The message displayed to the user when the server cannot be reached or returns an error.
	 */
	private static final String        SERVER_ERROR     = "An error occurred while "
	                                                            + "attempting to contact the server. Please check your network "
	                                                            + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService  = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Log.setUncaughtExceptionHandler();

		DeferredCommand.addCommand(new Command() {
			public void execute() {
				onModuleLoad2();
			}
		});
	}

	private void onModuleLoad2() {
		RootPanel rootPanel = RootPanel.get();
		Log.debug("Title: " + rootPanel.getTitle());
		Log.debug("Number of widgets in root panel: " + rootPanel.getWidgetCount());

		// add the dock panels to the root panel
		theScreenManager = new ScreenManager();
		rootPanel.add(theScreenManager.getWidget());

		Log.debug("Number of widgets in root panel after ScreenManager(): "
		        + rootPanel.getWidgetCount());

		/*
		 * initialize the navigation panel
		 */
		// initializeNavigationPanel();
	}

	// /**
	// * Initializes the navigation panel
	// */
	// private void initializeNavigationPanel() {
	// Log.debug("Initializing the navigation panel");
	//
	// theScreenManager.resetNavigationPanel();
	//
	// for (int i = 0; i < 10; i++) {
	// theScreenManager.addLinkToNavigationPanel("Link " + i);
	// }
	// }
}
