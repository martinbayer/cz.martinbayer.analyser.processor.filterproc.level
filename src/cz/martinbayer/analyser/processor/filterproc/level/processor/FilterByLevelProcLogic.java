package cz.martinbayer.analyser.processor.filterproc.level.processor;

import cz.martinbayer.analyser.impl.ConcreteData;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class FilterByLevelProcLogic implements IProcessorLogic<ConcreteData> {

	private FilterByLevelProcessor processor;
	public FilterByLevelProcLogic(){
		this.processor = new FilterByLevelProcessor();
	}
	
	@Override
	public LogProcessor<ConcreteData> getProcessor() {
		return this.processor;
	}

}
