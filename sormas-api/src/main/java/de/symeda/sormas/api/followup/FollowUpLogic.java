/*******************************************************************************
 * SORMAS® - Surveillance Outbreak Response Management & Analysis System
 * Copyright © 2016-2018 Helmholtz-Zentrum für Infektionsforschung GmbH (HZI)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *******************************************************************************/
package de.symeda.sormas.api.followup;

import java.util.Date;

import de.symeda.sormas.api.utils.DateHelper;

public final class FollowUpLogic {

	public static final int ALLOWED_DATE_OFFSET = 30;

	private FollowUpLogic() {
		// Hide Utility Class Constructor
	}

	public static int getNumberOfRequiredVisitsSoFar(Date reportDate, Date followUpUntil) {

		if (followUpUntil == null) {
			return 0;
		}

		Date now = new Date();
		if (now.before(followUpUntil)) {
			return DateHelper.getDaysBetween(DateHelper.addDays(reportDate, 1), now);
		} else {
			return DateHelper.getDaysBetween(DateHelper.addDays(reportDate, 1), followUpUntil);
		}
	}
}
