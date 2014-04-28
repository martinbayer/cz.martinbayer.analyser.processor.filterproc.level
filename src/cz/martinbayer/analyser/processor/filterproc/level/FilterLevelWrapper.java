package cz.martinbayer.analyser.processor.filterproc.level;

import org.eclipse.e4.core.contexts.IEclipseContext;
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
	}

	@Override
	public IProcessorLogic<ConcreteE4LogsisLog> getProcessorLogic() {
		if (logic == null) {
			logic = new FilterByLevelProcLogic();
		}
		return logic;
	}

	@Override
	public IProcessorsPaletteItem getProcessorPaletteItem() {
		if (item == null) {
			item = new FilterByLevelPaletteItem();
		}
		return item;
	}

	@Override
	public void mouseDoubleClicked(MouseEvent e) {
		FilterByLevelDialog dialog = new FilterByLevelDialog(Display
				.getDefault().getActiveShell(), model,
				(FilterByLevelProcLogic) getProcessorLogic());
		dialog.open();
	}

	@Override
	public IProcessorItemWrapper<ConcreteE4LogsisLog> getInstance() {
		return new FilterLevelWrapper();
	}

	@Override
	public void setContext(IEclipseContext ctx) {
		Activator.setEclipseContext(ctx);
	}

}
