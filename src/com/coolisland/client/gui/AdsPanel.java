package com.coolisland.client.gui;

import com.allen_sauer.gwt.log.client.Log;
import com.coolisland.client.model.KidMathModel;
import com.coolisland.client.view.PanelViewAbstract;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class AdsPanel extends PanelViewAbstract {
	private AdsPanel() {
		super();

		Log.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);
		Log.debug("Constructor AdsPanel() starting");

		// initialize the Panel
		initialize();

		Log.debug("Constructor AdsPanel() finished");
	}

	/**
	 * SingletonHolder is loaded on the first execution of AdsPanel.getInstance() or the first
	 * access to SingletonHolder.theAdsPanelSingletonInst, not before.
	 */
	private static class SingletonHolder {
		private static final AdsPanel theAdsPanelSingletonInst = new AdsPanel();
	}

	public static AdsPanel getInstance() {
		Log.debug("AdsPanel.getInstance()");

		return SingletonHolder.theAdsPanelSingletonInst;
	}

	public void initialize() {
		Log.debug(this.getClass().getName() + ".initialize() starting");

		HTML text = KidMathModel.getInstance().getAdsData();

		// initialize the DockPanel
		theDockPanel = new DockPanel();
		if (theDockPanel != null) {
			// indentation/border between text and frame
			theDockPanel.setSpacing(3);

			theDockPanel.setHorizontalAlignment(DockPanel.ALIGN_RIGHT);
			theDockPanel.setVerticalAlignment(DockPanel.ALIGN_TOP);

			theDockPanel.add(text, DockPanel.WEST);
			theDockPanel.setCellHorizontalAlignment(text, DockPanel.ALIGN_LEFT);
			theDockPanel.setCellVerticalAlignment(text, DockPanel.ALIGN_TOP);

			theDockPanel.setHeight("100%");
			theDockPanel.setCellHeight(text, "100%");

			theDockPanel.setWidth("100%");
			theDockPanel.setCellWidth(text, "100%");

			theDockPanel.setStyleName("advertisement-panel");
		} else {
			System.out.println("Unable to create the advertisementat panel");
			throw new NullPointerException("Unable to create the advertisementat panel");
		}

		Log.debug(this.getClass().getName() + ".initialize() finished");
	}

	@Override
	public void draw() {
		Log.debug(this.getClass().getName() + ".draw() starting");

		initialize();

		Log.debug(this.getClass().getName() + ".draw() finished");
	}

	@Override
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

		Log.debug(this.getClass().getName() + ".printDebugInfo() finished");
	}

	@Override
	public void reset() {
		Log.debug(this.getClass().getName() + ".reset() starting");

		// TODO Auto-generated method stub

		Log.debug(this.getClass().getName() + ".reset() finished");
	}

}
