package cz.martinbayer.analyser.processor.filterproc.level.processor.gui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import cz.martinbayer.analyser.processor.filterproc.level.processor.FilterByLevelProcLogic;
import cz.martinbayer.analyser.processors.model.ELogLevel;

public class FilterByLevelDialog extends TitleAreaDialog {

	private FilterByLevelDialogModel model;
	private Label selectedLevelLabel;
	private ListViewer selectedLevelList;
	private FilterByLevelProcLogic logic;

	public FilterByLevelDialog(Shell parentShell,
			FilterByLevelDialogModel model, FilterByLevelProcLogic logic) {
		super(parentShell);
		this.model = model;
		this.logic = logic;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Filter by log level processor configuration");
		setMessage("Choose level(s) which should be removed from data",
				IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite parentComposite = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(parentComposite, SWT.None);
		container.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true));
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 10;
		container.setLayout(layout);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.RIGHT;
		selectedLevelLabel = new Label(container, SWT.NONE);
		selectedLevelLabel.setText("Select level(s) to be filtered");
		selectedLevelLabel.setLayoutData(data);

		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		selectedLevelList = new ListViewer(container, SWT.V_SCROLL
				| SWT.H_SCROLL | SWT.MULTI);
		selectedLevelList.getControl().setLayoutData(data);
		ObservableListContentProvider contentProvider = new ObservableListContentProvider();
		selectedLevelList.setContentProvider(new ArrayContentProvider());
		selectedLevelList.setInput(ELogLevel.values());

		initBinding();
		return container;
	}

	private void initBinding() {
		DataBindingContext ctx = new DataBindingContext();
		/* create binding for list with possible extensions */
		IObservableList listTarget = ViewersObservables
				.observeMultiPostSelection(selectedLevelList);
		IObservableList listModel = BeanProperties.list(
				FilterByLevelDialogModel.class,
				FilterByLevelDialogModel.PROPERTY_SELECTED_LEVELS).observe(
				model);
		ctx.bindList(listTarget, listModel);
	}

	@Override
	protected void okPressed() {
		this.logic.setLevelsToFilter(this.model.getSelectedLevels());
		super.okPressed();
	}
}
