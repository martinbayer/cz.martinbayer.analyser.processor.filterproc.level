package cz.martinbayer.analyser.processor.filterproc.level;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;

import cz.martinbayer.analyser.impl.ConcreteE4LogsisLog;
import cz.martinbayer.analyser.processor.filterproc.level.paletteitem.FilterByLevelPaletteItem;
import cz.martinbayer.analyser.processor.filterproc.level.processor.FilterByLevelProcLogic;
import cz.martinbayer.analyser.processor.filterproc.level.processor.gui.FilterByLevelDialog;
import cz.martinbayer.analyser.processor.filterproc.level.processor.gui.FilterByLevelDialogModel;
import cz.martinbayer.analyser.processors.IProcessorItemWrapper;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.IProcessorsPaletteItem;

public class FilterLevelWrapper implements
		IProcessorItemWrapper<ConcreteE4LogsisLog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5763664933550844593L;
	private FilterByLevelProcLogic logic;
	private FilterByLevelPaletteItem item;
	private FilterByLevelDialogModel model = new FilterByLevelDialogModel();

	public FilterLevelWrapper() {
		logic = new FilterByLevelProcLogic();
		item = new FilterByLevelPaletteItem();
	}

	@Override
	public IProcessorLogic<ConcreteE4LogsisLog> getProcessorLogic() {
		return logic;
	}

	@Override
	public IProcessorsPaletteItem getProcessorPaletteItem() {
		return item;
	}

	@Override
	public void mouseDoubleClicked(MouseEvent e) {
		FilterByLevelDialog dialog = new FilterByLevelDialog(Display
				.getDefault().getActiveShell(), model, logic);
		dialog.open();
	}

	@Override
	public IProcessorItemWrapper<ConcreteE4LogsisLog> getInstance() {
		return new FilterLevelWrapper();
	}

}
