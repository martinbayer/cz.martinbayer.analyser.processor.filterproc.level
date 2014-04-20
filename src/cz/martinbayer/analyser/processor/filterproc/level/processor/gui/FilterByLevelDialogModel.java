package cz.martinbayer.analyser.processor.filterproc.level.processor.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cz.martinbayer.analyser.processors.model.ELogLevel;
import cz.martinbayer.utils.model.ObservableModelObject;

public class FilterByLevelDialogModel extends ObservableModelObject implements
		Serializable {

	public static final String PROPERTY_SELECTED_LEVELS = "selectedLevels";

	private List<ELogLevel> selectedLevels = new ArrayList<>();

	public final List<ELogLevel> getSelectedLevels() {
		return selectedLevels;
	}

	public final void setSelectedLevels(List<ELogLevel> selectedLevels) {
		firePropertyChange(PROPERTY_SELECTED_LEVELS, this.selectedLevels,
				this.selectedLevels = selectedLevels);
	}
}
