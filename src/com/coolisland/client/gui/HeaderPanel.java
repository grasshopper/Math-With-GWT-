package com.coolisland.client.gui;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class HeaderPanel extends Widget {
	private HTML      text          = null;
	private DockPanel dockPanel     = null;
	private String    hardCodedText = "<P>Header Panel</P>";

	public HeaderPanel() {
		text = new HTML(hardCodedText);

		// initialize the DockPanel
		dockPanel = new DockPanel();

		if (dockPanel != null) {
			// indentation/border between text and frame
			dockPanel.setSpacing(3);

			dockPanel.add(text, DockPanel.NORTH);
			dockPanel.setCellHorizontalAlignment(text, DockPanel.ALIGN_LEFT);
			dockPanel.setCellVerticalAlignment(text, DockPanel.ALIGN_MIDDLE);
			dockPanel.setWidth("100%");
			dockPanel.setCellWidth(text, "100%");

			dockPanel.setStyleName("header-panel");
		} else {
			System.out.println("Unable to create dock panels");
			throw new NullPointerException("Unable to initialize the dock panel");
		}

	}

	public Widget getWidget() {
		return dockPanel;
	}

}
