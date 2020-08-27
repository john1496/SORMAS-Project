package de.symeda.sormas.api.campaign.data;

import de.symeda.sormas.api.i18n.I18nProperties;

public enum CampaignFormElementImportance {
    ALL,
    IMPORTANT;

    public String toString() {
        return I18nProperties.getEnumCaption(this);
    }
}
