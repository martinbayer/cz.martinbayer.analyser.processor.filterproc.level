package cz.martinbayer.analyser.processor.filterproc.level.paletteitem;

import cz.martinbayer.analyser.processors.BasicProcessorPaletteItem;

public class FilterByLevelPaletteItem extends BasicProcessorPaletteItem {

	private static final String LABEL = "Level base filter";

	public FilterByLevelPaletteItem() {
		imagePath = "images/icon.png";
		disabledImagePath = "images/icon_dis.png";
	}

	@Override
	public String getLabel() {
		return LABEL;
	}
}
