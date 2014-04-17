package cz.martinbayer.analyser.processor.filterproc.level.processor;

import cz.martinbayer.analyser.impl.ConcreteE4LogsisLog;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class FilterByLevelProcLogic implements IProcessorLogic<ConcreteE4LogsisLog> {

	private FilterByLevelProcessor processor;
	public FilterByLevelProcLogic(){
		this.processor = new FilterByLevelProcessor();
	}
	
	@Override
	public LogProcessor<ConcreteE4LogsisLog> getProcessor() {
		return this.processor;
	}

}
