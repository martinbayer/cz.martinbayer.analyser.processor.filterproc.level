package cz.martinbayer.analyser.processor.filterproc.level.processor;

import java.util.List;

import cz.martinbayer.analyser.impl.ConcreteE4LogsisLog;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.model.ELogLevel;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class FilterByLevelProcLogic implements
		IProcessorLogic<ConcreteE4LogsisLog> {

	private FilterByLevelProcessor processor;

	public FilterByLevelProcLogic() {
		this.processor = new FilterByLevelProcessor();
	}

	@Override
	public LogProcessor<ConcreteE4LogsisLog> getProcessor() {
		return this.processor;
	}

	public void setLevelsToFilter(List<ELogLevel> selectedLevels) {
		this.processor.setLevelsToFilter(selectedLevels);
	}

}
