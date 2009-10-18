package com.coolisland.client.gui;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.controller.KidMathController;
import com.coolisland.client.model.KidMathModel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ScreenManager extends Widget {
	private DockPanel                   dock              = null;
	private VerticalPanel               verticalPanel     = null;
	final private static WorkspacePanel theWorkspacePanel = new WorkspacePanel();

	public ScreenManager() {
		Log.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);
		Log.debug("Constructor ScreenManager() starting");

		initialize();

		Log.debug("Constructor ScreenManager() finished");
	}

	/**
	 * Initialize all the panels
	 */
	private void initialize() {
		Log.debug(this.getClass().getName() + ".initialize() starting");

		dock = new DockPanel();

		verticalPanel = new VerticalPanel();

		if (dock != null) {
			// Allow 4 pixels of spacing between each cell
			dock.setSpacing(5);
			dock.setWidth("100%");

			/*
			 * Center each component horizontally within each cell for each component added after
			 * this call. A shortcut to calling dock.setCellHorizontalAlignment() for each cell.
			 */
			dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);

			// create the title panel
			TitlePanel title = new TitlePanel();
			dock.add(title.getWidget(), DockPanel.NORTH);

			// create the copyright panel
			CopyRightPanel copyrightPanel = new CopyRightPanel();
			dock.add(copyrightPanel.getWidget(), DockPanel.SOUTH);

			/*
			 * initialize the models and controllers
			 */
			Log.debug(this.getClass().getName()
			        + ".initialize()  calling KidMathController.initialize()");
			KidMathController.getInstance().initialize();

			Log.debug(this.getClass().getName()
			        + ".initialize()  calling KidMathController.printDebugInfo()");
			KidMathController.getInstance().printDebugInfo();

			Log.debug(this.getClass().getName()
			        + ".initialize()  calling KidMathModel.printDebugInfo()");
			KidMathModel.getInstance().printDebugInfo();

			// create the ads panel
			dock.add(AdsPanel.getInstance().getWidget(), DockPanel.EAST);
			AdsPanel.getInstance().draw();

			// create the navigation panel
			// NavigationController.getInstance().reset();
			// NavigationPanel.getInstance().printDebugInfo();
			// NavigationModel.getInstance().printDebugInfo();
			// NavigationController.getInstance().printDebugInfo();

			Log.debug(this.getClass().getName()
			        + ".initialize()  adding NavigationPanel to dockpanel");
			dock.add(NavigationPanel.getInstance().getWidget(), DockPanel.WEST);
			// NavigationPanel.getInstance().draw();

			// create the header panel
			HeaderPanel headerPanel = new HeaderPanel();
			dock.add(headerPanel.getWidget(), DockPanel.NORTH);

			// create the footer panel
			FooterPanel footerPanel = new FooterPanel();
			dock.add(footerPanel.getWidget(), DockPanel.SOUTH);

			// Add a workspace panel in the center
			dock.add(theWorkspacePanel.getWidget(), DockPanel.CENTER);

			// add all the vertical panels to a vertical panel
			verticalPanel.add(dock);
		} else {
			System.out.println("Unable to create dock panels");
			throw new NullPointerException("Unable to initialize the dock panel");
		}

		Log.debug(this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * Returns the workspace panel
	 * 
	 * @return workspace panel
	 */
	public Widget getWorkSpace() {
		Log.debug(this.getClass().getName() + ".getWorkSpace()");

		return theWorkspacePanel;
	}

	// /**
	// * Adds a link to the navigation panel
	// *
	// * @param linkLabel
	// */
	// public void addLinkToNavigationPanel(String linkLabel) {
	// theNavigationModel.addLink(linkLabel);
	// }

	// /**
	// * resets the content of the navigation panel
	// */
	// public void resetNavigationPanel() {
	// theNavigationPanel.reset();
	// }

	/**
	 * resets the content of the workspace panel
	 */
	public void resetWorkspacePanel() {
		Log.debug(this.getClass().getName() + ".resetWorkspacePanel() starting");

		theWorkspacePanel.reset();

		Log.debug(this.getClass().getName() + ".resetWorkspacePanel() finished");
	}

	/**
	 * Adds a link to the navigation panel
	 * 
	 * @param linkLabel
	 */
	public void addContentToWorkspacePanel(String content) {
		Log.debug(this.getClass().getName() + ".addContentToWorkspacePanel() starting");

		theWorkspacePanel.addContent(content);

		Log.debug(this.getClass().getName() + ".addContentToWorkspacePanel() finished");
	}

	/**
	 * Returns the Navigation Panel
	 * 
	 * @return navigation panel
	 */
	public Widget getWidget() {
		Log.debug(this.getClass().getName() + ".getWidget()");

		// return dock;
		return verticalPanel;
	}

}
