package com.coolisland.client.gui;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class CopyRightPanel extends Widget {
	private HTML      text          = null;
	private DockPanel dockPanel     = null;
	private String    hardCodedText = "Copyright 2009...";

	public CopyRightPanel() {
		text = new HTML(hardCodedText);

		// initialize the DockPanel
		dockPanel = new DockPanel();
		if (dockPanel != null) {
			// indentation/border between text and frame
			dockPanel.setSpacing(3);

			dockPanel.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
			dockPanel.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);

			dockPanel.add(text, DockPanel.SOUTH);

			dockPanel.setCellHorizontalAlignment(text, DockPanel.ALIGN_LEFT);
			dockPanel.setCellVerticalAlignment(text, DockPanel.ALIGN_TOP);

			dockPanel.setHeight("100%");
			dockPanel.setCellHeight(text, "100%");

			dockPanel.setWidth("100%");
			dockPanel.setCellWidth(text, "100%");

			dockPanel.setStyleName("copyright-panel");
		} else {
			System.out.println("Unable to create dockPanel panels");
			throw new NullPointerException("Unable to initialize the dockPanel panel");
		}
	}

	public Widget getWidget() {
		return dockPanel;
	}

}
