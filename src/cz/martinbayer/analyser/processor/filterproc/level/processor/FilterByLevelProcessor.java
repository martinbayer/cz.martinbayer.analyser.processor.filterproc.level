package cz.martinbayer.analyser.processor.filterproc.level.processor;

import java.util.HashSet;
import java.util.List;

import cz.martinbayer.analyser.impl.ConcreteE4LogsisLog;
import cz.martinbayer.analyser.processors.exception.ProcessorFailedException;
import cz.martinbayer.analyser.processors.model.ELogLevel;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class FilterByLevelProcessor extends LogProcessor<ConcreteE4LogsisLog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8195667757772947068L;
	// all error records will be cutted of
	private HashSet<ELogLevel> levelsToRemove = new HashSet<>();

	@Override
	protected void process() throws ProcessorFailedException {
		for (ConcreteE4LogsisLog d : logData.getLogRecords()) {
			if (levelsToRemove.contains(d.getLogLevel())) {
				d.setRemoved(true);
			}
		}
		setDataForProcessing();
		runNextProcessor();
	}

	@Override
	public void init() {

	}

	public void setLevelsToFilter(List<ELogLevel> selectedLevels) {
		this.levelsToRemove.clear();
		if (selectedLevels != null) {
			this.levelsToRemove.addAll(selectedLevels);
		}
	}
}
