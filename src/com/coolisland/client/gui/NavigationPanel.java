package com.coolisland.client.gui;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.model.NavigationModel;
import com.coolisland.client.view.PanelViewAbstract;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

// FIXME: make this class a singleton
public class NavigationPanel extends PanelViewAbstract {

	private NavigationPanel() {
		super();

		Log.debug("Constructor NavigationPanel() starting");

		// initialize the DockPanel
		initialize();

		Log.debug("Constructor NavigationPanel() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of NavigationPanel.getInstance() or the
	 * first access to SingletonHolder.theNavigationPanelSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final NavigationPanel theNavigationPanelSingletonInst = new NavigationPanel();
	}

	public static NavigationPanel getInstance() {
		Log.debug("NavigationPanel.getInstance()");

		return SingletonHolder.theNavigationPanelSingletonInst;
	}

	/**
	 * initializes the navigation panel with some hard coded strings
	 */
	public void initialize() {
		Log.debug(this.getClass().getName() + ".initialize() starting");

		theDockPanel = new DockPanel();

		if (theDockPanel != null) {
			// indentation/border between text and frame
			theDockPanel.setSpacing(3);

			theDockPanel.setHorizontalAlignment(DockPanel.ALIGN_LEFT);
			theDockPanel.setVerticalAlignment(DockPanel.ALIGN_TOP);

			theDockPanel.setHeight("100%");

			theDockPanel.setStyleName("navigation-panel");
		} else {
			Log.error("Unable to create navigation panel");
			throw new NullPointerException("Unable to initialize the theDockPanel panel");
		}

		Log.debug(this.getClass().getName() + ".initialize() finished");
	}

	/**
	 * 
	 */
	public void printDebugInfo() {
		Log.debug(this.getClass().getName() + ".printDebugInfo() starting");

		if (theDockPanel != null) {
			int numWidgets = theDockPanel.getWidgetCount();

			Log.debug("Navigation Panel: " + theDockPanel.toString());

			Log.debug("Navigation Panel has " + numWidgets + " widgets.");

			for (int i = 0; i < numWidgets; i++) {
				Widget widget = theDockPanel.getWidget(i);
				Log.debug("Widget: " + widget.toString());

				Element element = (Element) widget.getElement();
				Log.debug(element.getString());
				Log.debug("Element: " + element.toString());
			}
		}

		VerticalPanel panel = updateNavigationLinks();
		if (panel != null) {
			int numWidgets = panel.getWidgetCount();

			Log.debug("Navigation Links: " + panel.toString());

			Log.debug("Navigation Links has " + numWidgets + " widgets.");

			for (int i = 0; i < numWidgets; i++) {
				Widget widget = panel.getWidget(i);
				Log.debug("Widget: " + widget.toString());

				Element element = (Element) widget.getElement();
				Log.debug(element.getString());
				Log.debug("Element: " + element.toString());
			}
		}

		Log.debug(this.getClass().getName() + ".printDebugInfo() finished");
	}

	private VerticalPanel updateNavigationLinks() {
		VerticalPanel panel = new VerticalPanel();

		List<String> links = NavigationModel.getInstance().getNavigationLinks();

		if (links != null) {
			Log.debug("Number of navigation links:" + links.size());
		} else {
			Log.debug("There are no Navigation Links (perhaps they have not been initialized)");
		}

		if (panel != null) {
			/*
			 * add all the navigation links to the vertical panel
			 */
			for (String linkLabel : links) {
				HTML link = new HTML(linkLabel);
				link.setStylePrimaryName("navigation-panel-link");

				panel.add(link);
			}
		}

		return panel;
	}

	public void draw() {
		Log.debug(this.getClass().getName() + ".draw() starting");

		VerticalPanel panel = updateNavigationLinks();

		if (panel != null) {
			/*
			 * add the vertical panel to the dock panel
			 */
			if (theDockPanel != null) {
				theDockPanel.clear();
				theDockPanel.add(panel, DockPanel.WEST);
				theDockPanel.setCellHorizontalAlignment(panel, DockPanel.ALIGN_LEFT);
				theDockPanel.setCellVerticalAlignment(panel, DockPanel.ALIGN_TOP);
				theDockPanel.setCellHeight(panel, "100%");
			} else {
				Log.error("Unable to create theDockPanel panels");
				throw new NullPointerException("Unable to initialize the theDockPanel panel");
			}
		}

		// debugging
		printDebugInfo();

		Log.debug(this.getClass().getName() + ".draw() finished");
	}

	@Override
	public void reset() {
		Log.debug(this.getClass().getName() + ".reset() starting");
		Log.debug(this.getClass().getName() + ".reset() finished");
	}

}
