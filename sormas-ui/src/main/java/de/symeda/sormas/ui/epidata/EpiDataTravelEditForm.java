package de.symeda.sormas.ui.epidata;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

import de.symeda.sormas.api.epidata.EpiDataTravelDto;
import de.symeda.sormas.ui.utils.AbstractEditForm;
import de.symeda.sormas.ui.utils.DateComparisonValidator;
import de.symeda.sormas.ui.utils.FieldHelper;
import de.symeda.sormas.ui.utils.LayoutUtil;

@SuppressWarnings("serial")
public class EpiDataTravelEditForm extends AbstractEditForm<EpiDataTravelDto> {
	
	private static final String HTML_LAYOUT = 
			LayoutUtil.fluidRowLocs(EpiDataTravelDto.TRAVEL_DATE_FROM, EpiDataTravelDto.TRAVEL_DATE_TO) +
			LayoutUtil.fluidRowLocs(EpiDataTravelDto.TRAVEL_TYPE, EpiDataTravelDto.TRAVEL_DESTINATION)
	;
	
	public EpiDataTravelEditForm() {
		super(EpiDataTravelDto.class, EpiDataTravelDto.I18N_PREFIX);
		
		setWidth(540, Unit.PIXELS);
	}
	
	@Override
	protected void addFields() {
		DateField travelDateFrom = addField(EpiDataTravelDto.TRAVEL_DATE_FROM, DateField.class);
		DateField travelDateTo = addField(EpiDataTravelDto.TRAVEL_DATE_TO, DateField.class);
		travelDateFrom.addValidator(new DateComparisonValidator(travelDateFrom, travelDateTo, true, true, "The " + travelDateFrom.getCaption() + " can not be later than the " + travelDateTo.getCaption() + "."));
		travelDateTo.addValidator(new DateComparisonValidator(travelDateTo, travelDateFrom, false, true, "The " + travelDateTo.getCaption() + " can not be earlier than the " + travelDateFrom.getCaption() + "."));
		addField(EpiDataTravelDto.TRAVEL_TYPE, ComboBox.class);
		addField(EpiDataTravelDto.TRAVEL_DESTINATION, TextField.class);
		
		FieldHelper.addSoftRequiredStyle(travelDateFrom, travelDateTo);
	}
	
	@Override
	protected String createHtmlLayout() {
		return HTML_LAYOUT;
	}

}
