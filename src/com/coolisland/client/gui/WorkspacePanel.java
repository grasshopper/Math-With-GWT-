package com.coolisland.client.gui;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class WorkspacePanel extends Widget {
	private ScrollPanel  scrollerPanel       = null;
	private DockPanel    theDockPanel        = null;
	private List<String> theWorkspaceContent = null;

	public WorkspacePanel() {
		initialize();
	}

	/**
	 * initializes the navigation panel with some hard coded strings
	 */
	private void initialize() {
		String hardCodedText = "This is a <code>ScrollPanel</code> contained at "
		        + "the center of a <code>DockPanel</code>.  "
		        + "By putting some fairly large contents "
		        + "in the middle and setting its size explicitly, it becomes a "
		        + "scrollable area within the page, but without requiring the use of "
		        + "an IFRAME.<br><br>"
		        + "Here's quite a bit more meaningless text that will serve primarily "
		        + "to make this thing scroll off the bottom of its visible area.  "
		        + "Otherwise, you might have to make it really, really small in order "
		        + "to see the nifty scroll bars! " + "Additional text to create scroll bar "
		        + "also setting the <B>ScrollPanel height</B> to 40px "
		        + "Setting the <i>HTML height</i> to 50px";

		theWorkspaceContent = new ArrayList<String>();
		theWorkspaceContent.add(hardCodedText);

		// initialize the DockPanel
		theDockPanel = new DockPanel();

		if (theDockPanel != null) {
			// indentation/border between text and frame
			theDockPanel.setSpacing(3);

			theDockPanel.setHorizontalAlignment(DockPanel.ALIGN_LEFT);
			theDockPanel.setVerticalAlignment(DockPanel.ALIGN_TOP);

			theDockPanel.setHeight("100%");
			theDockPanel.setWidth("100%");

			theDockPanel.setStyleName("workspace-panel");
		} else {
			System.out.println("Unable to create dock panels");
			throw new NullPointerException("Unable to initialize the dock panel");
		}

		/*
		 * redraw the panel
		 */
		redraw();
	}

	/**
	 * returns the Workspace panel as a widget
	 * 
	 * @return the Workspace panel as a widget
	 */
	public Widget getWidget() {
		return theDockPanel;
	}

	/**
	 * clears all the contents from the workspace panel
	 */
	public void reset() {

		Log.debug(this.getClass().getName() + ".reset()");

		theWorkspaceContent = null;
		if (theDockPanel != null) {
			theDockPanel.clear();
		} else {
			Log.error("Unable to create theDockPanel panels");
			throw new NullPointerException("Unable to initialize the theDockPanel panel");
		}

		printPanelInfo();
	}

	/**
	 * adds a link to the navigation panel
	 */
	public void addContent(String content) {
		if (content == null) {
			return;
		}

		Log.debug(this.getClass().getName() + ".addLink() content:" + content);

		/*
		 * initialize the content if needed
		 */
		if (theWorkspaceContent == null) {
			theWorkspaceContent = new ArrayList<String>();
		}

		/*
		 * add the new content to the list and redraw the navigation menu
		 */
		theWorkspaceContent.add(content);
		redraw();
	}

	private void redraw() {
		Log.debug(this.getClass().getName() + ".addLink() redraw");

		if (theWorkspaceContent != null) {
			Log.debug("theWorkspaceContent size:" + theWorkspaceContent.size());
		} else {
			Log.debug("theWorkspaceContent is null");
		}

		// debugging
		printPanelInfo();

		// initialize the scroller panel
		scrollerPanel = new ScrollPanel();

		if (theDockPanel != null && scrollerPanel != null) {
			/*
			 * add all the content to the vertical panel
			 */
			for (String content : theWorkspaceContent) {
				HTML link = new HTML(content);
				link.setStylePrimaryName("workspace-panel-content");

				scrollerPanel.add(link);
			}

			theDockPanel.add(scrollerPanel, DockPanel.WEST);
			theDockPanel.setCellHorizontalAlignment(scrollerPanel, DockPanel.ALIGN_LEFT);
			theDockPanel.setCellVerticalAlignment(scrollerPanel, DockPanel.ALIGN_TOP);

			theDockPanel.setCellHeight(scrollerPanel, "100%");
			theDockPanel.setCellWidth(scrollerPanel, "100%");
		} else {
			System.out.println("Unable to create dock panels");
			throw new NullPointerException("Unable to initialize the dock panel");
		}

	}

	private void printPanelInfo() {
		if (theDockPanel != null) {
			int numWidgets = theDockPanel.getWidgetCount();

			Log.debug("Workspace Panel: " + theDockPanel.toString());

			Log.debug("Workspace Panel has " + numWidgets + " widgets.");

			for (int i = 0; i < numWidgets; i++) {
				Widget widget = theDockPanel.getWidget(i);
				Log.debug("Widget: " + widget.toString());

				Element element = (Element) widget.getElement();
				Log.debug(element.getString());
				Log.debug("Element: " + element.toString());
			}
		}
	}

}
