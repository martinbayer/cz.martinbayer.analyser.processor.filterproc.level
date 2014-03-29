package cz.martinbayer.analyser.processor.filterproc.level.processor;

import cz.martinbayer.analyser.impl.ConcreteData;
import cz.martinbayer.analyser.processors.exception.ProcessorFailedException;
import cz.martinbayer.analyser.processors.model.ELogLevel;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class FilterByLevelProcessor extends LogProcessor<ConcreteData> {

	// all error records will be cutted of
	private ELogLevel actualLevel = ELogLevel.ERROR;

	@Override
	protected void process() throws ProcessorFailedException {
		for (ConcreteData d : logData.getLogRecords()) {
			if (d.getLogLevel() == actualLevel) {
				d.setRemoved(true);
			}
		}
		setDataForProcessing();
		runNextProcessor();
	}
}
