package cz.martinbayer.analyser.processor.filterproc.level.processor;

import cz.martinbayer.analyser.impl.ConcreteXMLog;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class FilterByLevelProcLogic implements IProcessorLogic<ConcreteXMLog> {

	private FilterByLevelProcessor processor;
	public FilterByLevelProcLogic(){
		this.processor = new FilterByLevelProcessor();
	}
	
	@Override
	public LogProcessor<ConcreteXMLog> getProcessor() {
		return this.processor;
	}

}
