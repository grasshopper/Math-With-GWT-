package com.coolisland.client.gui;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class TitlePanel extends Widget {
	private HTML      text          = null;
	private DockPanel dockPanel     = null;
	private String    hardCodedText = "<P>Kids Math</P>";

	public TitlePanel() {
		text = new HTML(hardCodedText);
		text.setStyleName("title-text");

		// initialize the DockPanel
		dockPanel = new DockPanel();
		// horizontalPanel = new HorizontalPanel();
		if (dockPanel != null) {
			// indentation/border between text and frame
			dockPanel.setSpacing(3);

			dockPanel.add(text, DockPanel.CENTER);
			dockPanel.setCellHorizontalAlignment(text, DockPanel.ALIGN_CENTER);
			dockPanel.setCellVerticalAlignment(text, DockPanel.ALIGN_MIDDLE);
			dockPanel.setWidth("100%");
			dockPanel.setCellWidth(text, "100%");

			dockPanel.setStyleName("title-panel");
		} else {
			System.out.println("Unable to create dockPanel panels");
			throw new NullPointerException("Unable to initialize the dockPanel panel");
		}
	}

	public Widget getWidget() {
		// return horizontalPanel;
		return dockPanel;
	}

}
