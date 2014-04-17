package cz.martinbayer.analyser.processor.filterproc.level.processor;

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
	private ELogLevel actualLevel = ELogLevel.ERROR;

	@Override
	protected void process() throws ProcessorFailedException {
		for (ConcreteE4LogsisLog d : logData.getLogRecords()) {
			if (d.getLogLevel() == actualLevel) {
				d.setRemoved(true);
			}
		}
		setDataForProcessing();
		runNextProcessor();
	}

	@Override
	public void init() {

	}
}
