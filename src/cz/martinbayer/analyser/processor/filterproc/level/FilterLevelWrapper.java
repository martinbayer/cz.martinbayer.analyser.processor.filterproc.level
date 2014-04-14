package cz.martinbayer.analyser.processor.filterproc.level;

import org.eclipse.swt.events.MouseEvent;

import cz.martinbayer.analyser.impl.ConcreteXMLog;
import cz.martinbayer.analyser.processor.filterproc.level.paletteitem.FilterByLevelPaletteItem;
import cz.martinbayer.analyser.processor.filterproc.level.processor.FilterByLevelProcLogic;
import cz.martinbayer.analyser.processors.IProcessorItemWrapper;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.IProcessorsPaletteItem;

public class FilterLevelWrapper implements IProcessorItemWrapper<ConcreteXMLog> {

	private FilterByLevelProcLogic logic;
	private FilterByLevelPaletteItem item;

	public FilterLevelWrapper() {
		logic = new FilterByLevelProcLogic();
		item = new FilterByLevelPaletteItem();
	}

	@Override
	public IProcessorLogic<ConcreteXMLog> getProcessorLogic() {
		return logic;
	}

	@Override
	public IProcessorsPaletteItem getProcessorPaletteItem() {
		return item;
	}

	@Override
	public void mouseDoubleClicked(MouseEvent e) {
		System.out.println(getProcessorLogic().getProcessor()
				.getNextProcsCount());
	}

	@Override
	public IProcessorItemWrapper<ConcreteXMLog> getInstance() {
		return new FilterLevelWrapper();
	}

}
